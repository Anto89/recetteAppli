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
    $scope.newIngredient = {};
    $scope.qteIngdts = [];
    $scope.recette.quantiteIngredients = $scope.qteIngdts;
    
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
    	$scope.newIngredient = {};
    }
    
    $scope.wizard = new Wizard(0, ['descriptif', 'ingredients'], $scope.saveRecette); 
}]);

app.controller('EditController', ['$scope', 'Recette', '$routeParams', '$location', '$http', function ($scope, Recette, $routeParams, $location, $http) {
	$scope.newIngredient = {};
	
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
    	$scope.newIngredient = {};
    }
    
    // Tous les ingredients.
    $scope.ingredientsList = []; 
    $http.get('./ingredients').then(function(result) {
    	 $scope.ingredientsList = result.data;
	});
    
    $scope.wizard = new Wizard(0, ['descriptif', 'ingredients'], $scope.saveRecette);
}]);

app.controller('DisplayController', ['$scope', 'Recette', '$routeParams', function ($scope, Recette, $routeParams) {
    $scope.recette = Recette.get({id: $routeParams.id});
//    Ingredient.getIngredients($routeParams.id).then(function(ingdts) {
//    	$scope.ingredients = ingdts;
//    });
}]);

var Wizard = function() {
	// constructor
    var wizard = function(firstStep, stepNames, validatingFunc) {
		this.step = firstStep;
		this.steps = stepNames;
		this.validatingFunc = validatingFunc;
	};

    // prototype
	wizard.prototype = {
        constructor: wizard
    };
	
	wizard.prototype.isCurrentStep = function(clickedStep) {
	      return this.step === clickedStep;
	};
	wizard.prototype.setCurrentStep = function(clickedStep) {
		this.step = clickedStep;
    };
    wizard.prototype.getCurrentStep = function() {
      return this.steps[this.step];
    };
    
    wizard.prototype.isFirstStep = function() {
        return this.step === 0;
    };
    wizard.prototype.isLastStep = function() {
        return this.step === (this.steps.length - 1);
    };
    wizard.prototype.getNextLabel = function() {
        return (this.isLastStep()) ? 'Submit' : 'Next';
    };
    wizard.prototype.handlePrevious = function() {
    	this.step -= (this.isFirstStep()) ? 0 : 1;
    };
    wizard.prototype.handleNext = function() {
        if(this.isLastStep()) {
        	this.validatingFunc();
        } else {
        	this.step += 1;
        }
    };
    
    return wizard;
}();