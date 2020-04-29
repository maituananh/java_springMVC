<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <div class="cart-items">
        <div class="container">

            <h2>My Shopping Bag</h2>
            <c:if test="${getAllCartDetailsByIdUser == null}">
                <h1 style="text-align: center">Your Cart Is Empty</h1>
            </c:if>

            <c:if test="${getAllCartDetailsByIdUser != null}">
            <c:forEach items="${getAllCartDetailsByIdUser}" var="getAllCartDetailsByIdUser">
            <script>$(document).ready(function (c) {
                $('.close1').on('click', function (c) {
                    $('.cart-header').fadeOut('slow', function (c) {
                        $('.cart-header').remove();
                    });
                });
            });
            </script>
            <div class="cart-header">
                <div class="close1"></div>
                <div class="cart-sec simpleCart_shelfItem">
                    <div class="cart-item cyc">
                        <img src="images/p15.jpg" class="img-responsive" alt="">
                    </div>
                    <div class="cart-item-info">
                        <h3><a href="#"> ${getAllCartDetailsByIdUser.getIdProductDetails_CD().getProduct().getNameProduct()} </a><span>Pickup time:</span></h3>
                        <ul class="qty">
                            <li><p>Min. order value:</p></li>
                            <li><p>FREE delivery</p></li>
                        </ul>
                        <div class="delivery">
                            <p>Service Charges : $10.00</p>
                            <span>Delivered in 1-1:30 hours</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <!-- checkout -->
</div>