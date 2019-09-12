	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
		<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<html>
		<head>
		
		<title><tiles:getAsString name="title" /></title>
		<tiles:insertAttribute name="header"/>
		</head>
		<body id="page-top">
		
		<!-- Page Wrapper -->
		<div id="wrapper">
		
		<!-- Sidebar -->
		<tiles:insertAttribute name="sidebar"/>
		<!-- End of Sidebar -->
		
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
		
		<!-- Main Content -->
		<div id="content">
		
		<!-- Topbar -->
		<tiles:insertAttribute name="topbar"/>
		<!-- End of Topbar -->
		
		<!-- Begin Page Content -->
		<div class="container-fluid">
		
		<%--		phần body               --%>
		<tiles:insertAttribute name="body"/>
		
		</div>
		<!-- /.container-fluid -->
		
		</div>
		<!-- End of Main Content -->
		
		<!-- Footer -->
		<tiles:insertAttribute name="footer"/>
		<!-- End of Footer -->
		
		</div>
		<!-- End of Content Wrapper -->
		
		</div>
		<!-- End of Page Wrapper -->
		
		<!-- Scroll to Top Button-->
		<tiles:insertAttribute name="footerbutton"/>
		
		</body>
		</html>
