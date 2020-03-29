<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page isELIgnored="false"%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>NTU Learning Management System</title>
  </head>
  <body>

  
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <ul class="navbar-nav">
      	<li class="nav-item">
		   <a class="navbar-brand">Learning Management System</a>
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
			    </div>
			</li>
      </ul>
    </nav>
    
    <div class="container container-fluid">
	    <div class="jumbotron">
		  <h1>NTU Learning Management System</h1>
		  <h4>Start your e-learning journey today</h4>
		  <br><h6>A project of WKWSCI CI6225 Course</h6>
		  <p>Developed by <br> Ye Lynn Khant <br> G1901531J </p>
		</div>
    	<h3 class="text-dark">Let's get started</h3>
    	
    	<div class="row text-center">
    		<div class="col-md-6 card">
    			<a class="btn btn-info card-body"  href="/lms/studentLogin">Student</a>
    		</div>
    		<div class="col-md-6 card">
    			<a class="btn btn-info card-body" href="/lms/instructorLogin">Instructor</a>
    		</div>
    	</div>
    </div>


  </body>
</html>