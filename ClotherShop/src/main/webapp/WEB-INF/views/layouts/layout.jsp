<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <link rel="apple-touch-icon" href="<c:url value="/resources/images/LOGO.png" />">
    <link rel="shortcut icon" href="<c:url value="/resources/images/LOGO.png" />">
    <title><tiles:getAsString name="title"/></title>
    <!--css-->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet">
    <!--css-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="New Shop Responsive web template, Bootstrap Web Templates, Flat Web Templates,
        Android Compatible web template,
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
    />
    <script type="application/x-javascript"> addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        },
        false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <link href='//fonts.googleapis.com/css?family=Cagliostro' rel='stylesheet' type='text/css'>
    <link
            href='//fonts.googleapis.com/css?family=Open+Sans:400,800italic,800,700italic,700,600italic,600,400italic,300italic,300'
            rel='stylesheet' type='text/css'>
    <!--search jQuery-->
    <script src="<c:url value="/resources/js/main.js"/>"></script>
    <!--search jQuery-->
    <script src="<c:url value="/resources/js/responsiveslides.min.js"/>"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                nav: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
    <!--mycart-->
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-3.1.1.min.js"/>"></script>
    <!-- cart -->
    <script src="<c:url value="/resources/js/simpleCart.min.js"/>"></script>
    <!-- cart -->
    <!--start-rate-->
    <script src="<c:url value="/resources/js/jstarbox.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/jstarbox.css"/>" type="text/css" media="screen"
          charset="utf-8"/>
    <script type="text/javascript">
        jQuery(function () {
            jQuery('.starbox').each(function () {
                var starbox = jQuery(this);
                starbox.starbox({
                    average: starbox.attr('data-start-value'),
                    changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                    ghosting: starbox.hasClass('ghosting'),
                    autoUpdateAverage: starbox.hasClass('autoupdate'),
                    buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                    stars: starbox.attr('data-star-count') || 5
                }).bind('starbox-value-changed', function (event, value) {
                    if (starbox.hasClass('random')) {
                        var val = Math.random();
                        starbox.next().text(' ' + val);
                        return val;
                    }
                })
            });
        });
    </script>
    <!--//End-rate-->
    <link href="<c:url value="/resources/datapicker/air-datepicker/dist/css/datepicker.min.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/datapicker/air-datepicker/dist/js/datepicker.min.js"/>"></script>
    <!-- Include English language -->
    <script src="<c:url value="/resources/datapicker/air-datepicker/dist/js/i18n/datepicker.en.js"/>"></script>
</head>
<body>
<!--header-->
<tiles:insertAttribute name="header"/>
<!--header-->
<!--banner-->
<tiles:insertAttribute name="banner"/>
<!--banner-->
<!--content-->
<tiles:insertAttribute name="body"/>
<!--content-->
<!---footer--->
<tiles:insertAttribute name="footer"/>
<!---footer--->
<!--copy-->
<div class="copy-section">
    <div class="container">
        <div class="copy-left">
            <p>&copy; 2019 New Shop . All rights reserved | Design by</p>
        </div>
        <div class="copy-right">
            <img src="<c:url value="/resources/images/card.png"/>" alt=""/>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--copy-->
<%--    js tự viết--%>
<script src="<c:url value="/resources/js/custom.js"/>"></script>
</body>
</html>

