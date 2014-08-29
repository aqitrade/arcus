var proxy = require("./proxy"),
	url = require("url");

module.exports = function(opts) {
	var proxyUrl = url.resolve(opts.host, opts.path),
		proxyCallback = proxy(proxyUrl);
	return function(request) {
		request.api = true;
		return proxyCallback.apply(this, arguments);
	};
};
