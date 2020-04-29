<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="animated fadeIn">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <strong class="card-title">Users List</strong>
                    </div>
                    <div class="card-body">
                        <div id="bootstrap-data-table_wrapper"
                             class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="bootstrap-data-table"
                                           class="table table-striped table-bordered dataTable no-footer" role="grid"
                                           aria-describedby="bootstrap-data-table_info"
                                           style="text-transform: capitalize;">
                                        <thead>
                                        <tr role="row">
                                            <th class="sorting_asc" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1" aria-sort="ascending"
                                                aria-label="Name: activate to sort column descending"
                                                style="width: 171px;">Name
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Position: activate to sort column ascending"
                                                style="width: 281px;">Address
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Office: activate to sort column ascending"
                                                style="width: 123px;">Birthday
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                aria-label="Salary: activate to sort column ascending"
                                                style="width: 96px;">Phone
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table"
                                                rowspan="1" colspan="1"
                                                style="width: 96px;">Information
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${getAllUser}" var="getAllUsers">
                                            <tr role="row" class="odd">
                                                <td class="sorting_1">${getAllUsers.getName()}</td>
                                                <td>${getAllUsers.getAddress()}</td>
                                                <td>${getAllUsers.getBirthday()}</td>
                                                <td>${getAllUsers.getPhone()}</td>
                                                <td><a href="admin-profile?id=${getAllUsers.getIdUser()}">
                                                    <i class="fa fa-info-circle"
                                                       style="color: #1da1f2; margin-left: 35%; font-size: larger"></i>
                                                </a></td>
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