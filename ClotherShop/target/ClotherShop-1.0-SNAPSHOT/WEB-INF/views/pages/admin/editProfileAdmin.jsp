<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <%--@elvariable id="user" type="com.teambuild.clothershop.model.User"--%>
                    <form:form class="form" action="admin-updateProfile" modelAttribute="user" method="post"
                               id="registrationForm">
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="first_name">
                                    <h4>Name</h4>
                                </label>
                                <form:input type="text" class="form-control" id="first_name"
                                            value="${profileUser.getName()}" title="enter your first name if any."
                                            style="height: 30px; font-size: 17px;" path="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <form:hidden class="form-control" name="last_name" id="last_name"
                                             value="${profileUser.getUserName()}"
                                            title="enter your last name if any."
                                            style="height: 30px; font-size: 17px;" path="userName"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="phone">
                                    <h4>Phone</h4>
                                </label>
                                <form:input type="number" class="form-control" name="phone" id="phone"
                                            value="${profileUser.getPhone()}" title="enter your phone number if any."
                                            style="height: 30px; font-size: 17px;" path="phone"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile">
                                    <h4>Address</h4>
                                </label>
                                <form:input type="text" class="form-control" name="mobile" id="mobile"
                                            value="${profileUser.getAddress()}" title="enter your mobile number if any."
                                            style="height: 30px; font-size: 17px;" path="address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="email">
                                    <h4>Email</h4>
                                </label>
                                <form:input type="email" class="form-control" name="email" id="email"
                                            value="${profileUser.getEmail()}" title="enter your email."
                                            style="height: 30px; font-size: 17px;" path="email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="email">
                                    <h4>Birthday</h4>
                                </label>
                                <form:input type="text" class="form-control" id="location"
                                            value="${profileUser.getBirthday()}" title="enter a location"
                                            style="height: 30px; font-size: 17px;" path="birthday"/>
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <div class="col-xs-6">
                                <label for="password">
                                    <h4>Hometown</h4>
                                </label>
                                <form:input type="text" class="form-control" name="password" id="password"
                                            value="${profileUser.getHometown()}" title="enter your password."
                                            style="height: 30px; font-size: 17px;" path="hometown"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="password2">
                                    <h4>Age</h4>
                                </label>
                                <form:input type="text" class="form-control" name="password2" id="password2"
                                            value="${profileUser.getAge()}" title="enter your password2."
                                            style="height: 30px; font-size: 17px;" path="age"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="password2">
                                    <h4>Password</h4>
                                </label>
                                <form:password class="form-control" name="password2" id="password2"
                                            value="${profileUser.getPassword()}" title="enter your password2."
                                            style="height: 30px; font-size: 17px;" path="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i> Update
                                </button>
                            </div>
                        </div>
                    </form:form>
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
<script>
    $(document).ready(function () {
        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('.avatar').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $(".file-upload").on('change', function () {
            readURL(this);
        });
    });
</script>
