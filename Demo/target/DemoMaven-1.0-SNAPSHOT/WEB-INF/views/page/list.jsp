<%--
  Created by IntelliJ IDEA.
  User: MaiTuanAnhLapTop
  Date: 7/29/2019
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Shoe</title>
</head>
<body>
    <h1 class="title"> DEMO SPRING MVC </h1>

    <nav class="nav">
        <a class="nav-link active" href="home">Home</a>
        <a class="nav-link" href="list">List Shoe</a>
    </nav>

    list shoes
    ${listShoe.getId()} -
    ${listShoe.getName()} -
    ${listShoe.getImage()} -
    ${listShoe.getPrice()}

    <br>
    tên của bạn là : ${requestScope.name}
    <br>
    tuổi của bạn là : ${requestScope.age}
    <footer class="footer">
        phần footer
    </footer>
</body>
</html>
