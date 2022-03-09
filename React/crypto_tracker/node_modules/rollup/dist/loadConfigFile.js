/*
  @license
	Rollup.js v2.69.0
	Wed, 02 Mar 2022 13:21:33 GMT - commit 10dc32678944cb276c2efe781b12350a8e0a5adf


	https://github.com/rollup/rollup

	Released under the MIT License.
*/
'use strict';

require('fs');
require('path');
require('process');
require('url');
const loadConfigFile_js = require('./shared/loadConfigFile.js');
require('./shared/rollup.js');
require('./shared/mergeOptions.js');
require('tty');
require('perf_hooks');
require('crypto');
require('events');



module.exports = loadConfigFile_js.loadAndParseConfigFile;
//# sourceMappingURL=loadConfigFile.js.map
