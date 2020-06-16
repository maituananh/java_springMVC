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
            <h2 class="tittle">Products List</h2>
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
    </div>
    <!--new-arrivals-->
</div>