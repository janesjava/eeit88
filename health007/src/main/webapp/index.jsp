<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta name="description" content=""/>
<meta name="author" content=""/>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- Custom CSS -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/sb-admin.css" rel="stylesheet"/>
    <!-- Morris Charts CSS -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/plugins/morris.css" rel="stylesheet"/>
    <!-- Custom Fonts -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<title>Test Manager Page</title>
</head>
<body>

<div id="wrapper">
<jsp:include page="/global/manager.jsp" />
<div id="page-wrapper"><!--網頁內容-->
	<div class="container-fluid" style="height:900px">

            
          這裡塞內容  
              


	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/global/manager_bottom.jsp" />	

</body>
</html>