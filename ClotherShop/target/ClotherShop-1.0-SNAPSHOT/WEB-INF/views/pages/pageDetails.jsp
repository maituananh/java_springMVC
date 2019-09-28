<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- cart -->
<script defer src="<c:url value="/resources/js/jquery.flexslider.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/flexslider.css"/>" type="text/css" media="screen"/>
<script src="<c:url value="/resources/js/imagezoom.js"/>"></script>
<script>
    // Can also be used with $(document).ready()
    $(window).load(function () {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>
<style>
	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
		text-align: center;
		font-size: large;
	}
	
	td, th {
		border: 1px solid #dddddd;
		padding: 8px;
	}
	
	tr:nth-child(even) {
		background-color: #dddddd;
	}
</style>
<div class="content">
	<!--single-->
	<div class="single-wl3">
		<div class="container">
			<div class="single-grids">
				<div class="col-md-9 single-grid">
					<div clas="single-top">
						<div class="single-left">
							<div class="flexslider">
								<div class="flex-viewport" style="overflow: hidden; position: relative;">
									<ul class="slides"
									    style="width: 1000%; transition-duration: 0s; transform: translate3d(-386px, 0px, 0px);">
										<c:forEach items="${infoProduct.getProductDetails()}" var="productDetails">
											<li data-thumb="<c:url value="/resources/images/${productDetails.getImage().getPath()}"/>"
											    style="width: 386px; float: left; display: block;"
											    class="flex-active-slide">
												<div class="thumb-image"><img
														src="<c:url value="/resources/images/${productDetails.getImage().getPath()}"/>"
														alt="if!=1"
														data-imagezoom="true"
														class="img-responsive" draggable="false">
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
								<ul class="flex-direction-nav">
									<li class="flex-nav-prev"><a class="flex-prev" href="#">Previous</a></li>
									<li class="flex-nav-next"><a class="flex-next" href="#">Next</a></li>
								</ul>
							</div>
						</div>
						<div class="single-right simpleCart_shelfItem">
							<h4>${infoProduct.getNameProduct()}</h4>
							<p class="price item_price">$ ${infoProduct.getPrice()}00</p>
							<div class="description">
								<p><span>Quick Overview : </span>${infoProduct.getDescribeProduct()}</p>
							</div>
							<div class="women0" style="margin-top: 30px;">
								<table>
									<tr>
										<th>Size</th>
										<th>Color</th>
										<th>Quality</th>
										<th>Add Cart</th>
									</tr>
									<c:forEach items="${infoProduct.getProductDetails()}" var="productDetails">
										<tr>
											<td>${productDetails.getSize().getNumber()}</td>
											<td>${productDetails.getColor().getNameColor()}</td>
											<td>${productDetails.getQuality()}</td>
											<td>
												<a href="addcart?idProductDetails=${productDetails.getIdProductDetails()}"><i
														style="color: green; text-decoration: none; font-size: larger"
														class="fa fa-cart-plus"></i></a></td>
										</tr>
									</c:forEach>
								</table>
							</div>
							<div class="social-icon">
								<a href="#"><i class="icon"></i></a>
								<a href="#"><i class="icon1"></i></a>
								<a href="#"><i class="icon2"></i></a>
								<a href="#"><i class="icon3"></i></a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-3 single-grid1">
					<h3>Recent Products</h3>
					<c:forEach items="${recentProducts}" var="recentProducts">
						<div class="recent-grids" style="margin-bottom: 10px">
							<div class="recent-left">
								<a href="productDetails?id=${recentProducts.getIdProduct()}">
									<c:forEach items="${recentProducts.getProductDetails()}"
									           var="recentProductsDetails" varStatus="status">
									<c:if test="${status.first}">
									<img class="img-responsive"
									     src="<c:url value="/resources/images/${recentProductsDetails.getImage().getPath()}"/>"
									     alt="${recentProductsDetails.getImage().getPath()}"></a>
								</c:if>
								</c:forEach>
							</div>
							<div class="recent-right">
								<h6 class="best2"><a>${recentProducts.getNameProduct()}</a></h6>
								<div class="block">
									<div class="starbox small ghosting">
										<div class="positioner">
											<div class="stars">
												<div class="ghost" style="display: none; width: 42.5px;"></div>
												<div class="colorbar" style="width: 42.5px;"></div>
												<div class="star_holder">
													<div class="star star-0"></div>
													<div class="star star-1"></div>
													<div class="star star-2"></div>
													<div class="star star-3"></div>
													<div class="star star-4"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<span class=" price-in1"> $ ${recentProducts.getPrice()}00</span>
							</div>
							<div class="clearfix"></div>
						</div>
					</c:forEach>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--Product Description-->
			
			<!--Product Description-->
		</div>
	</div>
	<!--single-->
	<div class="new-arrivals-w3agile">
		<div class="container">
			<h3 class="tittle1">Best Sellers</h3>
			<div class="arrivals-grids">
				<div class="col-md-3 arrival-grid simpleCart_shelfItem">
					<div class="grid-arr">
						<div class="grid-arrival">
							<figure>
								<a href="single.html">
									<div class="grid-img">
										<img src="images/p28.jpg" class="img-responsive" alt="">
									</div>
									<div class="grid-img">
										<img src="images/p27.jpg" class="img-responsive" alt="">
									</div>
								</a>
							</figure>
						</div>
						<div class="ribben">
							<p>NEW</p>
						</div>
						<div class="ribben1">
							<p>SALE</p>
						</div>
						<div class="block">
							<div class="starbox small ghosting">
								<div class="positioner">
									<div class="stars">
										<div class="ghost" style="display: none; width: 42.5px;"></div>
										<div class="colorbar" style="width: 42.5px;"></div>
										<div class="star_holder">
											<div class="star star-0"></div>
											<div class="star star-1"></div>
											<div class="star star-2"></div>
											<div class="star star-3"></div>
											<div class="star star-4"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="women">
							<h6><a href="single.html">Sed ut perspiciatis unde</a></h6>
							<span class="size">XL / XXL / S </span>
							<p>
								<del>$100.00</del>
								<em class="item_price">$70.00</em></p>
							<a href="#" data-text="Add To Cart" class="my-cart-b item_add">Add To Cart</a>
						</div>
					</div>
				</div>
				<div class="col-md-3 arrival-grid simpleCart_shelfItem">
					<div class="grid-arr">
						<div class="grid-arrival">
							<figure>
								<a href="single.html">
									<div class="grid-img">
										<img src="images/p30.jpg" class="img-responsive" alt="">
									</div>
									<div class="grid-img">
										<img src="images/p29.jpg" class="img-responsive" alt="">
									</div>
								</a>
							</figure>
						</div>
						<div class="ribben2">
							<p>OUT OF STOCK</p>
						</div>
						<div class="block">
							<div class="starbox small ghosting">
								<div class="positioner">
									<div class="stars">
										<div class="ghost" style="display: none; width: 42.5px;"></div>
										<div class="colorbar" style="width: 42.5px;"></div>
										<div class="star_holder">
											<div class="star star-0"></div>
											<div class="star star-1"></div>
											<div class="star star-2"></div>
											<div class="star star-3"></div>
											<div class="star star-4"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="women">
							<h6><a href="single.html">Sed ut perspiciatis unde</a></h6>
							<span class="size">XL / XXL / S </span>
							<p>
								<del>$100.00</del>
								<em class="item_price">$70.00</em></p>
							<a href="#" data-text="Add To Cart" class="my-cart-b item_add">Add To Cart</a>
						</div>
					</div>
				</div>
				<div class="col-md-3 arrival-grid simpleCart_shelfItem">
					<div class="grid-arr">
						<div class="grid-arrival">
							<figure>
								<a href="single.html">
									<div class="grid-img">
										<img src="images/s2.jpg" class="img-responsive" alt="">
									</div>
									<div class="grid-img">
										<img src="images/s1.jpg" class="img-responsive" alt="">
									</div>
								</a>
							</figure>
						</div>
						<div class="ribben1">
							<p>SALE</p>
						</div>
						<div class="block">
							<div class="starbox small ghosting">
								<div class="positioner">
									<div class="stars">
										<div class="ghost" style="display: none; width: 42.5px;"></div>
										<div class="colorbar" style="width: 42.5px;"></div>
										<div class="star_holder">
											<div class="star star-0"></div>
											<div class="star star-1"></div>
											<div class="star star-2"></div>
											<div class="star star-3"></div>
											<div class="star star-4"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="women">
							<h6><a href="single.html">Sed ut perspiciatis unde</a></h6>
							<span class="size">XL / XXL / S </span>
							<p>
								<del>$100.00</del>
								<em class="item_price">$70.00</em></p>
							<a href="#" data-text="Add To Cart" class="my-cart-b item_add">Add To Cart</a>
						</div>
					</div>
				</div>
				<div class="col-md-3 arrival-grid simpleCart_shelfItem">
					<div class="grid-arr">
						<div class="grid-arrival">
							<figure>
								<a href="single.html">
									<div class="grid-img">
										<img src="images/s4.jpg" class="img-responsive" alt="">
									</div>
									<div class="grid-img">
										<img src="images/s3.jpg" class="img-responsive" alt="">
									</div>
								</a>
							</figure>
						</div>
						<div class="ribben">
							<p>NEW</p>
						</div>
						<div class="block">
							<div class="starbox small ghosting">
								<div class="positioner">
									<div class="stars">
										<div class="ghost" style="display: none; width: 42.5px;"></div>
										<div class="colorbar" style="width: 42.5px;"></div>
										<div class="star_holder">
											<div class="star star-0"></div>
											<div class="star star-1"></div>
											<div class="star star-2"></div>
											<div class="star star-3"></div>
											<div class="star star-4"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="women">
							<h6><a href="single.html">Sed ut perspiciatis unde</a></h6>
							<span class="size">XL / XXL / S </span>
							<p>
								<del>$100.00</del>
								<em class="item_price">$70.00</em></p>
							<a href="#" data-text="Add To Cart" class="my-cart-b item_add">Add To Cart</a>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--new-arrivals-->
</div>