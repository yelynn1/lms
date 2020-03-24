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
    <title>Available Courses</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <ul class="navbar-nav">
      	<li class="nav-item">
		   <a class="navbar-brand" href="instructorHome"> Student </a>
		 </li>
        <li class="nav-item">
          <a class="nav-lin" href="/lms/studentHome">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="/lms/showCourses">Available Courses</a>
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
          <h2 class="h2 text-dark">List of Available Courses</h2>
          <br>
          <table class="table text-dark">
            <thead class="thead-light">
              <tr>
                <th>Course Name</th>
                <th>Description</th>
                <th>Instructor</th>
                <th>Access Link</th>
              </tr>
            </thead>
            <tbody>
            
              <c:forEach items="${courses}" var="course">
	            <tr>
	                <td>${course.name}</td>
	                <td>${course.description}</td>
	                <td>${course.instructor}</td>
	                <td><a class="btn btn-link" href="registerCourse/${course.id}">Register</a></td>
	            </tr>
        	</c:forEach>
        	
            </tbody>
          </table>


    </div>

  </body>
</html>
