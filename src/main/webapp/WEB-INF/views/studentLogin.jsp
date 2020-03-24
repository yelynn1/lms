<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Student Login</title>
  </head>
  <body>

    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <ul class="navbar-nav">
      	<li class="nav-item">
		   <a class="navbar-brand" href="instructorHome"> Student </a>
		 </li>
        <li class="nav-item">
          <a class="nav-link active" href="/lms/studentHome">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/lms/showCourses">Available Courses</a>
        </li>
       </ul>
       <ul class="navbar-nav ml-auto">
	       <li class="nav-item dropdown active">
	        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Login/Register</a>
			    <div class="dropdown-menu">
			      <a class="dropdown-item" href="/lms/instructorLogin">Instructor</a>
			      <a class="dropdown-item" href="/lms/studentLogin">Student</a>
			      <div class="dropdown-divider"></div>
			      <a class="dropdown-item" href="/lms/logoutStudent">Logout</a>
			    </div>
			</li>
      </ul>
    </nav>

    <div class="container container-fluid" >
    <br>
    
    
    <div class = "row">
      <div class="col-md-5">
	          <h2 class="h2">Student Registeration</h2>
	          <br>
	          <form action="registerStudent" method="post">
	            <div class="form-group">
	              <label for="email">Email address:</label>
	              <input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
	            </div>
	            <div class="form-group">
	              <label for="fullname">Full Name</label>
	              <input type="text" class="form-control" placeholder="Enter full name" id="fullname" name="full_name">
	            </div>
	            <div class="form-group">
	              <label for="pwd">Password:</label>
	              <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password">
	            </div>
	            <button type="submit" class="btn btn-primary">Register</button>
	          </form>
	      </div>
	      
	      <div class="col-md-1"></div>
          
          <div class="col-md-6" >
		          <h2 class="h2">Student Login</h2>
		          	<div class="text-danger"> ${message} </div>
		          <br>
		          <form action="loginStudent" method="post">
		            <div class="form-group">
		              <label for="email">Email address:</label>
		              <input type="email" class="form-control" placeholder="Enter email" id="email" name="username">
		            </div>
		            <div class="form-group">
		              <label for="pwd">Password:</label>
		              <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password">
		            </div>
		            <button type="submit" class="btn btn-primary">Login</button>
		          </form>
		    </div>
		 </div>

    </div>

  </body>
</html>
