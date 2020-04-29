<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="core-slider_list">
    <c:forEach items="${slideList}" var="slideLists">
        <div class="core-slider_item">
            <img src="<c:url value="/resources/images/${slideLists.getUrl()}"/>" class="img-responsive"
                 alt="${slideLists.getIdSlide()}">
        </div>
    </c:forEach>
</div>