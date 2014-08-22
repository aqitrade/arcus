var Q = require("q"),
	path = require("path"),
	fs = require("fs"),
	fs2 = require("fs2"),
	mkdir = Q.denodeify(fs2.mkdir),
	_ = require("lodash");

module.exports = function(grunt) {
	grunt.registerMultiTask('pages', 'Generate the production version of a page.', function() {
		var done = this.async(),
			data = this.data,
			appDir = grunt.config("appDir"),
			headTpl = grunt.file.read(__dirname+"/../templates/common.head.mustache","utf8");


		function writePageFile(srcFile, dstFile, hrefs) {
			return Q.nfcall(fs.readFile, srcFile).then(function(fileHtml) {
				var fileText = fileHtml.toString();
				return fileText.replace(
						/<script[^">]*".*steal\/steal.js[^>]*>[^<]*<\/script>/,
					'<script src="'+hrefs.js+'" type="text/javascript"></script>'
				).replace(
					//target the closing head tag
					'</head>',

					_.template(headTpl,{
						css : hrefs.css,
						pageName: hrefs.pageName
					},{
						//mustache syntax for replace tokens
						'interpolate': /{{([\s\S]+?)}}/g
					}) + "\n</head>" // and add the tag back in.
				);
			}).then(function(newText) {
				return Q.nfcall(fs.writeFile, dstFile, newText);
			}).then(function success() {
				grunt.log.ok("Wrote " + dstFile);
			}, function fail(err) {
				grunt.log.error("Could not write " + dstFile + ": " + err);
			});
		}

		mkdir(appDir, {intermediate: true}).then(function() {
			return Q.all(data.map(function(page) {
				return writePageFile(
					page.srcFile, path.join(appDir, page.dstFile), page.hrefs);
			}));
		}).then(function() {
			done();
		}, function(err) {
			grunt.log.verbose.error(err);
			done(false);
		});
	});
};
