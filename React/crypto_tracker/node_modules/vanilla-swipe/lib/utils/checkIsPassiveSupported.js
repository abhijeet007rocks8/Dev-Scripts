"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.checkIsPassiveSupported = checkIsPassiveSupported;
exports.noop = void 0;

var _createOptions = require("./createOptions");

function checkIsPassiveSupported() {
  var isPassiveSupported = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : false;
  var proxy = {
    isPassiveSupported: isPassiveSupported
  };

  try {
    var options = (0, _createOptions.createOptions)(proxy);
    window.addEventListener('checkIsPassiveSupported', noop, options);
    window.removeEventListener('checkIsPassiveSupported', noop, options);
  } catch (err) {}

  return proxy.isPassiveSupported;
}

var noop = function noop() {};

exports.noop = noop;