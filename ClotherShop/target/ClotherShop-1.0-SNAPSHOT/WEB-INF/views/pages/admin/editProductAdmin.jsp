<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
	.infoMainProduct {
		border-color: red;
		border-style: solid;
	}
	
	label{
		background-color: #0d59af;
		width: 90px;
	}
</style>

<div class="content">
	<div class="animated">
		<div class="infoMainProduct">
			<div class="container">
				<form class="form-inline">
					<div class="form-group">
						<label for="focusedInput" class="col-md-2 control-label">Codes</label>
						<div class="col-md-10">
							<input class="form-control" id="focusedInput" type="text">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-md-2 control-label">Name</label>
						<div class="col-md-10">
							<input class="form-control" id="inputPassword" type="text">
						</div>
					</div>
					<div class="form-group">
						<label for="disabledTextInput" class="col-md-2 control-label">Price</label>
						<div class="col-md-10">
							<input type="number" id="disabledTextInput" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="describe" class="col-md-2 control-label">Describe</label>
						<div class="col-md-10">
							<input type="text" id="describe" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="producer" class="col-md-2 control-label">Producer</label>
						<div class="col-md-10">
							<select id="producer" class="form-control">
								<option>Vô hiệu hóa select</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="Employees" class="col-md-2 control-label">Employees</label>
						<div class="col-md-10">
							<select id="Employees" class="form-control">
								<option>Vô hiệu hóa select</option>
							</select>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div><!-- .animated -->
</div>
