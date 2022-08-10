<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>SAMPLE CRUD</title>
<link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 style="font-weight=400">LIST USER!</h1>
		<button class="btn-primary"><html:link action="/create-user.html" style="text-decoration: none;color: white">Create new User</html:link></button>
		<br>
		<logic:present name="message">
			<bean:write name="message" />
		</logic:present>
		<br>
		<div class="table-responsive">
			<div>
				<table class="table table-bordered ">
					<thead class="thead-dark">
						<tr>
							<th >FullName</th>
							<th >Age</th>
							<th >Email</th>
							<th >Option</th>
						</tr>
					</thead>
						<logic:iterate name="list" id="listId">
							<tr>
								<td><bean:write name="listId" property="fullname"/></td>
								<td><bean:write name="listId" property="age" format="#######"/></td>
								<td><bean:write name="listId" property="email"/></td>
								<td>
									<%-- <html:link action="/edit-product.html" paramName="listId" paramId="idProd" paramProperty="id">Edit</html:link> |  --%>
									<button class="btn-danger"><html:link style="text-decoration: none;color: white" action="/delete-user.html" paramName="listId" paramId="idUser" paramProperty="id" onclick="return confirm('Do you want to delete this user?')">
									Delete</html:link></button>
								</td>
							</tr>
						</logic:iterate>
				</table>
			</div>
		</div>
	</div>
</body>
</html>