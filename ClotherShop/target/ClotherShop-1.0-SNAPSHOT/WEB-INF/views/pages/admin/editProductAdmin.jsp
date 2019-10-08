<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
	.input-right > .input-group {
		margin-bottom: 20px;
	}
</style>

<div class="content">
	<div class="animated fadeIn">
		<div class="row row-product-details">
			<%--	 phần thông tin chính của sản phẩm		--%>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">MAIN INFORMATION OF THE PRODUCT</strong>
					</div>
					<div class="card-body card-block">
						<form action="#" method="post" class="form-horizontal main-form">
							<div class="row form-group">
								<div class="col col-md-4"><input type="text" placeholder="Code"
								                                 value="${infoProductDetails.getCodesProduct()}"
								                                 class="form-control disabled"></div>
								<div class="col col-md-4"><input type="text" placeholder="Name"
								                                 value="${infoProductDetails.getNameProduct()}"
								                                 class="form-control disabled"></div>
								<div class="col col-md-4"><input type="number" placeholder="Price"
								                                 value="${Double.parseDouble(infoProductDetails.getPrice())}00"
								                                 class="form-control disabled"></div>
							</div>
							<div class="row form-group">
								
								<div class="col col-md-4">
									<select name="select" class="form-control disabled">
										<option value="${infoProductDetails.getProducer().getIdProducer()}">${infoProductDetails.getProducer().getNameProducer()}</option>
										<option value="1">Option #1</option>
										<option value="2">Option #2</option>
										<option value="3">Option #3</option>
									</select>
								</div>
								<div class="col col-md-4">
									<select name="select" class="form-control disabled">
										<option value="0">Please select user</option>
										<option value="1">Option #1</option>
										<option value="2">Option #2</option>
										<option value="3">Option #3</option>
									</select>
								</div>
								<div class="col col-md-4"><textarea type="text" placeholder="Describe"
								                                    class="form-control disabled">${infoProductDetails.getDescribeProduct()}</textarea>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-6"><input type="button" value="EDIT"
								                                 class="form-control btn btn-info edit-main"></div>
								<div class="col col-md-6"><input type="button" value="DELETE"
								                                 class="form-control btn btn-danger delete-main"></div>
							</div>
						</form>
					</div>
					<div class="card-footer">
						<c:forEach begin="1" end="${infoProductDetails.getProductDetails().size()}" var="i">
							<a href="id<c:out value="${i}"/>" class="btn btn-sm">
								<c:out value="${i}"/>
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
			
			<%--	 phần thông tin chi tiết của sản phẩm		--%>
			<c:forEach items="${infoProductDetails.getProductDetails()}" var="productDetails">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">DETAILED INFORMATION OF THE PRODUCT</strong>
						</div>
						<div class="card-body">
							<div id="pay-invoice">
								<div class="card-body card-block">
									<form action="#" method="post" class="form-horizontal"
									      id="formId${productDetails.getIdProductDetails()}">
										<div class="row form-group">
											<div class="col col-md-12">
												<div class="col col-md-6" style="float: left">
													<img style="float: left" class="avatar"
													     src="<c:url value="/resources/images/${productDetails.getImage().getPath()}"/>">
												</div>
												<div class="col col-md-6 input-right" style="float: left">
													<div class="input-group">
														<div class="input-group-addon"><i
																class="fa fa-sort-numeric-asc"></i></div>
														<input type="text" name="input1-group1"
														       placeholder="Input quality"
														       class="form-control disabled">
													</div>
													<div class="input-group">
														<div class="input-group-addon"><i class="fa fa-paint-brush"></i>
														</div>
														<select name="select" class="form-control disabled">
															<option value="${productDetails.getColor().getIdColor()}">${productDetails.getColor().getNameColor()}</option>
															<option value="1">Option #1</option>
														</select>
													</div>
													<div class="input-group">
														<div class="input-group-addon"><i
																class="fas fa-arrows"></i></div>
														<select name="select" class="form-control disabled">
															<option value="0">Please select size</option>
															<option value="1">Option #1</option>
														</select>
													</div>
													<div class="input-group">
														<div class="input-group-addon"><i class="fa fa-indent"></i>
														</div>
														<select name="select" class="form-control disabled">
															<option value="0">Please select kind</option>
															<option value="1">Option #1</option>
														</select>
													</div>
													<div class="input-group">
														<div class="input-group-addon"><i
																class="fa fa-image"></i></div>
														<input type="file" name="image"
														       class="form-control file-upload disabled">
													</div>
												</div>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-6"><input type="button" value="EDIT"
											                                 onClick="$(this).editDetails('${productDetails.getIdProductDetails()}');"
											                                 id="${productDetails.getIdProductDetails()}"
											                                 class="form-control btn btn-info edit-details-"${productDetails.getIdProductDetails()}>
											</div>
											<div class="col col-md-6"><input type="button" value="DELETE"
											                                 class="form-control btn btn-danger delete-details-"${productDetails.getIdProductDetails()}>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script>
    $(document).ready(function () {
        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('.avatar').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $(".file-upload").on('change', function () {
            readURL(this);
        });
    });//end
</script>
