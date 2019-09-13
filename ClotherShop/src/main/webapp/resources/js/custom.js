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
    // var data = $('form#form-login').serialize();
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
    });
    $(".alert").hover(function () {
        $(".alert").css({"display": "none"})
    });

    // sử lý trang thêm sản phẩm. KIỂM TRA THÔNG TIN CHÍNH CỦA SẢN PHẨM HỢP LỆ KHÔNG
    $("#check-button").click(function () {
        var codeVal = $("#code").val();
        var nameVal = $("#name").val();
        var priceVal = $("#price").val();
        var describeVal = $("#describe").val();
        $.ajax({
            url: "checkInfoProduct",
            type: "POST",
            data: {
                code: codeVal,
                name: nameVal,
                price: priceVal,
                describe: describeVal
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
                    $(".product-detail-form").show(2000);
                    $("#product-main button").hide(function () {
                        $("#product-main input, textarea").prop("readOnly", true);
                        $("#product-main").fadeTo(2000, 0.3, "swing");
                        $("#product-main textarea").css("height", "30px");
                    });
                }
            }
        })
    });

    function hidden() {
        $(".container, #creat-new-product").fadeTo(2000, 0.3, "swing");
        $('.displayed, select, #creat-new-product').prop('disabled', true);
        $(".addnewproduct").show(2000);
        $("#newItem").val("");
        $(".new").hide();
    };

    $("#new-color").click(function () {
        hidden();
        $("#title").text("ADD NEW COLOR");
        $("#newItem").prop("placeholder", "New Color");
    });

    $("#new-size").click(function () {
        hidden();
        $("#title").text("ADD NEW SIZE");
        $("#newItem").prop("placeholder", "New Size");
    });

    $("#new-kind").click(function () {
        hidden();
        $("#title").text("ADD NEW KIND");
        $("#newItem").prop("placeholder", "New Kind");
    });

    $("#close").click(function () {
        $(".addnewproduct").hide(2000);
        $('.displayed, select, #creat-new-product').prop('disabled', false);
        $(".container, #creat-new-product").fadeTo(2000, 1, "linear");
        $(".new").show();
    });

    // thực hiện Lưu sản phẩm
    $("#save-product").click(function () {
        var codeVal = $("#code").val();
        var nameVal = $("#name").val();
        var priceVal = $("#price").val();
        var describeVal = $("#describe").val();

        var colorVal = $("#color").val();
        var kindVal = $("#kind").val();
        var sizeVal = $("#size").val();
        var qualityVal = $("#quality").val();
        var fileVal = $("#file").val();
        alert(fileVal);
        $.ajax({
            url: "",
            type: "POST",
            data: {
                code: codeVal,
                name: nameVal,
                price: priceVal,
                describe: describeVal,
                color: colorVal,
                kind: kindVal,
                size: sizeVal,
                quality: qualityVal,

            },
            success: function (value) {

            }
        })
    });

})// end