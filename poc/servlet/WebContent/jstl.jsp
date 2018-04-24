<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<c:if test="${fn eq null}">
	<c:set var = "fn" value="" scope="application"/>
</c:if>
<c:if test="${not empty param.firstname}">
	<c:set var = "fn" value="${param.firstname}" scope="application"/>
</c:if>
<c:if test="${sn eq null}">
	<c:set var = "sn" value="" scope="application"/>
</c:if>
<c:if test="${not empty param.sirname}">
	<c:set var = "sn" value="${param.sirname}" scope="application"/>
</c:if>


<head>
<meta charset="UTF-8">
<title>User Form</title>
<link rel="stylesheet"  type="text/css" href="style.css">
</head>
<body>

<form method="post" action="">
	<fieldset><legend>User Details</legend>
		<div>
			<label for="sirname">Sirname</label>
			<input type="text" id="sirname" name="sirname" value="${sn}">
		</div>
		
		<div>
			<label for="firstname">Firstname</label>
			<input type="text" id="firstname" name="firstname" value="${fn}">
		</div>
	</fieldset>
	
	<button onclick="window.close();">Cancel</button>
	<input type="submit" value="Save">
</form>

</body>
</html>