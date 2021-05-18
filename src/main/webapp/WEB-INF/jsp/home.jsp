<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/home.css">
</head>
<body>
<body class="p-0 m-0">
	<c:import url="./header.jsp"></c:import>

	<div class="container p-0">

		<div class="text-center mt-5 row">
			<div class="col-lg-4">
				<h2>Welcome ${username} !</h2>
			</div>
			<div class="offset-lg-4 col-lg-4 col-sm-12">
				<a class="btn btn-danger px-5" href="/logout">Logout</a>
			</div>

		</div>

		<div class="container mt-3">
			<fieldset class="fieldset-custom px-5">
				<legend class="legend-custom">Employee Listings</legend>



				<div class="row">
					<div class="col-lg-6 p-0 col-sm-12">
						<form action="/excel" method="post" enctype="multipart/form-data">

							<div class="custom-file w-50 ">
								<input type="file" name="file" class="custom-file-input "
									required onchange="setfilename(this.value);"> <label
									class="custom-file-label" id="divFileName"> CSV File </label>
							</div>
							<button class="btn btn-warning d-inline" type="submit">Upload</button>
						</form>

					</div>
					<div class="offset-lg-4 col-lg-2 p-0">
						<a class="btn btn-success px-5 col-sm-12" href="/excel"
							target="_blank">Download</a>
					</div>



				</div>

				<h3 class="font-weight-bold mt-4 mb-4 font-size-25px">Employees
					Table</h3>
				<div class="row ">
					<table summary="This table shows the list of the employees">
						<thead>
							<tr>
								<th scope="row">S.No.</th>
								<th scope="row">Code</th>
								<th scope="row">Name</th>
								<th scope="row">Location</th>
								<th scope="row">Email</th>
								<th scope="row">Date Of Birth</th>
								<th scope="row">Action</th>
							</tr>
						</thead>
						<c:forEach items="${employees}" var="employee" varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td>${employee.code}</td>
								<td>${employee.name}</td>
								<td>${employee.location}</td>
								<td>${employee.email}</td>
								<td>${employee.dateOfBirth}</td>
								<td><a href="/employee/${employee.code}"> Edit </a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</fieldset>
		</div>
	</div>

	<br>
	<br>
	<br>

	<c:import url="./footer.jsp"></c:import>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>

	<script src="/js/home.js"></script>

</body>
</html>