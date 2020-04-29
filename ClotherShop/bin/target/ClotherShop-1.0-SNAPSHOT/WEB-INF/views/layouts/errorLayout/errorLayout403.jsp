<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="apple-touch-icon" href="<c:url value="/resources/images/LOGO.png" />">
    <link rel="shortcut icon" href="<c:url value="/resources/images/LOGO.png" />">
    <link rel="stylesheet" href="<c:url value="/resources/error/error403/css/style.css"/>" type="text/css">
</head>
<body>
<tiles:insertAttribute name="body"/>
</body>
</html>
