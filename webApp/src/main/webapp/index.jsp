<!DOCTYPE html>
<html ng-app="recette.app">
<head>
    <title>Recette Appli with Spring MVC & AngularJS</title>
    
    <meta charset="UTF-8">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource.min.js"></script>
    <script type="text/javascript" src="js/recette.js"></script>

    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab' rel='stylesheet' type='text/css'>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="bootstrap/css/bootstrap-glyphicons.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container">

    <div class="jumbotron">
        <h1>Appli démo <span class="glyphicon glyphicon-check pull-right"></span></h1>
        <p class="text-muted">Recette Appli with Spring MVC & AngularJS</p>
    </div>

    <div ng-view></div>

</div>
</body>
</html>