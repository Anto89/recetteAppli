var controller = angular.module('controller', []);

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
    $scope.order = 'nom';
}]);

app.controller('AddController', ['$scope', 'Recette', '$routeParams', '$location', function ($scope, Recette, $routeParams, $location) {
    $scope.recette = new Recette();
    $scope.ingredients = [];
    $scope.recette.ingdts = $scope.ingredients;
    $scope.saveRecette = function () {
    	Recette.save($scope.recette, function () {
            $location.path('/list');
        });
    };
    
    $scope.rateDifficulteMax = 5;
    $scope.hoveringOver = function(value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.rateDifficulteMax);
      };
      
    $scope.unites = [{type:'volume', nom:'litre'}, {type:'poids', nom:'gramme'}];
    $scope.addIngredient = function() {
    	$scope.ingredients.push($scope.newIngredient);
    	$scope.newIngredient = null;
    }
}]);

app.controller('EditController', ['$scope', 'Recette', '$routeParams', '$location', function ($scope, Recette, $routeParams, $location, $http) {
    $scope.recette = Recette.get({id: $routeParams.id});
    $scope.saveRecette = function () {
        Recette.update($scope.recette, function () {
            $location.path('/list');
        });
    };
}]);

app.controller('DisplayController', ['$scope', 'Recette', '$routeParams', 'Ingredient', function ($scope, Recette, $routeParams, Ingredient) {
    $scope.recette = Recette.get({id: $routeParams.id});
    Ingredient.getIngredients($routeParams.id).then(function(ingdts) {
    	$scope.ingredients = ingdts;
    });
}]);