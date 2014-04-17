var filters = angular.module('filters', ['ngResource']);

filters.filter('regime', function() {
	return function(isVeg) {
		return isVeg ? '\u2713' : '\u2718';
		};
	});