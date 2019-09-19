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
        var producerVal = $("#Producer").val();
        $.ajax({
            url: "checkInfoProduct",
            type: "POST",
            data: {
                code: codeVal,
                name: nameVal,
                price: priceVal,
                describe: describeVal,
                producer: producerVal
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
                        $("#Producer").prop('disabled', true);
                        $("select, #quality").val("");
                        $("#save-product-data").hide();
                        $("#new-producer").hide()
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

    // phần show tạo nhà sản xuất mới
    $("#new-producer").click(function () {
        $("#product-main").fadeTo(2000, 0.3, "swing");
        $(".addNewProducer").show(2000);
        $("#newItem").val("");
        $('.displayed, select, #creat-new-product, .describe, #check-button').prop('disabled', true);
        $("#title-producer").text("ADD NEW PRODUCER");
    });

    $("#close-producer").click(function () {
        $(".addNewProducer").hide(2000);
        $('.displayed, select, #creat-new-product, .describe, #check-button').prop('disabled', false);
        $("#product-main").fadeTo(2000, 1, "linear");
    });
    // end tạo mới nhà sản xuất

    // lưu file ngay sau khi chọn
    var files = [];
    $("#file").change(function (event) {
        files = event.target.files;
        var forms = new FormData();
        // đặt tên key là file và có value là files ở vị trí thứ ko.
        forms.append("file", files[0]);
        $.ajax({
            url: "saveAndMoveFile",
            type: "POST",
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            data: forms,
            success: function (value) {
                if (value != "true") {
                    console.log("handle file fail")
                } else {
                    console.log("save file success");
                }
            }
        })
    });

    $("#close").click(function () {
        $(".addnewproduct").hide(2000);
        $('.displayed, select, #creat-new-product').prop('disabled', false);
        $(".container, #creat-new-product").fadeTo(2000, 1, "linear");
        $(".new").show();
    });

    // lưu vào khung chứa
    $("#save-product").click(function () {
        var colorVal = $("#color").val();
        var kindVal = $("#kind").val();
        var sizeVal = $("#size").val();
        var qualityVal = $("#quality").val();
        var fileVal = $("#file").val();
        $.ajax({
            url: "save-product",
            type: "POST",
            data: {
                color: colorVal,
                kind: kindVal,
                size: sizeVal,
                quality: qualityVal,
                file: fileVal
            },
            success: function (value) {
                if (value != "true") {
                    // xuất thông báo lỗi
                } else {
                    // cho hiển thị nút lưu xuống data
                    $(".alert").css({
                        "display": "block",
                        "color": "#3c763d",
                        "background-color": "#dff0d8",
                        "border-color": "#d6e9c6"
                    });
                    $("#notify").text("save product success");
                    $("#save-product-data").show();
                    // nếu thông tin trong details không bị thay đổi thì nút sẽ bị mờ
                    $("#save-product").fadeTo(1000, 0.3);
                    $("#save-product").prop("disabled", true);
                }
            }
        });
    });

    // khi các select trong details bị thay đổi thì nút lưu vào khung chứa hiển thị lên.
    $('select, #quality').change(function () {
        $("#save-product").fadeTo(1000, 1);
        $("#save-product").prop("disabled", false);
    });

    // thực hiện lưu vào data
    $("#save-product-data").click(function () {
        $.ajax({
            url: "insertProduct",
            type: "POST",
            success: function (value) {
                if (value != "true") {
                    console.log(value);
                    $(".alert").css({
                        "display": "block",
                        "color": "#a94442",
                        "background-color": "#f2dede",
                        "border-color": "#ebccd1"
                    });
                    $("#notify").text("error");
                } else {
                    // xuất thông báo đúng
                    // set lại khung chứa rỗng
                    // xuất giao diện lại từ đầu
                    $(".alert").css({
                        "display": "block",
                        "color": "#3c763d",
                        "background-color": "#dff0d8",
                        "border-color": "#d6e9c6"
                    });
                    $("#notify").text("save all product details success");
                    $(".product-detail-form").hide(2000);
                    $("#product-main, #check-button").fadeTo(2000, 1);
                    $("#product-main input, textarea").prop("readOnly", false);
                    $("#product-main textarea").css("height", "60px");
                    $("#Producer").prop('disabled', false);
                    $("#describe, #Producer, #code, #name, #price").val("");
                    $("#new-producer").show();
                }
            }
        });
    });

    // lưu item khi thêm mới
    $("#save").click(function () {
        var headerVal = $("#title").text();
        var itemVal = $("#newItem").val();
        $.ajax({
            url: "saveItem",
            type: "POST",
            data: {
                header: headerVal,
                item: itemVal
            },
            success: function (value) {
                if (value != "true") {
                  // thông báo lỗi
                } else {
                    // đúng
                }
            }
        });
    });

    // lưu nhà sản xuất mới
    $("#save-producer").click(function () {
        var headerVal = $("#title-producer").text();
        var nameProducer = $("#newItem-producer").val();
        var addressProducer = $("#newItem-producer-address").val();
        $.ajax({
            url: "saveItem",
            type: "POST",
            data: {
                header: headerVal,
                item: nameProducer + "/" + addressProducer
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
                    // đúng
                    $(".alert").css({
                        "display": "block",
                        "color": "#3c763d",
                        "background-color": "#dff0d8",
                        "border-color": "#d6e9c6"
                    });
                    $("#notify").text("add new producer success");
                }
            }
        });
    });

})// end