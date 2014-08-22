var proxy = require("./proxy"),
	url = require("url");

module.exports = function(opts) {
	var proxyUrl = url.resolve(opts.host, opts.path),
		proxyCallback = proxy(proxyUrl),
		mask = opts.mask;
	return function(request) {
		request.mask = mask;
		request.api = true;
		request.headers["Cookie"] = module.exports.cookie;
		return proxyCallback.apply(this, arguments);
	};
};
