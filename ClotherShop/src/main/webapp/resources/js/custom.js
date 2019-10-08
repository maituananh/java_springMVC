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
        $(".addNewItems").hide(500);
    }

    // END ===================== PHẦN BẬT VÀ TẮT BOX TẠO MỚI CÁC ITEMS

    // PHẦN BẬT VÀ TẮT BOX CHI TIẾT SẢN PHẨM
    function turnOnBoxProductDetails() {
        $(".product-details").fadeTo(500, 1, "linear");
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
                var substringValue = value.substr(0, 4);
                if (substringValue != "true") {
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
                    var id = value.substr(5);
                    $(".showTable").fadeTo(1000, 1);
                    addTable(parseInt(id), colorVal, sizeVal, kindVal, qualityVal, fileVal);
                    // làm rỗng box product details
                    emptyBoxProductDetails();
                }
            }
        });
    });

    // làm rỗng box
    function emptyBoxProductDetails() {
        $("#color").val("");
        $("#kind").val("");
        $("#size").val("");
        $("#quality").val("");
        $("#file").val("");
        $("#showImage").attr("src", "resources/images/default_image.jpg");
    }

    // kiểm tra các input đáp ứng đủ điều kiện thì lưu vào table
    function addTable(id, colorVal, sizeVal, kindVal, qualityVal, fileVal) {
        var nameFile = fileVal.substr(fileVal.lastIndexOf("\\") + 1);
        $("#newProductDetails").append("<tr id=id" + id + ">" +
            "<td id=" + id + " class='idTable" + id + "'>" + id + "</td>" +
            "<td id='colorTable" + id + "' class='" + colorVal + "'>" + $("#color option:selected").html() + "</td>" +
            "<td id='sizeTable" + id + "' class='" + sizeVal + "'>" + $("#size option:selected").html() + "</td>" +
            "<td id='kindTable" + id + "' class='" + kindVal + "'>" + $("#kind option:selected").html() + "</td>" +
            "<td id='qualityTable" + id + "'>" + qualityVal + "</td>" +
            "<td style='width: 150px; height: 100px'>" +
            "<img style='width: 150px; height: 100px' id='pathImage" + id + "' src=\"resources/images/" + nameFile + "\"></td>" +
            "<td id='button-edit" + id + "'> <button type='button' id='button-edit-" + id + "' " +
            "onclick='$(this).editTable(" + id + "," + colorVal + "," + sizeVal + "," + kindVal + "," + qualityVal + ",\"" + nameFile + "\")'>EDIT</button> " +
            "<button type='button' id='button-delete-" + id + "' " + "onclick='$(this).deleteTable(" + id + ")'>DELETE</button></td>" +
            "</tr>");
    }

    // khi nhấn nút edit ở table
    $.fn.editTable = function (id, colorVal, sizeVal, kindVal, qualityVal, namFile) {
        $("#idOfDetails").val(id);
        $("#color").val("" + colorVal);
        $("#size").val("" + sizeVal);
        $("#kind").val("" + kindVal);
        $("#quality").val(qualityVal);

        $("#showImage").attr('src', 'resources/images/' + namFile);
        // turn off button save and turn on button update.
        $(".product-details #box-button-save").css({"display": "none"});
        $(".product-details #box-button-update").css({"display": "block"});
    };

    $.fn.deleteTable = function (id) {
        $.ajax({
            url: "delete-In-Container",
            data: {id: id},
            type: "POST",
            success: function (value) {
                var subStrValue = value.substr(0, 4);
                var sizeSet = value.substr(5);
                if (subStrValue == "true") {
                    $("#id" + id).remove();
                    classSuccess();
                    $("#notify").text("Remove success");
                    var colorID = "";
                    var sizeID = "";
                    var kindID = "";
                    var quality = "";
                    var nameFile = "";
                    for (var i = 1; i <= parseInt(sizeSet) + 1; i++) {
                        var changeId = $("#" + i).attr('id');
                        if (typeof(changeId) === "undefined") {
                            for (var j = i + 1; j <= parseInt(sizeSet) + 1; j++) {
                                $("#id" + j).attr("id", "id" + i);
                                $("#" + j).attr('id', i).text(i);
                                $(".idTable" + j).attr("class", "idTable" + i);
                                $("#colorTable" + j).attr("id", "colorTable" + i);
                                $("#sizeTable" + j).attr("id", "sizeTable" + i);
                                $("#kindTable" + j).attr("id", "kindTable" + i);
                                $("#qualityTable" + j).attr("id", "qualityTable" + i);
                                $("#pathImage" + j).attr("id", "pathImage" + i);
                                $("#button-edit" + j).attr("id", "button-edit" + i);

                                colorID = $("#colorTable" + i).attr("class");
                                sizeID = $("#sizeTable" + i).attr("class");
                                kindID = $("#kindTable" + i).attr("class");
                                quality = $("#qualityTable" + i).text();
                                nameFile = $("#pathImage" + i).attr("src");
                                nameFile = nameFile.substr(nameFile.lastIndexOf("/"));

                                // xóa 2 nút button ở table vì đã bị thay đổi
                                $("#button-edit-" + i).remove();
                                $("#button-delete-" + i).remove();

                                // tạo lại nút button với id mới
                                createButtonInTable(i, colorID, sizeID, kindID, quality, nameFile);
                                i++;
                            }
                        }
                    }
                } else {
                    classDanger();
                    $("#notify").text("Internal server error");
                }
            },
            error: function (e) {
                classDanger();
                $("#notify").text("Internal server error");
                console.log(e);
            }
        });
    };

    // cập nhập lại trong khung chứa và sửa lại ở table
    $("#update-product").click(function () {
        var idVal = $("#idOfDetails").val();
        var colorVal = $("#color").val();
        var kindVal = $("#kind").val();
        var sizeVal = $("#size").val();
        var qualityVal = $("#quality").val();

        var colorText = $("#color option:selected").html();
        var sizeText = $("#size option:selected").html();
        var kindText = $("#kind option:selected").html();

        var fileVal = $("#file").val(); // nếu ng dùng chọn ảnh mới thì lấy ảnh mới ngược lại lấy ảnh cũ
        var nameFile = fileVal.substr(fileVal.lastIndexOf("\\") + 1);
        if (nameFile == "") { // khi người dùng không chọn ảnh khi nhấn update thì system lấy ảnh cũ.
            nameFile = $("#showImage").attr('src');
            nameFile = nameFile.substr(nameFile.lastIndexOf("/") + 1);
        }
        // kiểm tra dưới backEnd trước nếu input == null thì dừng lại
        $.ajax({
            url: "update-product-at-add",
            type: "POST",
            data: {
                id: idVal,
                color: colorVal,
                size: sizeVal,
                kind: kindVal,
                quality: qualityVal,
                file: nameFile,
            },
            success: function (value) {
                if (value != "true") {
                    classDanger();
                } else {
                    // xóa button ở table
                    $("#button-edit-" + idVal).remove();
                    $("button-delete-" + idVal).remove();
                    // tạo lại button ở table
                    createButtonInTable(idVal, colorVal, sizeVal, kindVal, qualityVal, nameFile);
                    // sửa lại ở table
                    $("#" + idVal).text("" + idVal);
                    $("#colorTable" + idVal).text("" + colorText);
                    $("#sizeTable" + idVal).text("" + sizeText);
                    $("#kindTable" + idVal).text("" + kindText);
                    $("#qualityTable" + idVal).text("" + qualityVal);
                    $("#pathImage" + idVal).attr("src", "resources/images/" + nameFile);
                    $(".product-details #box-button-save").css({"display": "block"});
                    $(".product-details #box-button-update").css({"display": "none"});
                    emptyBoxProductDetails();
                    classSuccess();
                }
            },
            error: function (e) {
                console.log(e);
            }
        });
    });

    function createButtonInTable(id, color, size, kind, quality, image) {
        $("#button-edit" + id).html("<button type='button' id='button-edit-" + id + "' " +
            "onclick='$(this).editTable(" + id + ", " + color + ", " + size + ", " + kind + ", " + quality + ",\"" + image + "\" )'>EDIT</button>" +
            "<button type='button' id='button-delete-" + id + "' onclick='$(this).deleteTable(" + id + ")'>DELETE</button>");
    }

    // khi các select trong details bị thay đổi thì nút lưu vào khung chứa hiển thị lên.
    $('select, #quality').change(function () {
        $("#save-product").fadeTo(1000, 1);
        $("#save-product").prop("disabled", false);
    });

    // thực hiện lưu vào data
    $("#save-product-data").click(function () {
        var checkTable = $("#id1").attr("id");
        if (typeof(checkTable) === "undefined") {
            $("#notify").text("container empty");
            $("#save-product-data").hide();
            classDanger();
        } else {
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
        }
    });


    // trang editProductAdmin
    $(".row-product-details .disabled").prop("disabled", true);

    $(".edit-main").click(function () {
        if ($(".edit-main").val() == "EDIT") {
            $(".main-form .edit-main").removeClass("btn-info").addClass("btn-success").val("UPDATE");
            $(".main-form .delete-main").removeClass("btn-info").addClass("btn-success").val("UPDATE");

            $(".main-form .disabled").prop("disabled", false);
        } else {
            $(".main-form .edit-main").removeClass("btn-success").addClass("btn-info").val("EDIT");
            $(".main-form .disabled").prop("disabled", true);
        }
    });

    function cssEditDetails(id) {
        $("#formId" + id + " .disabled").prop("disabled", true);
    }

    function cssUpdateDetails(id) {
        $("#formId" + id + " .disabled").prop("disabled", false);
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