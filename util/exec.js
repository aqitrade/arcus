var sh = require("execSync");

module.exports = function exec(commands, grunt, quiet) {
	var log = grunt ? grunt.log.write.bind(grunt.log) : console.log;
	commands = typeof commands === "string" ? [commands] : commands;
	var out = "";
	commands.forEach(function(cmd) {
		var result = sh.exec(cmd);
		if (!quiet) {
			result.stdout && log(result.stdout);
			result.stderr && log(result.stderr);
		}
		if (result.code) {
			throw new Error("exit "+result.code);
		} else {
			out += result.stdout;
		}
	});
	return out.slice(0, out.length-1);
};
