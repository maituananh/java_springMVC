<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><tiles:getAsString name="title"/></title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="apple-touch-icon" href="<c:url value="/resources/images/LOGO.png" />">
    <link rel="shortcut icon" href="<c:url value="/resources/images/LOGO.png" />">
    <tiles:insertAttribute name="link"/>
    
</head>

<body>
<!-- Left Panel -->
<tiles:insertAttribute name="leftPanel"/>
<!-- /#left-panel -->
<!-- Right Panel -->
<div id="right-panel" class="right-panel">
    <!-- Header-->
    <tiles:insertAttribute name="header"/>
    <!-- /#header -->
    <!-- Content -->
    <tiles:insertAttribute name="body"/>
    <!-- /.content -->
    <div class="clearfix"></div>
    <!-- Footer -->
    <tiles:insertAttribute name="footer"/>
    <!-- /.site-footer -->
</div>
<!-- /#right-panel -->

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="<c:url value="/resources/admin/assets/js/main.js"/>"></script>

<tiles:insertAttribute name="script"/>
</body>
</html>
