<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SAMPLE CRUD</title>
</head>
<body>
<div class="container">
	<h1>Add new User!</h1>
	
	<html:form action="/add-user" method="post">
		<label>Name</label>
		<html:text property="name" name="user"></html:text>
		<br>
		<label>Age</label>
		<html:text property="age" name="user"></html:text>
		<br>
		<label>Email</label>
		<html:text property="email" name="user"></html:text>
		<br>
		<input type="submit" value="Add">
	</html:form>
			<button><html:link action="/home.html">Back</html:link></button>
	
</div>
	
	
</body>
</html>