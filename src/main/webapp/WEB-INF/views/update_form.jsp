<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>



	<div class="container">

		<div class="col-md-6 offset-md-3">

			<div class="card">
				<div class="card-header   text-center">
					<span class="fa-solid fa-pen-to-square fa-3x"></span><br>Update
					Product Details
				</div>
				<div class="card-body">

					<form action="${pageContext.request.contextPath }/handle-product" method="post">

						<input type="hidden" value="${product.id}" name="id" />

						<div class="form-group">
							<label for="name">Product Name</label> <input name="name"
								type="text" class="form-control" id="name"
								aria-describedby="name" placeholder="Enter your Name"
								value="${product.name}">
						</div>


						<div class="form-group">
							<label for="description">Product Description</label>
							<textarea name="description" class="form-control"
								id="description" row="5" placeholder="Enter Product Description">${product.description }</textarea>

						</div>

						<div class="form-group">
							<label for="user_name">Price</label> <input name="price"
								type="text" class="form-control" id="price"
								aria-describedby="price" placeholder="Enter price"
								value="${product.price}">
						</div>




						<div class="container text-center">

							<a href=" ${pageContext.request.contextPath }/"
								class="btn btn-outline-danger">Back</a>

							<button id="submit-btn" type="submit"
								class="btn btn-outline-success   ">Update</button>
						</div>
					</form>


				</div>

			</div>

		</div>

	</div>


</body>
</html>