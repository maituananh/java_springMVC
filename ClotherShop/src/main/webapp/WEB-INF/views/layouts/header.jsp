<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="top-left">
                <a href="#"> Help <i class="glyphicon glyphicon-phone" aria-hidden="true"></i> +077-434-9901</a>
            </div>
            <div class="top-right">
            <%--       top menu         --%>
                <jsp:include page="layoutsInclude/topMenu.jsp"/>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="heder-bottom">
        <div class="container">
            <div class="logo-nav">
                <div class="logo-nav-left">
                    <h1><a href="home">New Shop <span>Shop anywhere</span></a></h1>
                </div>
                <div class="logo-nav-left1">
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header nav_2">
                            <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse"
                                    data-target="#bs-megadropdown-tabs">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <%--         CONTENT MENU               --%>
                        <jsp:include page="layoutsInclude/contentMenu.jsp"/>
                    </nav>
                </div>
                <div class="logo-nav-right">
                    <ul class="cd-header-buttons">
                        <li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
                    </ul> <!-- cd-header-buttons -->
                    <div id="cd-search" class="cd-search">
                        <form id="searchHome" action="search-product" method="post" accept-charset="UTF-8">
                            <input id="search" name="search" type="search" placeholder="Search...">
                        </form>
                    </div>
                </div>
                <div class="header-right2">
                    <div class="cart box_1">
                        <a href="checkout.html">
                            <h3>
                                <img src="<c:url value="/resources/images/bag.png"/>" alt=""/>
                            </h3>
                        </a>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
