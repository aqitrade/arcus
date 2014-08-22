var exec = require("../util/exec");
module.exports = function(grunt) {
	grunt.registerTask("loc", "Spit out LOC information", function() {
		exec("cloc src *.md" +
			 "--by-file-by-lang --force-lang=HTML,mustache",
			 grunt);
	});
	grunt.registerTask("deps", "Update project bower and npm dependencies", function() {
		exec([
				"npm install",
				"npm update",
				"$(npm bin)/bower install",
				"$(npm bin)/bower update"
		], grunt);
	});
};
