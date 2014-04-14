<html ng-app>
<head>
  <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.0-beta.3/angular.min.js"></script>
  <script>
  function testController($scope, $http) {
		    $http.get('http://localhost:8080/client-web/testJSON').success(function(data) {
		            $scope.test = data;
		        });
		}
	</script>
<title>Insert title here</title>
</head>
<body>
	
	<div ng-controller="testController">
		<p>Message : {{test.message}}</p>
    </div>
</body>
</html>