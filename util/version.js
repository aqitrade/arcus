var _exec = require("./exec");

/**
 * Returns a reasonable version according to the current semver tags on the
 * current git repository. Tags must be in `vX.Y.Z` format.
 *
 * Returned tags will include a `-bebebe` suffix if the current commit is
 * not tagged.
 */
module.exports = function version(grunt) {
	var exec = function(cmd) {
		try {
			return _exec(cmd, grunt, true);
		} catch(e) {
			return "";
		}
	};
	var jenkinsTag = exec("git tag --contains | sort -r | grep -m 1 jenkins");
	var tag;
	for (var i = 0; i < Number(exec("git rev-list --count HEAD")); i++) {
		tag = exec("git tag --contains HEAD~" + i +
					   "| grep -m 1 -E 'v\\d+\\.\\d+\\.\\d+'") || tag;
		if (tag) {
			break;
		}
	}
	if (!tag) {
		// If there was no regular version tag, just give me a sha1;
		tag = exec("git rev-parse --short HEAD");
	} else if (i > 0) {
		tag += "-"+exec("git rev-parse --short HEAD");
	}
	return tag + (jenkinsTag && jenkinsTag.replace(/^.*-(\d+)$/, "-$1") || "");
};
