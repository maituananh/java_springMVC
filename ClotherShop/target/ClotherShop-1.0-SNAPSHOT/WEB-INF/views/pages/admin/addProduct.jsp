<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
	.new > i {
		color: #15aabf;
	}
	
	.new {
		background-color: white;
		border-color: white;
		border-style: solid;
		font-size: 12px;
		color: #0d59af;
		margin-right: 20px;
	}
	
	.addNewProducer {
		position: absolute;
		top: 72px;
		margin-left: 230px;
		display: none;
	}
	
	.alert {
		display: none;
		position: fixed;
		z-index: 1;
		text-align: center;
		top: 55px;
		font-weight: bold;
		font-size: larger;
		font-variant: small-caps;
	}
	
	.btn, .btn:hover {
		color: white;
	}
</style>
<hr>
<div class="alert col-lg-12">
	<strong id="notify"></strong>
</div>
<div class="container">
	<%--    PHẦN THÔNG TIN CHÍNH CỦA SẢN PHẨM     --%>
	<div class="row" id="product-main">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">MAIN INFORMATION OF THE PRODUCT</strong>
				</div>
				<div class="card-body card-block">
					<form class="form-horizontal">
						<div class="row form-group">
							<div class="col col-md-4"><input type="text" placeholder="Code" id="code"
							                                 class="form-control disabled"></div>
							<div class="col col-md-4"><input type="text" placeholder="Name" id="name"
							                                 class="form-control disabled"></div>
							<div class="col col-md-4"><input type="number" placeholder="Price" id="price"
							                                 class="form-control disabled"></div>
						</div>
						<div class="row form-group">
							<div class="col col-md-4">
								<select name="select" class="form-control disabled" id="Producer">
									<option value="">Select Producer</option>
									<c:forEach items="${producerList}" var="producerLists">
										<option value="${producerLists.getIdProducer()}">${producerLists.getNameProducer()}</option>
									</c:forEach>
								</select>
								<button type="button" class="new" id="new-producer"><i
										class="fa fa-plus-square fa-lg"></i></button>
							</div>
							<div class="col col-md-8"><textarea type="text" placeholder="Describe" id="describe"
							                                    style="height: 70px;"
							                                    class="form-control disabled"></textarea>
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-6"><input type="button" value="SAVE"
							                                 id="check-button"
							                                 class="form-control btn btn-info disabled-main"></div>
							<div class="col col-md-6"><input type="button" value="EDIT" disabled id="EDIT"
							                                 style="color: white" ;
							                                 class="form-control btn btn-warning disabled-main"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%--  END ====  PHẦN THÔNG TIN CHÍNH CỦA SẢN PHẨM     --%>
	
	<%--     PHẦN THÊM MỚI NHÀ SẢN XUẤT CỦA PHẦN CHÍNH SẢN PHẨM      --%>
	<div class="addNewProducer row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title" id="title-producer">title</strong>
				</div>
				<div class="card-body card-block">
					<div class="form-group row">
						<div class="col-lg-6 col-md-6">
							<input id="newItem-producer" type="text" name=""
							       placeholder="ADD NEW NAME"
							       class="text-center form-control">
						</div>
						<div class="col-lg-6 col-md-6">
							<input id="newItem-producer-address" type="text" name=""
							       placeholder="ADD NEW ADDRESS"
							       class="text-center form-control">
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col col-md-6" style="float: left">
							<button class="btn btn-lg btn-success form-control" id="save-producer" type="button"
							        style="line-height: 50%">Save
							</button>
						</div>
						<div class="col col-md-6" style="float: left">
							<button class="btn btn-lg btn-danger form-control" id="close-producer" type="button"
							        style="line-height: 50%">Closed
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%--   END =====  PHẦN THÊM MỚI NHÀ SẢN XUẤT CỦA PHẦN CHÍNH SẢN PHẨM      --%>
	
	<%--    PHẦN THÔNG TIN CHI TIẾT CỦA SẢN PHẨM     --%>
	<div class="row product-details" style="display: none" id="details">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">PRODUCT DETAILS</strong>
				</div>
				<div class="card-body card-block">
					<form class="form-horizontal" style="width: 50%; float: left">
						<div style="display: none">
							<input id="idOfDetails" type="text" value="">
						</div>
						<div class="row form-group">
							<div class="col col-md-10">
								<select name="color" id="color" class="form-control disabled-ProductDetails">
									<option value="">-- Select Color --</option>
									<c:forEach items="${colorList}" var="colorLists">
										<option value="${colorLists.getIdColor()}">${colorLists.getNameColor()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col col-md-2">
								<button type="button" class="new" id="new-color"><i class="fa fa-plus-square fa-lg"></i>
								</button>
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col col-md-10">
								<select name="size" id="size" class="form-control disabled-ProductDetails">
									<option value="">-- Select Size --</option>
									<c:forEach items="${sizeList}" var="sizeLists">
										<option value="${sizeLists.getIdSize()}">${sizeLists.getNumber()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col col-md-2">
								<button type="button" class="new" id="new-size"><i class="fa fa-plus-square fa-lg"></i>
								</button>
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col col-md-10">
								<select name="kind" id="kind" class="form-control disabled-ProductDetails">
									<option value="">-- Select Kind --</option>
									<c:forEach items="${kindList}" var="kindLists">
										<option value="${kindLists.getIdKind()}">${kindLists.getNameKind()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col col-md-2">
								<button type="button" class="new" id="new-kind"><i class="fa fa-plus-square fa-lg"></i>
								</button>
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col col-md-10">
								<input type="number" class="form-control disabled-ProductDetails" id="quality"
								       placeholder="Quality of product">
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col col-md-10">
								<input type="file" name="image" id="file"
								       class="form-control file-upload disabled-ProductDetails">
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col col-md-5" id="box-button-save">
								<button id="save-product" class="btn btn-lg btn-primary" type="button"><i
										class="fa fa-save"></i> Save this
								</button>
							</div>
							<div class="col col-md-5" style="display: none" id="box-button-update">
								<button id="update-product" class="btn btn-lg btn-warning" type="button"><i
										class="fa fa-edit"></i> Update this
								</button>
							</div>
							<div class="col col-md-5 save-all" style="display: none">
								<button style="float: right" id="save-product-data" class="btn btn-lg btn-success"
								        type="button">
									<i class="fa fa-download"></i> Save all
								</button>
							</div>
						</div>
					</form>
					<div class="col col-md-6" style="float: right; height: auto">
						<div class="text-center">
							<img id="showImage" src="<c:url value="/resources/images/default_image.jpg"/>"
							     class="avatar img-circle img-thumbnail" alt="avatar" style="height: 336px;">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%--  END ======  PHẦN THÔNG TIN CHI TIẾT CỦA SẢN PHẨM     --%>
	
	<%--	PHẦN THÊM MỚI CÁC ITEMS TRONG PHẦN CHI TIẾT SẢN PHẨM	--%>
	<div class="row addNewItems" style="position: absolute; top: 390px; margin-left: 270px; display: none">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title" id="title">title</strong>
				</div>
				<div class="card-body card-block">
					<div class="form-group row">
						<div class="col-lg-12 col-md-12">
							<input id="newItem" type="text" placeholder="ADD NEW NAME" class="text-center form-control">
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col col-md-6" style="float: left">
							<button class="btn btn-lg btn-success form-control" id="save" type="button"
							        style="line-height: 50%">Save
							</button>
						</div>
						<div class="col col-md-6" style="float: left">
							<button class="btn btn-lg btn-danger form-control" id="close" type="button"
							        style="line-height: 50%">Closed
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- END =====	PHẦN THÊM MỚI CÁC ITEMS TRONG PHẦN CHI TIẾT SẢN PHẨM	--%>
	
	<div style="display: none" class="showTable">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Color</th>
					<th>Size</th>
					<th>Kind</th>
					<th>Quality</th>
					<th>image</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="newProductDetails">
			</tbody>
		</table>
	</div>
</div>
<!--END CONTENT-->
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
    
    // nếu trang reload thì reset Container
    $(window).bind('beforeunload', function()
    {
        $.ajax({
	        url: "resetContainer",
	        type: "GET",
        });
    });
</script>


