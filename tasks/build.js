var Q = require("q"),
	_ = require("lodash"),
	path = require("path"),
	fs = require("fs"),
	fs2 = require("fs2"),
	exec = require("child_process").exec;

module.exports = function(grunt) {
	grunt.registerMultiTask('build', 'Run the existing build script from the shell.', function() {
		var done = this.async(),
			options = this.options(),
			data = this.data,
			appDir = grunt.config("appDir");

		function handleSignals() {
			grunt.warn("Process interrupted.");
		}

		overrideSteal(
			grunt, options.stealOverrides

		).then(function() {
			process.on("exit", restoreSteal);
			process.on("SIGINT", handleSignals);
			process.on("SIGTERM", handleSignals);

		}).then(_.partial(execSteal, grunt, {
			steal: options.steal,
			buildjs: options.buildjs,
			entryPoint: data.entryPoint,
			to: data.to,
			log: options.log

		})).then(_.partial(moveFiles, grunt, {
			productionSteal: options.productionSteal,
			to: data.to,
			targets: {
				js: path.join(appDir, data.targets.js || 'production.js'),
				css: path.join(appDir, data.targets.css || 'production.css')
			}

		})).then(function() {
			done();
		}, function(error) {
			grunt.log.verbose.error(error);
			done(false);

		}).fin(
			restoreSteal

		).fin(function() {
			process.removeListener("exit", restoreSteal);
			process.removeListener("SIGINT", handleSignals);
			process.removeListener("SIGTERM", handleSignals);
		});
	});
};

/**
 * Creates an overridden, temporary stealconfig.js, which is restored after
 * the build runs (or fails). Moves the existing stealconfig.js to
 * stealconfig.js.tmp in the root directory.
 */
function overrideSteal(grunt, overrides) {
	var stealPath = process.cwd()+"/stealconfig.js",
		config = _.extend({}, readStealConfig(stealPath), overrides);
	if (config.API) {
		var regex = new RegExp("^"+config.API.root);
		_.forEach(config.API, function(val, key) {
			config.API[key] = val.replace(regex, overrides.apiEndPoint);
		});
	}
	return Q.nfcall(fs.rename, stealPath, stealPath+".tmp").then(function() {
		var fileText = "steal.config("+JSON.stringify(config)+");";
		return Q.nfcall(fs.writeFile, stealPath, fileText);
	});
}

function readStealConfig(stealPath) {
	// NOTE - this will implode spectacularly if anything other than
	//        steal.config(newconfig) is actually used.
	var oldSteal = global.steal,
		config;
	global.steal = {
		config: function(obj) {
			config = obj;
		}
	};
	var module = require(stealPath);
	if (!module.config) { module.config = config; }
	global.steal = oldSteal;
	return module.config;
}

/**
 * Replaces `stealconfig.js` (presumably the overridden one) with the backup
 * in `stealconfig.js.tmp`.
 */
function restoreSteal() {
	// NOTE - This must be sync because we might call it on process exit.
	fs.renameSync("./stealconfig.js.tmp", "./stealconfig.js");
}

/**
 * Actually executes the steal command. Outputs two files called
 * `production.js` and `production.css` to the `opts.to` directory.
 */
function execSteal(grunt, opts) {
	var deferred = Q.defer(),
		command = [opts.steal,
				   opts.buildjs,
				   opts.entryPoint
				  ].concat(
					  opts.to ? ["-to", opts.to] : []
				  ).join(" "),
		child = exec(command, function(error) {
			error ? deferred.reject(error) : deferred.resolve();
		});
	grunt.log.writeln('This might be a good time to get a cup of coffee.');

	var buildFailed = false;
	if(opts.log) {
		child.stdout.setEncoding('utf8');
		child.stdout.on('data', function(chunk) {
			if(/^[^+]*error/i.test(chunk)) {
				// spit out errors
				grunt.log.verbose.or.error(chunk);
				buildFailed = true;
			} else if(/production\.js/.test(chunk)) {
				// let the user know when steal is almost done
				grunt.log.verbose.or.write('\n');
				grunt.log.ok('Writing production.js and production.css.');
			}

			grunt.verbose.write(chunk);
			if (/\+ /.test(chunk)) {
				grunt.verbose.or.write('.');
			}
		});
	}
	return deferred.promise.then(function() {
		if (buildFailed) {
			grunt.warn("Build failed.");
		}
	});
}

/**
 * Moves the `production.js` and `production.css` to their final
 * destinations, with whatever name was configured.
 */
function moveFiles(_grunt, opts) {
	var mkdir = Q.denodeify(fs2.mkdir),
		unlink = Q.denodeify(fs.unlink);
	return mkdir(path.dirname(opts.targets.js), {intermediate: true}).then(function() {
		return Q.nfcall(exec, [
			"cat",
			opts.productionSteal,
			path.join(opts.to, "production.js"),
			">", opts.targets.js
		].join(" "));
	}).then(function() {
		return unlink(path.join(opts.to, "production.js"));
	}).then(function() {
		return mkdir(path.dirname(opts.targets.css), {intermediate: true});
	}).then(function() {
		var cssFile = path.join(opts.to, "production.css");
		return fs.existsSync(cssFile) &&
			fs2.copy(cssFile, opts.targets.css).then(function() {
				return unlink(cssFile);
			});
	});
}
