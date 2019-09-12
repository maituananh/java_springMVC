<%--
  Created by IntelliJ IDEA.
  User: MaiTuanAnhLapTop
  Date: 7/22/2019
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Page Home</title>
    <%-- bootstrap --%>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/MasterPage.css"/>" type="text/css">
</head>
<body>
    <h1 class="title"> DEMO SPRING MVC </h1>

    <nav class="nav">
        <a class="nav-link active" href="home">Home</a>
        <a class="nav-link" href="list">List Shoe</a>
    </nav>

    <footer class="footer">
        phần footer
    </footer>
</body>
</html>
