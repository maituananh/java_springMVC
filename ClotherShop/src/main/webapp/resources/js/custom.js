$(document).ready(function () {
    // sử lý sau khi login
    $("#login-Submit").click(function () {
        var user = $("#userName").val();
        var pass = $("#password").val();
        $.ajax({
            url: "findByUsernameAndPassword",
            type: "POST",
            data: {
                userName: user,
                password: pass
            },
            success: function (value) {
                var url = window.location.href;
                if (value == "admin") {
                    var changeUrlAdmin = url.replace("login", "admin-verification");
                    window.location = changeUrlAdmin;
                } else if (value == "user") {
                    var changeUrlUser = url.replace("login", "home");
                    window.location = changeUrlUser;
                } else if (value == "false") {
                    $("#mess").text("User account or password incorrect");
                } else if (value == "null") {
                    $("#mess").text("Please enter your account and password");
                }
            }
        })
    })
// Lấy tất cả dữ liệu trong form login
//     var data = $('form#form-login').serialize();
    // sử lý đăng ký
    $("#registeredSubmit").click(function () {
        var nameVal = $("#nameRegistered").val();
        var usernameVal = $("#userNameRegistered").val();
        var birthdayVal = $("#birthdayRegistered").val();
        var emailVal = $("#emailRegistered").val();
        var passVal = $("#passwordRegistered").val();
        var confirmPasswordVal = $("#confirmPasswordRegistered").val();
        var genderVal = $("input[name=gender]:checked").val();
        $.ajax({
            url: "registered",
            type: "POST",
            data: {
                nameUser: nameVal,
                userName: usernameVal,
                birthday: birthdayVal,
                email: emailVal,
                password: passVal,
                confirmPassword: confirmPasswordVal,
                gender: genderVal
            },
            success: function (value) {
                if (value != "true") {
                    $(".alert").css({
                        "display": "block",
                        "color": "#a94442",
                        "background-color": "#f2dede",
                        "border-color": "#ebccd1"
                    });
                    $("#notify").text(value);
                } else {
                    $(".alert").css({
                        "display": "block",
                        "color": "#3c763d",
                        "background-color": "#dff0d8",
                        "border-color": "#d6e9c6"
                    });
                    $("#notify").text("registration success you need login");
                    $("#login").show();
                    $("#registered").hide();
                }
            }
        })
    })
    $(".alert").hover(function () {
        $(".alert").css({"display": "none"})
    })


})// end