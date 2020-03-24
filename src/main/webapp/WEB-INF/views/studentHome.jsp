<%@ page import="java.util.List" %>
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
    <title>Student Home</title>
  </head>
  <body>

	  <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <ul class="navbar-nav">
      	<li class="nav-item">
		   <a class="navbar-brand" href="instructorHome"> ${student} | Student </a>
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
    	<h2>Welcome</h2>
    	<br><h4 class = "h4 text-left">Your registered courses:</h4><br>
    	<div class = "row">
			<table class="table text-dark">
            <thead class="thead-primary">
              <tr>
                <th>Course Name</th>
                <th>Description</th>
                <th>Instructor</th>
                <th>Access Link</th>
              </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${student.courses}" var="course">
	            <tr>
	                <td>${course.name}</td>
	                <td>${course.description}</td>
	                <td>${course.instructor}</td>
	                <td><a class="btn btn-link" href = ${course.id}/studentCoursePanel>Access</a></td>
	            </tr>
        	</c:forEach>
      
            </tbody>
          </table>
		</div>
    </div>

  </body>
</html>