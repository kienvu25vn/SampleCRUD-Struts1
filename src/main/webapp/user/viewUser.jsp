<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SAMPLE CRUD</title>
<style>
	.container{
		text-align: center;
	}
	table{
		margin : 0 auto;
	}
	table , tr , td , th{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<div class="container">
		<h1 style="font-weight=400">LIST USER!</h1>
		<button><html:link action="/create-user.html">Create new User</html:link></button>
		<br>
		<logic:present name="message">
			<bean:write name="message" />
		</logic:present>
		<br>
		<table>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Email</th>
				<th>Option</th>
			</tr>
			<logic:iterate name="list" id="listId">
				<tr>
					<td><bean:write name="listId" property="name"/></td>
					<td><bean:write name="listId" property="age" format="#######"/></td>
					<td><bean:write name="listId" property="email"/></td>
					<td>
						<%-- <html:link action="/edit-product.html" paramName="listId" paramId="idProd" paramProperty="id">Edit</html:link> |  --%>
						<html:link action="/delete-user.html" paramName="listId" paramId="idUser" paramProperty="id" onclick="return confirm('Do you want to delete this user?')">
						Delete</html:link> 
					</td>
				</tr>
			</logic:iterate>
		</table>
	</div>
</body>
</html>