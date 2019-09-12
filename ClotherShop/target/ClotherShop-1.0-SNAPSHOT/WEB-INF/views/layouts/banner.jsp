<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="banner-w3">
    <div class="demo-1">
        <div id="example1" class="core-slider core-slider__carousel example_1">
            <div class="core-slider_viewport">
            <div class="core-slider_viewport">
                <jsp:include page="layoutsInclude/slide.jsp"/>
            </div>
            <div class="core-slider_nav">
                <div class="core-slider_arrow core-slider_arrow__right"></div>
                <div class="core-slider_arrow core-slider_arrow__left"></div>
            </div>
            <div class="core-slider_control-nav"></div>
        </div>
    </div>
    <link href="<c:url value="/resources/css/coreSlider.css"></c:url>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/js/coreSlider.js"></c:url>"></script>
    <script>
        $('#example1').coreSlider({
            pauseOnHover: false,
            interval: 3000,
            controlNavEnabled: true
        });
    
    </script>
</div>
