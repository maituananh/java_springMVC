<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MaiTuanAnhLapTop
  Date: 8/5/2019
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<c:forEach items="${listStudent}" var="listStudents">
		${listStudents.getIdStudent()}-
		${listStudents.getNameStudent()}-
		${listStudents.getAgeStudent()}-
		${listStudents.getAddressStudent()}-
		${listStudents.getPhoneStudent()}
	</c:forEach>
</body>
</html>
