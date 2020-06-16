<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:if test="${role == null}">
        <li><a href="login">Login</a></li>
        <li><a href="registered"> Create Account </a></li>
    </c:if>
    
    <c:if test="${role != null}">
        <li><a href="getAllCartDetailsByIdUser" id="checkOut">Checkout</a></li>
        <li><a href="" id="logout"> Logout </a></li>
    </c:if>
</ul>
