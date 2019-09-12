<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/admin/cssVerification.css"/>" type="text/css">
</head>
<body>

<div class="titles">
    <p class="titles-banner">Clothes Shop</p>
</div>


<div class="box">
    <h2 class="titles-box">Please enter code</h2>
    <p style="color: red">${requestScope.notification}</p>
    <form action="admin-findCode" method="post">
        <input class="input" name="codes" type="password">
        <br>
        <button type="submit" class="btn btn-primary">OPEN</button>
    </form>
</div>

</body>
</html>
