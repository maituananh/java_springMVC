<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>USERNAME</th>
					<th>ROLE</th>
					<th>ACTION</th>
				</tr>
				</thead>
				<tfoot>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>USERNAME</th>
					<th>ROLE</th>
					<th>ACTION</th>
				</tr>
				</tfoot>
				<tbody>
				<c:forEach items="${userList}" var="userLists">
					<tr>
						<td>${userLists.getIduser()}</td>
						<td>${userLists.getName()}</td>
						<td>${userLists.getAge()}</td>
						<td>${userLists.getUsername()}</td>
						<td>${userLists.getRole().getIdrole()}</td>
						<td><a href="deleteUser/${userLists.getIduser()}" style="color: red"><i
								class="far fa-trash-alt"></i></a> &nbsp; &nbsp; &nbsp;
							<a href="viewUpdate/${userLists.getIduser()}" style="color: green"><i
									class="fas fa-user-edit"></i></a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--End Of DataTales Example -->
			

