<%--
  Created by IntelliJ IDEA.
  User: MaiTuanAnhLapTop
  Date: 12/1/2019
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	
</head>
<body>
	<button onclick="" id="restful">
		click get restful
	</button>
	<button onclick="" id="returnRestful">
		click return restful
	</button>
	<script type=”text/javascript” src=”http://code.jquery.com/jquery-2.0.3.min.js”></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>
		$(document).ready(function () {
            $("#restful").click(function () {
                $.ajax({
	                url:"api",
	                success: function (data) {
		                console.log(data);
		                var datademo =
		                                    {"id":10,"name":"sinu"};
			                                // {"id":20,"name":"shinto", "arr":[{"ida":"1", "namea":"abc"}]}
		                                
		                jQuery(datademo).each(function (i, item) {
                            console.log(item.id + " - " + item.name);
                            jQuery(item.arr).each(function (i2, item2) {
                                console.log(item2.ida + " - " + item2.namea);
                            })
                        })
                    }
                })
            });

            $("#returnRestful").click(function () {
                var datademo =  [
                    {"id":10,"name":"sinu"},
                    {"id":20,"name":"shinto"}
                ];
                $.ajax({
                    url:"getApiUser",
	                type: "post",
                    contentType: "application/json",
	                data: datademo,
                    success: function (data) {
                        console.log(data);
                    }
                })
            });
            
        })
	</script>
</body>
</html>
