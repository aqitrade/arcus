var exec = require("../util/exec");

module.exports = function(grunt) {
	grunt.registerTask("tag", "Tag a new release on master", function(type) {
		type = type || "patch";
		var validTypes = ["patch", "minor", "major"];
		if (!~validTypes.indexOf(type)) {
			grunt.warn(
				"Release type must be one of "+validTypes.join(", "));
		}
		exec([
			"git remote update",
			"git checkout master",
			"git pull --no-rebase --ff-only",
			"npm version "+type+" -m 'Upgrading to %s'",
			"git checkout develop",
			"git pull --no-rebase --ff-only",
			"git merge master"
		], grunt);
	});
	grunt.registerTask("publish", "Publish current develop, master, and tags", function() {
		exec([
			"git push origin develop:develop",
			"git push origin master:master",
			"git push --tags"
		], grunt);
	});
};

