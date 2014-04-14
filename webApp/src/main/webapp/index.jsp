<html>
<head>
  <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.0-beta.3/angular.min.js"></script>
  <script>
  angular.module("recetteApp", []).controller("testController", function($scope) {
    $scope.test = {};
    $scope.test.message = "Test avec Angular JS";
    });
	</script>
</head>
<body ng-app="recetteApp">
	<div ng-controller="testController">
		<h2>{{ test.message }} !</h2>
		
		<a href="test">Test Spring Rest + Angular</a>
	</div>
</body>
</html>
