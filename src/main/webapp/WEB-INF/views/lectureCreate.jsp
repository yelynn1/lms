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
    <title>Create Lecture</title>
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
          <h2 class="h2">Lecture Creation</h2>
          <h4>${ course }</h4>
          <form action="createLecture" method="POST" enctype="multipart/form-data">
            <div class="form-group">
              <label for="name">Lecture Name</label>
              <input type="text" class="form-control" placeholder="Enter Lecture Name" id="name" name="name">
            </div>
            <div class="form-group">
              <label for="description">Lecture Description</label>
              <textarea class="form-control" placeholder="Enter lecture Description" id="description" name="description"></textarea>
            </div>
            <div class="form-group">
              <label for="file">Lecture Material</label>
              <input type="file" class="btn btn-secondary" id="file" name="file">
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
          </form>


    </div>

  </body>
</html>
