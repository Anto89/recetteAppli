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

app.controller('AddController', ['$scope', 'Recette', '$routeParams', '$location', '$http', function ($scope, Recette, $routeParams, $location, $http) {
    $scope.recette = new Recette();
    $scope.qteIngdts = [];
    $scope.recette.quantiteIngredients = $scope.qteIngdts;
    
    $scope.steps = ['descriptif', 'ingredients'];
    $scope.step = 0;
    
    // Tous les ingredients.
    $scope.ingredientsList = []; 
    $http.get('./ingredients').then(function(result) {
    	 $scope.ingredientsList = result.data;
	});
    
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
    	$scope.qteIngdts.push($scope.newIngredient);
    	$scope.newIngredient = null;
    }
    
    $scope.isCurrentStep = function(step) {
      return $scope.step === step;
    };

    $scope.setCurrentStep = function(step) {
      $scope.step = step;
    };

    $scope.getCurrentStep = function() {
      return $scope.steps[$scope.step];
    };
    
    $scope.isFirstStep = function() {
        return $scope.step === 0;
    };

    $scope.isLastStep = function() {
        return $scope.step === ($scope.steps.length - 1);
    };

    $scope.getNextLabel = function() {
        return ($scope.isLastStep()) ? 'Submit' : 'Next';
    };

    $scope.handlePrevious = function() {
        $scope.step -= ($scope.isFirstStep()) ? 0 : 1;
    };

    $scope.handleNext = function() {
        if($scope.isLastStep()) {
            alert("Call validation");
        } else {
            $scope.step += 1;
        }
    };
}]);

app.controller('EditController', ['$scope', 'Recette', '$routeParams', '$location', '$http', function ($scope, Recette, $routeParams, $location, $http) {
    $scope.recette = Recette.get({id: $routeParams.id}, function() {
    	$scope.qteIngdts = $scope.recette.quantiteIngredients;
    });
    $scope.saveRecette = function () {
        Recette.update($scope.recette, function () {
            $location.path('/list');
        });
    };
    
    $scope.unites = [{type:'volume', nom:'litre'}, {type:'poids', nom:'gramme'}];
    $scope.addIngredient = function() {
    	$scope.qteIngdts.push($scope.newIngredient);
    	$scope.newIngredient = null;
    }
    
    // Tous les ingredients.
    $scope.ingredientsList = []; 
    $http.get('./ingredients').then(function(result) {
    	 $scope.ingredientsList = result.data;
	});
}]);

app.controller('DisplayController', ['$scope', 'Recette', '$routeParams', function ($scope, Recette, $routeParams) {
    $scope.recette = Recette.get({id: $routeParams.id});
//    Ingredient.getIngredients($routeParams.id).then(function(ingdts) {
//    	$scope.ingredients = ingdts;
//    });
}]);