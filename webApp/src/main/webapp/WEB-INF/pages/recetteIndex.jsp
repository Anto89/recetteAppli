<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recettes</title>
</head>
<body>
<table>
  <tr>
    <th>Nom</th>
    <th>Avis</th>
  </tr>
  <c:forEach items="${ recettes }" var="recette">
	  <tr>
	    <td>${ recette.name }</td>
<%-- 	    <td>${ rec.avis }</td> --%>
	  </tr>
  </c:forEach>
</table>


</body>
</html>