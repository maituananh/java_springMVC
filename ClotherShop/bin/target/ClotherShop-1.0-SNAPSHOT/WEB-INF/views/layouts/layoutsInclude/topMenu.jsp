<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:if test="${role == null}">
        <li><a href="login">Login</a></li>
        <li><a href="registered"> Create Account </a></li>
    </c:if>
    
    <c:if test="${role != null && role != 1}">
        <li><a href="checkOut">Checkout</a></li>
        <li><a href="#"> Logout </a></li>
    </c:if>
</ul>
