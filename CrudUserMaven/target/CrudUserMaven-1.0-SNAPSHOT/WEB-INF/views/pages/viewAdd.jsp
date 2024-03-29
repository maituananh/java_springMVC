<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="card o-hidden border-0 shadow-lg my-5">
	<div class="card-body p-0">
		<!-- Nested Row within Card Body -->
		<div class="row">
			<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
			<div class="col-lg-7">
				<div class="p-5">
					<div class="text-center">
						<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
					</div>
					<form class="user" method="post" action="<%=request.getContextPath()%>/add">
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input name="username"  type="text" class="form-control form-control-user" placeholder="Enter User Name">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input name="name" type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="Enter Name">
							</div>
							<div class="col-sm-6">
								<input name="age"  type="number" class="form-control form-control-user" id="exampleLastName" placeholder="Enter Age">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="password" name="password"  class="form-control form-control-user" id="exampleInputPassword" placeholder="Enter Password">
							</div>
							<div class="col-sm-6">
								<input type="password" name="repeatPassword" placeholder="Repeat Password" class="form-control form-control-user" id="exampleRepeatPassword">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="radio" name="role" class="form-control form-control-user" value="1"> Admin
								<input type="radio" name="role" class="form-control form-control-user" value="2"> User
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-user btn-block">
							Save
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>