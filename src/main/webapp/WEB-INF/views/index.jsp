<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>



	<div class="container mt-3">


		<div class="col-md-12">


			<table class="table">
				<thead>
					<tr>
						<th scope="col">S.No.</th>
						<th scope="col">Product Name</th>
						<th scope="col">Description</th>
						<th scope="col">Price</th>
						<th scope="col">Action</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${products }" var="p">
						<tr>
							<th scope="row">1000062${p.id }</th>
							<td>${p.name }</td>
							<td>${p.description }</td>
							<td class="font-weight-bold">&#x20B9;${p.price }</td>
							<td><a href="delete/${p.id }" class="m-3" > <i class="fa-solid fa-trash fa-2x"></i>
							</a> 
							
							<a href="update/${p.id }" > <i class="fa-solid fa-pen-nib fa-2x"></i>
							</a> 
							
							
							</td>


						</tr>
					</c:forEach>

				</tbody>
			</table>

			<div class="container text-center">

				<a href="add-product" class="btn btn-outline-success">Add
					Product</a>


			</div>


		</div>

	</div>





</body>
</html>
