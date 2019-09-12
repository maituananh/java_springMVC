<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card o-hidden border-0 shadow-lg my-5">
	<div class="card-body p-0">
		<!-- Nested Row within Card Body -->
		<div class="row">
			<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
			<div class="col-lg-7">
				<div class="p-5">
					<div class="text-center">
						<h1 class="h4 text-gray-900 mb-4">Update an Account!</h1>
					</div>
					<form class="user" method="post" action="<%=request.getContextPath()%>/Update">
						<div class="form-group row">
							<div style="display: none">
								<input name="id" value="${inForEditUser.getIduser()}">
								<input name="username" value="${inForEditUser.getUsername()}">
							</div>
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input name="name" value="${inForEditUser.getName()}" type="text" class="form-control form-control-user" id="exampleFirstName" >
							</div>
							<div class="col-sm-6">
								<input name="age" value="${inForEditUser.getAge()}" type="number" class="form-control form-control-user" id="exampleLastName">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="password" name="password" value="${inForEditUser.getPassword()}" class="form-control form-control-user" id="exampleInputPassword">
							</div>
							<div class="col-sm-6">
								<input type="password" name="repeatPassword" placeholder="Repeat Password" class="form-control form-control-user" id="exampleRepeatPassword">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="radio" name="role" class="form-control form-control-user" value="1"
								<c:if test="${inForEditUser.getRole().getIdrole() == 1}">
									checked
								</c:if>> Admin
								<input type="radio" name="role" class="form-control form-control-user" value="2"
								<c:if test="${inForEditUser.getRole().getIdrole() != 1}">
								       checked
								</c:if>> User
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-user btn-block">
							Update
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
