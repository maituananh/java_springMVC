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
                    classDanger();
                    $("#notify").text(value);
                } else {
                    classSuccess();
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
                    classDanger();
                    $("#notify").text(value);
                } else {
                    $(".product-details").show(2000);
                    disabledProductMain();
                    classSuccess();
                    emptyProductDetails();
                    $("#check-button").prop("disabled", true);
                    $("#EDIT").prop("disabled", false);
                }
            }
        })
    });

    $("#EDIT").click(function () {
        effectiveProductMain();
        $("#EDIT").prop("disabled", true);
        $("#check-button").prop("disabled", false);
    });

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

    $("#new-producer").click(function () {
        disabledProductMain();
        onAddNewProducer();
        $("#title-producer").text("ADD NEW PRODUCER");
    });

    $("#close-producer").click(function () {
        effectiveProductMain();
        offAddNewProducer();
        onButtonNewProducer();
    });

    $("#close").click(function () {
        turnOffAddNewItems();
        $('.product-details .disabled-ProductDetails').prop('disabled', false);
        turnOnBoxProductDetails();
        turnOnButtonNewItems();
    });

    // lưu item khi thêm mới KHÔNG CÓ NHÀ SẢN XUẤT
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
                var id = subIdOfItems(value);
                var items = subNameOfItems(value);
                var name = itemVal;
                if (items == "KIND" || items == "COLOR" || items == "SIZE") {
                    switch (items) {
                        case "KIND":
                            appendItems("kind", id, name);
                            break;
                        case "COLOR":
                            appendItems("color", id, name);
                            break;
                        case "SIZE":
                            appendItems("size", id, name);
                            break;
                    }
                    classSuccess();
                } else {
                    classDanger();
                    $("#notify").text(value);
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
                var id = subIdOfItems(value);
                var items = subNameOfItems(value);
                if (items == "PRODUCER") {
                    appendItems("Producer", id, nameProducer);
                    classSuccess();
                    $("#notify").text("add new producer success");
                } else {
                    classDanger();
                    $("#notify").text(value);
                }
            }
        });
    });

    function subIdOfItems(value) {
        var id = value.substr(0, value.indexOf("+") - 0);
        return id;
    }

    function subNameOfItems(value) {
        var nameItems = value.substr(value.indexOf("+") + 1);
        return nameItems;
    }

    function appendItems(nameItems, id, name) {
        $("#" + nameItems).append("<option value=" + id + ">" + name.toUpperCase() + "</option>");
    }

    // PHẦN TURN ON AND TURN OF

    // PHẦN TẮT ALL THÀNH PHẦN CỦA TRANG
    function hidden() {
        turnOffBoxProductDetails();
        $(".product-details .disabled-ProductDetails").prop('disabled', true);
        fadeInSaveAll();
        fadeToSaveProduct();
        turnOnAddNewItems();
        turnOffButtonNewItems();
    };
    // END ========================== PHẦN TẮT ALL THÀNH PHẦN CỦA TRANG

    // PHẦN BẬT TẮT CÁC BUTTUN TẠO MỚI CÁC ITEMS TRONG PRODUCT DETAILS
    function turnOnButtonNewItems() {
        $(".new").show();
    }

    function turnOffButtonNewItems() {
        $(".new").hide();
    }

    // END ======================= PHẦN BẬT TẮT CÁC BUTTUN TẠO MỚI CÁC ITEMS TRONG PRODUCT DETAILS

    // PHẦN BẬT VÀ TẮT BOX TẠO MỚI CÁC ITEMS
    function turnOnAddNewItems() {
        $(".addNewItems").fadeTo(2000, 1);
        $("#newItem").val("");
    }

    function turnOffAddNewItems() {
        $(".addNewItems").hide(2000);
    }

    // END ===================== PHẦN BẬT VÀ TẮT BOX TẠO MỚI CÁC ITEMS

    // PHẦN BẬT VÀ TẮT BOX CHI TIẾT SẢN PHẨM
    function turnOnBoxProductDetails() {
        $(".product-details").fadeTo(2000, 1, "linear");
    }

    function turnOffBoxProductDetails() {
        $(".product-details").fadeTo(2000, 0.3, "swing");
    }

    // END ===================== PHẦN BẬT VÀ TẮT BOX TẠO MỚI CÁC ITEMS

    // PHẦN BẬT VÀ TẮT NÚT TẠO MỚI NHÀ SẢN XUẤT
    function onButtonNewProducer() {
        $("#new-producer").show();
    }

    function offButtonNewProducer() {
        $("#new-producer").hide();
    }

    // END ==================== PHẦN BẬT VÀ TẮT NÚT TẠO MỚI NHÀ SẢN XUẤT

    // PHẦN BẬT VÀ TẮT KHUNG TẠO MỚI NHÀ SẢN XUẤT
    function onAddNewProducer() {
        $(".addNewProducer").show();
        $("#newItem").val("");
    }

    function offAddNewProducer() {
        $(".addNewProducer").hide();
    }

    // END ==================== PHẦN BẬT VÀ TẮT KHUNG TẠO MỚI NHÀ SẢN XUẤT

    // PHẦN BẬT VÀ TẮT DIV MAIN
    function disabledProductMain() {
        $(".disabled, .disabled >option").prop('disabled', true);
        $("#new-producer").hide();
    }

    function effectiveProductMain() {
        $(".disabled, .disabled >option").prop('disabled', false);
        $("#new-producer").show();
    }

    // PHẦN ====================================== BẬT VÀ TẮT DIV MAIN

    // PHẦN LÀM MỚI CÁC INPUT AND SELECT
    function emptyProductMain() {
        $("#product-main .disabled").val("");
    }

    function emptyProductDetails() {
        $(".product-details .disabled-ProductDetails, #save-product-data").val("");
        $(".avatar").attr("src", "resources/images/default_image.jpg");
    }

    // END ================================ PHẦN LÀM MỚI CÁC INPUT AND SELECT

    // PHẦN BẬT VÀ TẮT NÚT SAVE ALL
    function fadeInSaveAll() {
        $(".save-all").fadeTo(1000, 1);
    }

    function fadeOutSaveAll() {
        $(".save-all").hide();
    }

    // END ================ PHẦN BẬT VÀ TẮT NÚT SAVE ALL

    // PHẦN BẬT VÀ TẮT NÚT LƯU VÀO KHUNG CHƯA
    function fadeToSaveProduct() {
        $("#save-product").fadeTo(10, 0.3);
        $("#save-product").prop("disabled", true);
    }

    // END =============================== PHẦN BẬT VÀ TẮT NÚT LƯU VÀO KHUNG CHƯA

    // PHẦN BẬT TẮT THÔNG BÁO ĐÚNG SAI
    function classDanger() {
        $(".alert").removeClass("alert-success").addClass("alert-danger").css({"display": "block"});
        $("#notify").text("error");
    }

    function classSuccess() {
        $(".alert").removeClass("alert-danger").addClass("alert-success").css({"display": "block"});
        $("#notify").text("save success");
    }

    // END ====================== PHẦN BẬT TẮT THÔNG BÁO ĐÚNG SAI


    // END ======================= PHẦN TURN ON AND TURN OF

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
    // END ============= lưu file ngay sau khi chọn

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
                    classDanger();
                    $("#notify").text(value);
                } else {
                    // cho hiển thị nút lưu xuống data
                    classSuccess();
                    // nếu thông tin trong details không bị thay đổi thì nút sẽ bị mờ
                    fadeToSaveProduct();
                    fadeInSaveAll();
                    // gọi hàm truyền vào table
                    var id = $(".idTable").attr("id");
                    if (id == null) {
                        id = 0;
                        $(".showTable").fadeTo(1000, 1);
                    }
                    addTable(parseInt(id), colorVal, sizeVal, kindVal, qualityVal, fileVal);
                    // làm rỗng box product details
                    $("#color").val("");
                    $("#kind").val("");
                    $("#size").val("");
                    $("#quality").val("");
                    $("#file").val("");
                    $("#showImage").attr("src", "resources/images/default_image.jpg");
                }
            }
        });
    });

    function addTable(id, colorVal, sizeVal, kindVal, qualityVal, fileVal) {
        var subPathImage = fileVal.substr(fileVal.lastIndexOf("\\") + 1);
        var idNew = id + 1;
        $("#newProductDetails").append("<tr id=id" + idNew + ">" +
            "<td id=" + idNew + " class='idTable'>" + idNew + "</td>" +
            "<td id='colorTable" + idNew + "'>" + $("#color option:selected").html() + "</td>" +
            "<td id='sizeTable" + idNew + "'>" + $("#size option:selected").html() + "</td>" +
            "<td id='kindTable" + idNew + "'>" + $("#kind option:selected").html() + "</td>" +
            "<td id='qualityTable" + idNew + "'>" + qualityVal + "</td>" +
            "<td id='pathImage" + idNew + "' style='width: 150px; height: 100px'>" +
            "<img src=\"resources/images/" + subPathImage + "\"></td>" +
            "<td> <button type='button' " +
            "onclick='$(this).editTable(" + (id + 1) + "," + colorVal + "," + sizeVal + "," + kindVal + "," + qualityVal + ",\"" + subPathImage + "\")'>EDIT</button> </td>" +
            "</tr>");
    }

    $.fn.editTable = function (id, colorVal, sizeVal, kindVal, qualityVal, subPathImage) {
        $("#idOfDetails").val(id);
        $("#color").val("" + colorVal);
        $("#size").val("" + sizeVal);
        $("#kind").val("" + kindVal);
        $("#quality").val(qualityVal);
        $("#showImage").attr('src', 'resources/images/' + subPathImage);

        // chuyển nút save thành update.
        $(".product-details #box-button-save").css({"display": "none"});
        $(".product-details #box-button-update").css({"display": "block"});
    };

    // cập nhập lại trong khung chứa và sửa lại ở table
    $("#update-product").click(function () {
        var idVal = $("#idOfDetails").val();
        var colorVal = $("#color option:selected").html()
        var sizeVal = $("#size option:selected").html()
        var kindVal = $("#kind option:selected").html()
        var qualityVal = $("#quality").val();
        var fileVal = $("#file").val();
        if (fileVal == "") {
            fileVal = $("#showImage").attr('src');
        }
        $("#" + idVal).text("" + idVal);
        $("#colorTable" + idVal).text("" + colorVal);
        $("#sizeTable" + idVal).text("" + sizeVal);
        $("#kindTable" + idVal).text("" + kindVal);
        $("#qualityTable" + idVal).text("" + qualityVal);
        $("#pathImage" + idVal).prop("src", "" + fileVal);

        $(".product-details #box-button-save").css({"display": "block"});
        $(".product-details #box-button-update").css({"display": "none"});
        // $.ajax({
        //     url: "update",
        //     type: "POST",
        //     data: {
        //         id: idVal,
        //         color: colorVal,
        //         size: sizeVal,
        //         kind: kindVal,
        //         quality: qualityVal,
        //         srcImage: fileVal,
        //     },
        //     success: function (value) {
        //
        //     }
        // });
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
                    classDanger();
                } else {
                    classSuccess();
                    $(".product-details").hide(2000);
                    effectiveProductMain();
                    emptyProductMain();
                }
            }
        });
    });


    // trang editProductAdmin
    function cssEdit(value) {
        $(".edit-" + value).val("EDIT");
        $(".edit-" + value).css({"backgroundColor": "#5bc0de", "border-color": "#46b8da", "color": "#fff"});
        $(".delete-" + value).val("DELETE");
        $(".delete-" + value).css({"background-color": "#d9534f", "border-color": "#d43f3a", "color": "#fff"});
    }

    function cssUpdate(value) {
        $(".edit-" + value).val("UPDATE");
        $(".edit-" + value).css({"backgroundColor": "#449d44", "border-color": "#398439", "color": "#fff"});
        $(".delete-" + value).val("CANCEL");
        $(".delete-" + value).css({"background-color": "#ec971f", "border-color": "#d58512", "color": "#fff"});
    }

    function cssEditMain() {
        $(".main-form .disabled").prop("disabled", true);
        cssEdit("main");
    }

    function cssUpdateMain() {
        $(".main-form .disabled").prop("disabled", false);
        cssUpdate("main");
    }

    $(".row-product-details .disabled").prop("disabled", true);
    $(".edit-main").click(function () {
        if ($(".edit-main").val() == "EDIT") {
            cssUpdateMain();
        } else {
            cssEditMain();
        }
    });

    function cssEditDetails(id) {
        $("#formId" + id + " .disabled").prop("disabled", true);
        cssEdit("details");
    }

    function cssUpdateDetails(id) {
        $("#formId" + id + " .disabled").prop("disabled", false);
        cssUpdate("details");
    }

    // chờ nút button details click sẽ hoạt động
    $.fn.editDetails = function (id) {
        if ($("#" + id).val() == "EDIT") {
            cssUpdateDetails(id);
        } else {
            cssEditDetails(id);
        }
    };
})// end