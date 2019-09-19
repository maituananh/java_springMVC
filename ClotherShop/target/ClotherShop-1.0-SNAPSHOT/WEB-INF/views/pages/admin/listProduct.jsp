<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="animated fadeIn">
        <div class="row">
            
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <strong class="card-title">Data Table</strong>
                    </div>
                    <div class="card-body">
                        <div id="bootstrap-data-table_wrapper"
                             class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="bootstrap-data-table"
                                           class="table table-striped table-bordered dataTable no-footer" role="grid"
                                           aria-describedby="bootstrap-data-table_info">
                                        <thead>
                                        <tr role="row">
                                            <th class="sorting_asc" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1" aria-sort="ascending"
                                                aria-label="Name: activate to sort column descending"
                                                style="width: 130px;">Codes
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Position: activate to sort column ascending"
                                                style="width: 290px;">Name
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Office: activate to sort column ascending"
                                                style="width: 138px;">Producer
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Size: activate to sort column ascending"
                                                style="width: 138px;">Size
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Price: activate to sort column ascending"
                                                style="width: 138px;">Price
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Salary: activate to sort column ascending"
                                                style="width: 110px;">Detail
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${getAllProduct}" var="getAllProducts">
                                            <tr role="row" class="odd">
                                                <td class="sorting_1">${getAllProducts.getCodesProduct()}</td>
                                                <td>${getAllProducts.getNameProduct()}</td>
                                                <td>${getAllProducts.getProducer().getNameProducer()}</td>
                                                <td>${getAllProducts.getDescribeProduct().substring(10)}.....</td>
                                                <td>$ ${getAllProducts.getPrice()}00</td>
                                                <td><a href="admin-details-product/id=${getAllProducts.getIdProduct()}"><i class="fa fa-info" style="color: #0a44a1; background: white"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- .animated -->
</div>