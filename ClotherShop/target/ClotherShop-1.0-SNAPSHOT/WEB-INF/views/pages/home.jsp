<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
	.numberPages:hover {
		background-color: #1565c0;
		color: white;
		text-decoration: none;
	}
	
	.numberPages {
		border-style: solid;
		border-color: #F9F8F8;
		width: 25px;
		height: 25px;
		color: #1565c0;
	}
</style>
<div class="content">
	<!--banner-bottom-->
	<div class="ban-bottom-w3l">
		<div class="container">
			<div class="col-md-6 ban-bottom">
				<div class="ban-top">
					<img src="<c:url value="/resources/images/p1.jpg"/>" class="img-responsive" alt="">
					<div class="ban-text">
						<h4><a href="#">Men’s Clothing</a></h4>
					</div>
					<div class="ban-text2 hvr-sweep-to-top">
						<h4>50% <span>Off/-</span></h4>
					</div>
				</div>
			</div>
			<div class="col-md-6 ban-bottom3">
				<div class="ban-top">
					<img src="<c:url value="/resources/images/p2.jpg"/>" class="img-responsive" alt="">
					<div class="ban-text1">
						<h4><a href="#">Women's Clothing</a></h4>
					</div>
				</div>
				<div class="ban-img">
					<div class=" ban-bottom1">
						<div class="ban-top">
							<img src="<c:url value="/resources/images/p3.jpg"/>" class="img-responsive" alt="">
							<div class="ban-text1">
								<h4><a href="#">T - Shirt</a></h4>
							</div>
						</div>
					</div>
					<div class="ban-bottom2">
						<div class="ban-top">
							<img src="<c:url value="/resources/images/p4.jpg"/>" class="img-responsive" alt="">
							<div class="ban-text1">
								<h4><a href="#">Hand Bag</a></h4>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--banner-bottom-->
	<!--new-arrivals-->
	<div class="new-arrivals-w3agile">
		<div class="container">
			<h2 class="tittle">New Arrivals</h2>
			<div class="arrivals-grids">
				<c:forEach items="${listProduct}" var="listProducts">
					<div class="col-md-3 arrival-grid simpleCart_shelfItem" style="margin-bottom: 30px">
						<div class="grid-arr">
							<div class="grid-arrival">
								<figure>
									<a href="productDetails?id=${listProducts.getIdProduct()}" class="new-gri"
									   data-toggle="modal" data-target="#myModal1">
										<% int count = 0; %>
										<c:forEach items="${listProducts.getProductDetails()}" var="listProductsImage">
											<% count++; // chỉ cho phép in ra 2 ảnh để tối ưu
												if (count > 2) {
													break;
												}
											%>
											<div class="grid-img">
												<img src="<c:url value="/resources/images/${listProductsImage.getImage().getPath()}"/>"
												     class="img-responsive"
												     alt="${listProductsImage.getImage().getPath()}">
											</div>
										</c:forEach>
									</a>
								</figure>
							</div>
							<c:forEach items="${idProductNew}" var="idProductNews">
								<c:if test="${idProductNews == listProducts.getIdProduct()}">
									<div class="ribben">
										<p>NEW</p>
									</div>
								</c:if>
							</c:forEach>
							<div class="women">
								<h6>
									<a href="productDetails?id=${listProducts.getIdProduct()}">${listProducts.getNameProduct()}</a>
								</h6>
								<p><em class="item_price">$ ${listProducts.getPrice()}00</em></p>
								<a href="productDetails?id=${listProducts.getIdProduct()}" data-text="Add To Cart"
								   class="my-cart-b item_add">Preview</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
		</div>
		<div>
			<% int count = Integer.parseInt(String.valueOf(request.getAttribute("sizeOfProduct"))); %>
			<% for (int i = 1; i <= count; i++) { %>
			<a href="home-page?page=<%= i - 1 %>" class="numberPages"><%= i %>
			</a>
			<%}%>
		</div>
	</div>
	<!--new-arrivals-->
	<!--accessories-->
	<div class="accessories-w3l">
		<div class="container">
			<h3 class="tittle">20% Discount on</h3>
			<span>TRENDING DESIGNS</span>
			<div class="button">
				<a href="#" class="button1"> Shop Now</a>
				<a href="#" class="button1"> Quick View</a>
			</div>
		</div>
	</div>
	<!--accessories-->
	<!--Products-->
	<div class="product-agile">
		<div class="container">
			<h3 class="tittle1"> New Products</h3>
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides callbacks callbacks1" id="slider">
						<li id="callbacks1_s0" class="callbacks1_on"
						    style="display: block; float: left; position: relative; opacity: 1; z-index: 2; transition: opacity 500ms ease-in-out 0s;">
							<div class="caption">
								<c:forEach items="${recentProducts}" var="newProducts">
									<div class="col-md-3 cap-left simpleCart_shelfItem">
										<div class="grid-arr">
											<div class="grid-arrival">
												<figure>
													<a href="productDetails?id=${newProducts.getIdProduct()}">
														<c:forEach items="${newProducts.getProductDetails()}"
														           var="detailsProduct" varStatus="status">
															<div class="grid-img">
																<img src="<c:url value="/resources/images/${detailsProduct.getImage().getPath()}"/>"
																     class="img-responsive" alt="">
															</div>
															<%--															<c:if test="${status.count == 2}">--%>
															<%--&lt;%&ndash;																<%break;%>&ndash;%&gt;--%>
															<%--															</c:if>--%>
														</c:forEach>
													</a>
												</figure>
											</div>
											<div class="ribben">
												<p>NEW</p>
											</div>
											<div class="women">
												<h6><a href="productDetails?id=${newProducts.getIdProduct()}">
														${newProducts.getNameProduct()}</a></h6>
												<p>
													<em class="item_price">$${newProducts.getPrice()}00</em></p>
												<a href="productDetails?id=${newProducts.getIdProduct()}"
												   data-text="Add To Cart" class="my-cart-b item_add">Preview</a>
											</div>
										</div>
									</div>
								</c:forEach>
								<div class="clearfix"></div>
							</div>
						</li>
						
						<li id="callbacks1_s1" class=""
						    style="float: none; position: absolute; opacity: 0; z-index: 1; display: list-item; transition: opacity 500ms ease-in-out 0s;">
							<div class="caption">
								<c:forEach items="${recentProductsBonus}" var="newProducts">
									<div class="col-md-3 cap-left simpleCart_shelfItem">
										<div class="grid-arr">
											<div class="grid-arrival">
												<figure>
													<a href="productDetails?id=${newProducts.getIdProduct()}">
														<c:forEach items="${newProducts.getProductDetails()}"
														           var="detailsProduct" varStatus="status">
															<div class="grid-img">
																<img src="<c:url value="/resources/images/${detailsProduct.getImage().getPath()}"/>"
																     class="img-responsive" alt="">
															</div>
															<%--															<c:if test="${status.count == 2}">--%>
															<%--&lt;%&ndash;																<%break;%>&ndash;%&gt;--%>
															<%--															</c:if>--%>
														</c:forEach>
													</a>
												</figure>
											</div>
											<div class="ribben">
												<p>NEW</p>
											</div>
											<div class="women">
												<h6>
													<a href="productDetails?id=${newProducts.getIdProduct()}">${newProducts.getNameProduct()}</a>
												</h6>
												<p>
													<em class="item_price">$${newProducts.getPrice()}00</em></p>
												<a href="productDetails?id=${newProducts.getIdProduct()}"
												   data-text="Add To Cart" class="my-cart-b item_add">Preview</a>
											</div>
										</div>
									</div>
								</c:forEach>
								<div class="clearfix"></div>
							</div>
						</li>
					</ul>
					<a href="#" class="callbacks_nav callbacks1_nav prev">Previous</a>
					<a href="#"class="callbacks_nav callbacks1_nav next">Next</a>
					<ul class="callbacks_tabs callbacks1_tabs">
						<li class="callbacks1_s1 callbacks_here"><a href="#" class="callbacks1_s1">1</a></li>
						<li class="callbacks1_s2"><a href="#" class="callbacks1_s2">2</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--Products-->
	
	<div class="new-arrivals-w3agile">
	</div>
	<!--new-arrivals-->
</div>