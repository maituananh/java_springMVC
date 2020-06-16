<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <div class="cart-items">
        <div class="container">
            <c:if test="${getAllCartDetailsByIdUser == null}">
                <h1 style="text-align: center">Your Cart Is Empty</h1>
            </c:if>

            <c:if test="${getAllCartDetailsByIdUser != null}">
                <h2>Your Cart</h2>
            <c:forEach items="${getAllCartDetailsByIdUser}" var="getAllCartDetailsByIdUser">
            <script>
                    function deleteItem(id) {
                        $('#' + id).fadeOut('slow', function (c) {
                            $('#' + id).remove();
                        });
                        $.ajax({
                            url: "delete-cartdetails",
                            type: "POST",
                            data: {
                                idCartDetails: id
                            },
                            success: function () {
                            },
                            error: function () {
                            }
                        })
                    };
                    function changeQuantity(price, idCartDetails) {
                        var quantity = $("#getQuantity-" + idCartDetails).val();
                        if (+quantity > 0) {
                            $("#updatePrice-" + idCartDetails).text("$" + +price * +quantity + ".000");
                            $("#quantity-" + idCartDetails).text("Quantity: " + quantity);
                            $("#quantity-" + idCartDetails).css("font-size","11px");
                            $.ajax({
                                url: "updateQuantityInCartDetails",
                                type: "POST",
                                data: {
                                    idCartDetails: idCartDetails,
                                    quantity: quantity
                                },
                                success: function () {
                                },
                                error: function () {
                                }
                            })
                        }
                    };
            </script>
            <div class="cart-header" id="${getAllCartDetailsByIdUser.getIdCartDetails()}">
                <div class="close1" onclick="deleteItem(${getAllCartDetailsByIdUser.getIdCartDetails()})"></div>

                <div class="cart-sec simpleCart_shelfItem">
                    <div class="cart-item cyc">
                        <img src="images/p15.jpg" class="img-responsive" alt="">
                    </div>

                    <div class="cart-item-info">
                        <h3><a href="productDetails?id=${getAllCartDetailsByIdUser.getIdProductDetails_CD().getProduct().getIdProduct()}">
                                ${getAllCartDetailsByIdUser.getIdProductDetails_CD().getProduct().getNameProduct()} </a>
                            <span>Price: $${getAllCartDetailsByIdUser.getIdProductDetails_CD().getProduct().getPrice()}</span></h3>
                        <ul class="qty">
                            <li><p>Color: ${getAllCartDetailsByIdUser.getIdProductDetails_CD().getColor().getNameColor()}</p></li>
                            <li><p>Size: ${getAllCartDetailsByIdUser.getIdProductDetails_CD().getSize().getNumber()}</p></li>
                            <li><p>Type: ${getAllCartDetailsByIdUser.getIdProductDetails_CD().getKind().getNameKind()}</p></li>
                            <li id="quantity-${getAllCartDetailsByIdUser.getIdCartDetails()}"><p>Quantity: ${getAllCartDetailsByIdUser.getQuantity()}</p></li>
                        </ul>
                        <div class="delivery">
                            <p id="updatePrice-${getAllCartDetailsByIdUser.getIdCartDetails()}">
                                $${getAllCartDetailsByIdUser.getQuantity() * getAllCartDetailsByIdUser.getIdProductDetails_CD().getProduct().getPrice()}</p>

                            <span><input id="getQuantity-${getAllCartDetailsByIdUser.getIdCartDetails()}" type="number"
                                         min="1"
                                         max="10"
                                         onclick="changeQuantity(${getAllCartDetailsByIdUser.getIdProductDetails_CD().getProduct().getPrice()},
                                             ${getAllCartDetailsByIdUser.getIdCartDetails()})"
                                         value="${getAllCartDetailsByIdUser.getQuantity()}"></span>
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