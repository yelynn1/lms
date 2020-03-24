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
    <title>Student List</title>
  </head>
  <body>

  
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <ul class="navbar-nav">
      	<li class="nav-item">
		   <a class="navbar-brand" href="instructorHome">${ instructor } | Instructor </a>
		 </li>
        <li class="nav-item">
          <a class="nav-link active" href="/lms/instructorHome">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/lms/courseCreation">Create Course</a>
        </li>
       </ul>
       <ul class="navbar-nav ml-auto">
	       <li class="nav-item dropdown active">
	        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Login/Register</a>
			    <div class="dropdown-menu">
			      <a class="dropdown-item" href="/lms/instructorLogin">Instructor</a>
			      <a class="dropdown-item" href="/lms/studentLogin">Student</a>
			      <div class="dropdown-divider"></div>
			      <a class="dropdown-item" href="/lms/logoutInstructor">Logout</a>
			    </div>
			</li>
      </ul>
    </nav>

    <div class="container container-fluid" >
    <br>
    	<ul class="list-group">
		  <li class="list-group-item text-primary"><h2> ${ course } </h2></li>
		  <li class="list-group-item text-secondary"> ${ course.description } </li>
		</ul>
    	
    	<br><br>
    	<div class = "h5 text-left">Students: </div>
    	
    	<div class = "row">
			<table class="table text-dark">
            <thead class="thead-primary">
              <tr>
                <th>Full Name</th>
                <th>Email</th>
                
              </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${students}" var="student">
	            <tr>
	                <td>${student.full_name}</td>
	                <td>${student.email}</td>
	                <td><a href="removeStudent/${student.id}">Remove</a>
	            </tr>
        	</c:forEach>
      
            </tbody>
          </table>
		</div>
    </div>

  </body>
</html>