if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'client-js'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'client-js'.");
}
this['client-js'] = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    println('Hello JavaScript!');
  }
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('client-js', _);
  return _;
}(typeof this['client-js'] === 'undefined' ? {} : this['client-js'], kotlin);
