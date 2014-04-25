var services = angular.module('services', ['ngResource']);

services.factory('Recette', ['$resource', function ($resource) {
    return $resource('recettes/:id', { 'id': '@id'}, {'update': {method: 'PUT'} });
}]);

services.factory('Ingredient', function($http, $location) {
	return {
		getIngredients : function(id) {
			return $http.get('./recettes/'.concat(id).concat('/ingredients')).then(function(result) {
				return result.data;
			});
		}
	}
})
