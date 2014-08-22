var http = require("http"),
	https = require("https"),
	url = require('url'),
	_ = require("lodash"),
	concat = require("concat-stream"),
	StringDecoder = require("string_decoder").StringDecoder,
	zlib = require('zlib');

var stringdecoder = new StringDecoder('utf8');

/**
 * a simple error dump to console, makes more useful logs happen
 * @param err
 */
function dumpError(err) {
	if(typeof err === 'object') {
		if(err.message) {
			console.log('\nMessage: ' + err.message);
		}
		if(err.stack) {
			console.log('\nStacktrace:');
			console.log('====================');
			console.log(err.stack);
		}
	}
	else {
		console.log('dumpError :: argument is not an object');
	}
}

function proxyRequest(target, request, response) {
	var proxyurl, parsed, proxiedRequest, dataMask, reqData, responseData, params;

	proxyurl = target + request.url;
	parsed = url.parse(proxyurl, true);
	dataMask = false;
	params = {};

	request.proxyUrl = proxyurl;

	proxiedRequest = (parsed.protocol === "https:" ? https : http).request({
		hostname: parsed.hostname,
		port: parsed.port,
		path: parsed.path,
		method: request.method,
		rejectUnauthorized: false,
		headers: _.extend({}, request.headers, {host: parsed.hostname})
		//response event
	}).on('response', function(proxyResponse) {
			//response handler (api responses are zipped, other responses are not)
			responseData = concat(function(zipped) {
				try {
					if(zipped.length > 0) {
						response.writeHead(proxyResponse.statusCode, proxyResponse.headers);
						response.end(zipped);
					}
					else {
						response.end();
					}
				}
				catch(e) {
					dumpError(e);
				}
			});

			proxyResponse.pipe(responseData);
		});

	//request error handler
	proxiedRequest.on("error", function(e) {
		response.writeHead(500, {"content-type": "text/html"});
		response.end(e.message, "utf-8");
	});

	//request data handler
	reqData = concat(function(complete) {
		try {
			//this will catch all POST body API endpoints..
			if(complete.length > 0) {
				//sniff the data here
				proxiedRequest.end(complete);
			}
			else {
				proxiedRequest.end();
			}
		} catch(e) {
			dumpError(e);
		}

	});

	//to support POST actions
	request.pipe(reqData);
}

module.exports = function(target) {
	return _.partial(proxyRequest, target);
};
