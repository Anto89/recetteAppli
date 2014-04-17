var services = angular.module('services', ['ngResource']);

services.factory('Recette', ['$resource', function ($resource) {
    return $resource(
        'recettes/:id', { 'id': '@id'}, {'update': {method: 'PUT'} });
}]);
