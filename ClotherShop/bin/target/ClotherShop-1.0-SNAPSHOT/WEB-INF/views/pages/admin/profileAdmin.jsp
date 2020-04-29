<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    input {
        margin-bottom: 15px;
        text-transform: capitalize;
        width: 50%;
        color: black;
    }
    
    .switch {
        position: relative;
        display: inline-block;
        width: 60px;
        height: 34px;
    }
    
    /* Hide default HTML checkbox */
    .switch input {
        opacity: 0;
        width: 0;
        height: 0;
    }
    
    /* The slider */
    .slider {
        position: absolute;
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        -webkit-transition: .4s;
        transition: .4s;
    }
    
    .slider:before {
        position: absolute;
        content: "";
        height: 26px;
        width: 26px;
        left: 4px;
        bottom: 4px;
        background-color: white;
        -webkit-transition: .4s;
        transition: .4s;
    }
    
    input:checked + .slider {
        background-color: #2196F3;
    }
    
    input:focus + .slider {
        box-shadow: 0 0 1px #2196F3;
    }
    
    input:checked + .slider:before {
        -webkit-transform: translateX(26px);
        -ms-transform: translateX(26px);
        transform: translateX(26px);
    }
    
    /* Rounded sliders */
    .slider.round {
        border-radius: 34px;
    }
    
    .slider.round:before {
        border-radius: 50%;
    }
</style>
<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-3">
            <!--left col-->
            <div class="text-center">
                <c:if test="${profileUser.getAvatar() != null}">
                    <img src="<c:url value="/resources/avatar/${profileUser.getAvatar()}"/>"
                         class="avatar img-circle img-thumbnail" alt="avatar">
                </c:if>
                <c:if test="${profileUser.getAvatar() == null}">
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                         class="avatar img-circle img-thumbnail" alt="avatar">
                </c:if>
            </div>
            </hr><br>
            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span>
                    125
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span>
                    78
                </li>
            </ul>
        </div>
        <!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab">Information</a></li>
            </ul>
            
            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <form class="form" action="admin-editRole" method="post" id="registrationForm">
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="first_name">
                                    <h4>Name</h4>
                                </label>
                                <input type="text" class="form-control" name="first_name" id="first_name"
                                       value="${profileUser.getName()}" title="enter your first name if any." readonly
                                       style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="last_name">
                                    <h4>UserName</h4>
                                </label>
                                <input type="text" class="form-control" name="last_name" id="last_name"
                                       placeholder="${profileUser.getUserName()}" title="enter your last name if any."
                                       readonly style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="phone">
                                    <h4>Phone</h4>
                                </label>
                                <input type="text" class="form-control" name="phone" id="phone"
                                       value="${profileUser.getPhone()}" title="enter your phone number if any."
                                       readonly style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile">
                                    <h4>Address</h4>
                                </label>
                                <input type="text" class="form-control" name="mobile" id="mobile"
                                       value="${profileUser.getAddress()}" title="enter your mobile number if any."
                                       readonly style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="email">
                                    <h4>Email</h4>
                                </label>
                                <input type="email" class="form-control" name="email" id="email"
                                       value="${profileUser.getEmail()}" title="enter your email." readonly
                                       style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="email">
                                    <h4>Birthday</h4>
                                </label>
                                <input type="text" class="form-control" id="location"
                                       value="${profileUser.getBirthday()}" title="enter a location" readonly
                                       style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="password">
                                    <h4>Hometown</h4>
                                </label>
                                <input type="text" class="form-control" name="password" id="password"
                                       value="${profileUser.getHometown()}" title="enter your password." readonly
                                       style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="password2">
                                    <h4>Age</h4>
                                </label>
                                <input type="text" class="form-control" name="password2" id="password2"
                                       value="${profileUser.getAge()}" title="enter your password2." readonly
                                       style="height: 30px; font-size: 17px;">
                            </div>
                        </div>
                        <input name="id" value="${profileUser.getIdUser()}" hidden>
                        <c:if test="${profileUser.getUserName() != 'admin'}">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <br>
                                    <c:if test="${profileUser.getRole().getIdRole() == 1}">
                                        <label class="switch">
                                            <input type="checkbox" name="role" checked>
                                            <span class="slider round"></span>
                                            <input name="role" value="false" hidden>
                                            <input name="oldRole" value="true" hidden>
                                        </label>
                                    </c:if>
                                    <c:if test="${profileUser.getRole().getIdRole() == 2}">
                                        <label class="switch">
                                            <input type="checkbox" name="role">
                                            <span class="slider round"></span>
                                            <input name="role" value="false" hidden>
                                            <input name="oldRole" value="false" hidden>
                                        </label>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                    </button>
                                </div>
                            </div>
                        </c:if>
                        
                        <c:if test="${profileUser.getUserName() == 'admin'}">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <br>
                                    <a class="btn btn-lg btn-success"
                                       href="admin-editProfile?id=${profileUser.getIdUser()}"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Edit
                                    </a>
                                </div>
                            </div>
                        </c:if>
                    </form>
                    <hr>
                </div>
            </div>
            <!--/tab-pane-->
        </div>
        <!--/tab-content-->
    
    </div>
    <!--/col-9-->
</div>
<!--/row-->
<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        var readURL = function (input) {--%>
<%--            if (input.files && input.files[0]) {--%>
<%--                var reader = new FileReader();--%>

<%--                reader.onload = function (e) {--%>
<%--                    $('.avatar').attr('src', e.target.result);--%>
<%--                }--%>

<%--                reader.readAsDataURL(input.files[0]);--%>
<%--            }--%>
<%--        }--%>

<%--        $(".file-upload").on('change', function () {--%>
<%--            readURL(this);--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
