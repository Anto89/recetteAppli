var app = angular.module('recette.app', ['ngResource']);

// ============================== APPLICATION ==============================

app.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/list', {templateUrl: 'views/summary.html', controller: 'ListController'});
    $routeProvider.when('/add', {templateUrl: 'views/add.html', controller: 'AddController'});
    $routeProvider.when('/:id/edit', {templateUrl: 'views/add.html', controller: 'EditController'});
    $routeProvider.when('/:id', {templateUrl: 'views/display.html', controller: 'DisplayController'});
    $routeProvider.otherwise({redirectTo: '/list'});
    $locationProvider.hashPrefix('!'); // Enable ajax crawling
});

// ============================== RESOURCES ==============================

app.factory('Recette', ['$resource', function ($resource) {
    return $resource(
        'recettes/:id', { 'id': '@id'}, {'update': {method: 'PUT'} });
}]);

// ============================== CONTROLLERS ==============================

app.controller('ListController', ['$scope', 'Recette', '$location', function ($scope, Recette, $location) {
    $scope.recettes = Recette.query();
    $scope.deleteRecette = function (recette) {
    	recette.$delete(function () {
            $location.path("/list");
        });
    };
    $scope.updateRecette = function (recette) {
    	recette.$update(function () {
            $location.path('/list');
        });
    };
}]);

app.controller('AddController', ['$scope', 'Recette', '$routeParams', '$location', function ($scope, Recette, $routeParams, $location) {
    $scope.recette = new Recette();
    $scope.saveRecette = function () {
    	Recette.save($scope.recette, function () {
            $location.path('/list');
        });
    };
}]);

app.controller('EditController', ['$scope', 'Recette', '$routeParams', '$location', function ($scope, Recette, $routeParams, $location) {
    $scope.recette = Recette.get({id: $routeParams.id});
    $scope.saveRecette = function () {
        Recette.update($scope.recette, function () {
            $location.path('/list');
        });
    };
}]);

app.controller('DisplayController', ['$scope', 'Recette', '$routeParams', function ($scope, Recette, $routeParams) {
    $scope.recette = Recette.get({id: $routeParams.id});
}]);