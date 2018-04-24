<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	if (null == application.getAttribute("sirname"))
		application.setAttribute("sirname", "");
	if (null == application.getAttribute("firstname"))
		application.setAttribute("firstname", "");

	String pSirname = request.getParameter("sirname");
	String pFirstname = request.getParameter("firstname");
	
	if (pSirname != null)
		application.setAttribute("sirname", pSirname);
	if (pFirstname != null)
		application.setAttribute("firstname", pFirstname);
%>
<!DOCTYPE html>
<html>
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
			<input type="text" id="sirname" name="sirname" value="<%= application.getAttribute("sirname") %>">
		</div>
		
		<div>
			<label for="firstname">Firstname</label>
			<input type="text" id="firstname" name="firstname" value="<%= application.getAttribute("firstname") %>">
		</div>
	</fieldset>
	
	<button onclick="window.close();">Cancel</button>
	<input type="submit" value="Save">
</form>

</body>
</html>