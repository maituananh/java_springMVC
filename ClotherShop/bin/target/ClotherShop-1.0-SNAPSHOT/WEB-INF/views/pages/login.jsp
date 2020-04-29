<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .alert{
        display: none;
        position: fixed;
        text-align: center;
        top: 0px;
        font-weight:bold;
        font-size: larger;
        font-variant: small-caps;
    }
    
</style>
<div class="content">
    <div class="alert col-lg-12">
        <strong id="notify"></strong>
    </div>
    <%--  đăng nhập  --%>
    <div class="login" id="login">
        <div class="main-agileits">
            <div class="form-w3agile">
                <h3>Login To New Shop</h3>
                <h4 style="color: red; text-align: center; margin-top: -30px; margin-bottom: 20px" id="mess"></h4>
                <form action="" method="post">
                    <div class="key">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        <input type="text" name="userName" id="userName" placeholder="UserName" required>
                        <div class="clearfix"></div>
                    </div>
                    <div class="key">
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        <input type="password" name="password" id="password" PLACEHOLDER="Password" required="">
                        <div class="clearfix"></div>
                    </div>
                    <input type="button" value="Login" id="login-Submit">
                </form>
            </div>
            <div class="forg">
                <a href="#" class="forg-left">Forgot Password</a>
                <a id="registered-login" class="forg-right">Register</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <%--    đăng kí--%>
    <div class="login" id="registered" style="display: none">
        <div class="main-agileits">
            <div class="form-w3agile form1">
                <h3>Register</h3>
                <form action="" method="post">
                    <div class="key">
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <input type="text" placeholder="Name" id="nameRegistered" required=""/>
                        <div class="clearfix"></div>
                    </div>
                    <div class="key">
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <input type="text" placeholder="UserName" id="userNameRegistered" required=""/>
                        <div class="clearfix"></div>
                    </div>
                    <div class="key">
                        <i class="fa fa-calendar" aria-hidden="true"></i>
                        <input type='text' class='datepicker-here' placeholder="Birthday" id="birthdayRegistered"
                               data-language='en'/>
                        <%--                        <input type="text" placeholder="Birthday" id="birthdayRegistered" required=""/>--%>
                        <div class="clearfix"></div>
                    </div>
                    <div class="key">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        <input type="text" placeholder="Email" id="emailRegistered" required=""/>
                        <div class="clearfix"></div>
                    </div>
                    <div class="key">
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        <input type="password" placeholder="Password" id="passwordRegistered" required=""/>
                        <div class="clearfix"></div>
                    </div>
                    <div class="key">
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        <input type="password" placeholder="Confirm Password" id="confirmPasswordRegistered"
                               required="">
                        <div class="clearfix"></div>
                    </div>
                    <div>
                        <input type="radio" name="gender" checked value="2" style="margin-left: 80px"> Female
                        <input type="radio" name="gender" value="1" style="margin-left: 40px"> Male
                        <div class="clearfix"></div>
                    </div>
                    <input type="button" value="Submit" id="registeredSubmit" style="margin-top: 30px">
                </form>
            </div>
            <div class="forg">
                <a id="login-registered" class="forg-right">Login</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("#registered-login").click(function () {
            $("#login").hide();
            $("#registered").show();
        })
    });

    $(function () {
        $("#login-registered").click(function () {
            $("#registered").hide();
            $("#login").show();
        })
    })
</script>