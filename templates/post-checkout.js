var child = require("child_process"),
	exec = child.exec;

var sha1 = process.argv[2],
	sha2 = process.argv[3];

if (module.id === ".") { 
	var output;
	fileChanged("package.json", function(changed) {
		if (changed) {
			output = true;
			console.log("package.json changed. Updating npm dependencies.");
			updateNpmDeps();
		}
	});
	fileChanged("bower.json", function(changed) {
		if (changed) {
			output = true;
			console.log("bower.json changed. Updating bower dependencies.");
			updateBowerDeps();
		}
	});
	process.on("exit", function() {
		output && process.stdout.write("\nDependencies updated.\n");
	});
}

/**
 * Returns true if a file has changed between sha1 and sha2
 */
function fileChanged(filename, then) {
	var cmd = [
		"git diff --shortstat", sha1, sha2, "--", filename
	].join(" ");
	exec(cmd, function(_error, stdout) {
		then(!!stdout.length);
	});
}

function updateNpmDeps() {
	fork("npm install && npm update");
}

function updateBowerDeps() {
	fork("$(npm bin)/bower install && $(npm bin)/bower update");
}

function fork(cmd) {
	exec(cmd).stdout.on("data", function(data) {
		for (var i = 0; i < data.length; i++) {
			if (data[0] === "\n") {
				process.stdout.write(".");
			}
		}
	});
}
