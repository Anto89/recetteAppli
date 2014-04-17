<!DOCTYPE html>
<html lang="fr" ng-app="recetteApp">
<head>
    <title>Recette Appli with Spring MVC & AngularJS</title>
    
    <meta charset="UTF-8">
    
    <script type="text/javascript" src="js/libs/angular.js"></script>
    <script type="text/javascript" src="js/libs/angular-route.js"></script>
    <script type="text/javascript" src="js/libs/angular-resource.js"></script>
    
    <script type="text/javascript" src="js/app.js"></script>
    <script type="text/javascript" src="js/controllers.js"></script>
    <script type="text/javascript" src="js/filters.js"></script>
    <script type="text/javascript" src="js/services.js"></script>

    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/animations.css" rel="stylesheet" media="screen">
    
    <style type="text/css">
    .icon{
    	height: 22px;
    	width: auto;
    }
    </style>
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