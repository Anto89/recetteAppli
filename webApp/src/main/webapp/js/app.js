var app = angular.module('recetteApp', ['ngResource', 'ngRoute', 'controller', 'filters', 'services', 'ui.bootstrap']);

app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider.when('/list', {templateUrl: 'views/summary.html', controller: 'ListController'});
    $routeProvider.when('/add', {templateUrl: 'views/add_form.html', controller: 'AddController'});
    $routeProvider.when('/:id/edit', {templateUrl: 'views/add_form.html', controller: 'EditController'});
    $routeProvider.when('/:id', {templateUrl: 'views/display.html', controller: 'DisplayController'});
    $routeProvider.otherwise({redirectTo: '/list'});
    $locationProvider.hashPrefix('!'); // Enable ajax crawling
}]);