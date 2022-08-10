<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
<title>SAMPLE CRUD</title>
</head>
<body>
<%-- <div class="container">
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
	
</div> --%>
<br>
<br>
<div class = "container">
    <div class = "row">
        <div class ="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class = "text-center"> Create New User </h1>
            <div class = "card-body">
                <html:form action="/add-user" method="POST">

                    <div class ="form-group">
                        <label> Username </label>
                        <input type = "text" name="username" class = "form-control"
                        />
                    </div>
                    <div class ="form-group">
                        <label> Password </label>
                        <input type = "password" name="password" class = "form-control"
                        />
                    </div>
                    <div class ="form-group">
                        <label> Fullname </label>
                        <input type = "text" name="fullname" class = "form-control"
                        />
                    </div>
                    <div class ="form-group">
                        <label> Age </label>
                        <input type = "text" name="age" class = "form-control"
                        />
                    </div>
                    <div class ="form-group">
                        <label> Email </label>
                        <input type = "text" name="email" class = "form-control"
                        />
                    </div>
                    <div class = "box-footer">
                        <button type="submit" class = "btn btn-primary">
                            Submit
                        </button>
                        <button class="btn btn-success"><html:link style="text-decoration: none;color: white" action="/home.html">Back</html:link></button>
                    </div>
                </html:form>
					
					
            </div>
        </div>
    </div>
</div>	
</body>
</html>