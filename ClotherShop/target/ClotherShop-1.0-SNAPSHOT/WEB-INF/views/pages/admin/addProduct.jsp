<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
    
    .information-main {
        border-style: solid;
        border-color: whitesmoke;
        background-color: white;
        float: left;
        width: 90%;
        margin-top: -1px;
    }
    
    .information-main:hover {
        box-shadow: 2px 5px 15px 5px #1565c0;
    }
    
    .title-info-product {
        background-color: white;
        float: left;
        -moz-border-radius: 10px;
        -webkit-border-radius: 10px;
        -ms-border-radius: 10px;
        -o-border-radius: 10px;
        border-radius: 15px;
    }
    
    .product-detail-form {
        border-style: solid;
        border-color: red;
        float: left;
        width: 90%;
        margin-top: 30px;
        background-color: white;
    }
    
    select {
        width: 100%;
        height: 30px;
        font-size: 17px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    
    .product-detail-form {
        border-style: solid;
        border-color: whitesmoke;
        background-color: white;
        float: left;
        width: 90%;
        margin-top: 19px;
    }
    
    .product-detail-form:hover {
        box-shadow: 2px 5px 15px 5px #1565c0;
    }
    
    #new-color, #new-kind, #new-size {
        font-size: 12px;
        color: #0d59af;
        margin-right: 20px;
    }
    
    .addnewproduct, .addNewProducer {
        display: none;
        position: fixed;
        top: 100px;
        background: white;
        height: auto;
        margin-left: 30px;
    }
    
    .alert {
        display: none;
        position: fixed;
        z-index: 1;
        text-align: center;
        top: 60px;
        font-weight: bold;
        font-size: larger;
        font-variant: small-caps;
    }
</style>
<hr>
<div class="alert col-lg-12">
    <strong id="notify"></strong>
</div>
<div class="container bootstrap snippet col-sm-12">
    <div class="row">
        <div class="col-sm-3" style="float: left; height: 350px">
            <!--left col-->
            <div class="text-center">
                <img src="http://relaxtravel.vn/wp-content/plugins/wp-booking-management-system/assets/images/default.png"
                     class="avatar img-circle img-thumbnail" alt="avatar" style="height: 336px;">
            </div>
        </div>
        <!--/col-3-->
        <div class="col-sm-9">
            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <div style="float: right; margin-right: 10%;">
                        <button type="button" class="btn btn-lg btn-primary" id="creat-new-product">
                            Creat new product
                        </button>
                    </div>
                    <form class="form" method="post" id="product-main">
                        <div class="title-info-product">
                            <h4>Information main product</h4>
                        </div>
                        <div class="information-main">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="code">
                                        <h4>Code</h4>
                                    </label>
                                    <input type="text" class="form-control" id="code" placeholder="enter code."
                                           style="height: 30px; font-size: 17px;">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-6" style="margin-top: -15px">
                                    <label for="name">
                                        <h4>Name</h4>
                                    </label>
                                    <input type="text" class="form-control" id="name"
                                           placeholder="enter name." style="height: 30px; font-size: 17px;">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="price">
                                        <h4>Price</h4>
                                    </label>
                                    <input type="number" class="form-control" id="price"
                                           placeholder="enter price."
                                           style="height: 30px; font-size: 17px;">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="Producer">
                                        <h4>Producer</h4>
                                    </label>
                                    <select name="Producer" id="Producer">
                                        <option value="">-- Select Producer --</option>
                                        <c:forEach items="${producerList}" var="producerLists">
                                            <option value="${producerLists.getIdProducer()}">${producerLists.getNameProducer()}</option>
                                        </c:forEach>
                                    </select>
                                    <a class="new" id="new-producer"> New Producer </a>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="describe">
                                        <h4>Describe</h4>
                                    </label>
                                    <textarea class="form-control" id="describe"
                                              style="height: 100px; font-size: 17px;"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6"  style="padding-top: 28px">
                                    <br>
                                    <button class="btn btn-lg btn-success" id="check-button" type="button"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Check
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                    
                    <form class="product-detail-form" style="display: none">
                        <%--           phần chi tiết của sản phẩm             --%>
                        <div class="product-detail col-xs-12">
                            <div class="col-xs-4" style="margin-top: 30px">
                                <select name="color" id="color">
                                    <option value="">-- Select Color --</option>
                                    <c:forEach items="${colorList}" var="colorLists">
                                        <option value="${colorLists.getIdColor()}">${colorLists.getNameColor()}</option>
                                    </c:forEach>
                                </select>
                                <a class="new" id="new-color"> New Color </a>
                            </div>
                            <div class="col-xs-4" style="margin-top: 30px">
                                <select name="size" id="size">
                                    <option value="">-- Select Size --</option>
                                    <c:forEach items="${sizeList}" var="sizeLists">
                                        <option value="${sizeLists.getIdSize()}">${sizeLists.getNumber()}</option>
                                    </c:forEach>
                                </select>
                                <a class="new" id="new-size"> New Size </a>
                            </div>
                            <div class="col-xs-4" style="margin-top: 30px">
                                <select name="kind" id="kind">
                                    <option value="">-- Select Kind --</option>
                                    <c:forEach items="${kindList}" var="kindLists">
                                        <option value="${kindLists.getIdKind()}">${kindLists.getNameKind()}</option>
                                    </c:forEach>
                                </select>
                                <a class="new" id="new-kind"> New Kind </a>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-4">
                                    <input type="number" class="form-control displayed" id="quality"
                                           placeholder="Quality of product"
                                           style="height: 30px; font-size: 17px; margin-top: 30px">
                                </div>
                            </div>
                            <div class="col-xs-4" style="margin-top: 30px">
                                <input type="file" name="image" style="height: 30px; font-size: 17px; width: 100%"
                                       id="file"
                                       class="text-center center-block file-upload displayed">
                            </div>
                            <div class="form-group">
                                <div class="col-xs-4">
                                    <br>
                                    <button id="save-product" class="btn btn-lg btn-success displayed" type="button"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save to container
                                    </button>
                                </div>
                            </div>
    
                            <div class="form-group">
                                <div class="col-xs-4">
                                    <br>
                                    <button id="save-product-data" class="btn btn-lg btn-success displayed" style="display: none" type="button"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save all Product
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!--/tab-pane-->
        </div>
        <!--/tab-content-->
    </div>
    <!--/col-9-->
</div>
<!--/row-->
<div class="addNewProducer col-sm-10" style="display: none">
    <div class="col-xs-3 col-xs-offset-3" style="height: 100px; margin: 0 auto; padding: 20px; position: absolute;
        left: 50%;
        top: 20%;
        padding: 20px;
        transform: translate(-50%, -50%);">
        <p id="title-producer" style="font-size: 20px; color: #0d59af; text-align: center"></p>
        <input id="newItem-producer" type="text" name="" style="height: 30px; font-size: 17px; width: 100%"
               placeholder="ADD NEW NAME"
               class="text-center center-block ">
        <input id="newItem-producer-address" type="text" name="" style="height: 30px; font-size: 17px; width: 100%"
               placeholder="ADD NEW ADDRESS"
               class="text-center center-block ">
    </div>
    <div style="margin-top: 50px">
        <div class="form-group" style="= width: 300px; margin-top: 100px; margin-left: 410px;">
            <div class="col-xs-2">
                <br>
                <button class="btn btn-lg btn-danger" id="close-producer" type="button"><i
                        class="glyphicon glyphicon-eye-close"></i> Closed
                </button>
            </div>
        </div>
        <div class="form-group" style="float: left; margin-left: 30px">
            <div class="col-xs-2">
                <br>
                <button class="btn btn-lg btn-success" id="save-producer" type="button"><i
                        class="glyphicon glyphicon-ok-sign"></i> Save
                </button>
            </div>
        </div>
    </div>
</div>


<%--           phần thêm dữ liệu mới         --%>
<div class="addnewproduct col-sm-10">
    <div class="col-xs-3 col-xs-offset-3" style="height: 100px; margin: 0 auto; padding: 20px; position: absolute;
        left: 50%;
        top: 50%;
        padding: 20px;
        transform: translate(-50%, -50%);">
        <p id="title" style="font-size: 20px; color: #0d59af; text-align: center"></p>
        <input id="newItem" type="text" name="" style="height: 30px; font-size: 17px; width: 100%"
               class="text-center center-block ">
    </div>
    <div style="margin-top: 40px">
        <div class="form-group" style="= width: 300px; margin-top: 150px; margin-left: 410px;">
            <div class="col-xs-2">
                <br>
                <button class="btn btn-lg btn-danger" id="close" type="button"><i
                        class="glyphicon glyphicon-eye-close"></i> Closed
                </button>
            </div>
        </div>
        <div class="form-group" style="float: left; margin-left: 30px">
            <div class="col-xs-2">
                <br>
                <button class="btn btn-lg btn-success" id="save" type="button"><i
                        class="glyphicon glyphicon-ok-sign"></i> Save
                </button>
            </div>
        </div>
    </div>
</div>
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
    });//end
</script>