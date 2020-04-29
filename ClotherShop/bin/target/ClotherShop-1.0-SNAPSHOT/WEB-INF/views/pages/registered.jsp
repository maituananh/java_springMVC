<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
<%--    đăng kí--%>
        <div class="login" id="registered" style="display: none">
            <div class="main-agileits">
                <div class="form-w3agile form1">
                    <h3>Register</h3>
                    <%--@elvariable id="user" type="com.teambuild.clothershop.model.User"--%>
                    <form:form action="addUser" method="post" modelAttribute="user">
                        <div class="key">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <form:input type="text" value="Name" name="name" required="" path="name"/>
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <form:input type="text" value="Username" name="username" required=""
                                        path="userName"/>
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <form:input type="text" value="Birthday" name="birthday" required=""
                                        path="birthday"/>
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-envelope" aria-hidden="true"></i>
                            <form:input type="text" value="Email" name="email" required="" path="email"/>
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-lock" aria-hidden="true"></i>
                            <form:password value="Password" name="password" required=""
                                           path="password"/>
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-genderless" aria-hidden="true"></i>
                            <form:select value="Gender" name="gender" required=""
                                         path="gender.idGender">
                                <form:option value="2">Female</form:option>
                                <form:option value="1">Male</form:option>
                            </form:select>
                            <div class="clearfix"></div>
                        </div>
                        <%--                <div class="key">--%>
                        <%--                    <i class="fa fa-lock" aria-hidden="true"></i>--%>
                        <%--                    <input type="password" value="Confirm Password" name="confirmPassword" onfocus="this.value = '';"--%>
                        <%--                           onblur="if (this.value == '') {this.value = 'Confirm Password';}" required="">--%>
                        <%--                    <div class="clearfix"></div>--%>
                        <%--                </div>--%>
                        <input type="submit" value="Submit">
                    </form:form>
                </div>
                <div class="forg">
                    <a href="#" class="forg-left">Forgot Password</a>
                    <a id="login-registered" class="forg-right">Register</a>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
</div>
