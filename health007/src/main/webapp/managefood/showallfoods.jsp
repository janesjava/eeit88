<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
	<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
	<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jq-2.2.3/dt-1.10.12/datatables.min.css"/>
    <script src="${pageContext.servletContext.contextPath}/bootstrap/js/socketscript.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/bootstrap/css/socketstyle.css" />

<%-- <c:if test="${empty LoginOK}"> --%>
<%-- 	<c:redirect url="/login.jsp" /> --%>
<%-- </c:if>     --%>
   
<title>ShowAllFood Manager Page</title>

<style>
#page-wrapper{
	font-family:'consolas' , '微軟正黑體', sans-serif;
}
table{
  text-align:center;
  margin: auto;
  padding: 20px;
  border-collapse: separate;
  border-spacing: 0;
}
td{
  border-bottom: 1px solid #2c3e50;
  padding: 10px 30px;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
    $('#myTable').DataTable();    
    if($('#page-wrapper')){    	
    }      
});
</script>


</head>
<body>

<div id="wrapper">
<jsp:include page="/global/manager.jsp" />
<div id="page-wrapper"><!--網頁內容-->
	<div class="container-fluid">
<!-- **************************************  -->

	<div class="col-lg-12">
		<h1 class="page-header">
			食物管理 <small>Manage Food</small>			
		<input type="button" value="新增" class="btn btn-primary pull-right" onclick="window.location.href='<c:url value="/managefood/insertonefood.jsp" />'"></input>		
		</h1>	
	</div>

<div class="col-lg-12">
<!-- table -->
<div class="table-responsive">        
<table style="font-size:16px;" id="myTable">
<thead style="background:#2c3e50; color:white; font-size:20px;">
	<tr>
		<th width="10%">　　編號</th>
		<th width="16%">　　　　名稱</th>
		<th width="16%">　　　　分類</th>
		<th width="16%">　　　　圖片</th>
		<th width="16%">　　　 卡洛里</th>
		<th width="16%">　　　顯示狀態</th>
		<th width="10%">　　管理</th>
	</tr>
</thead>
<tbody>	
	<c:forEach var="foods" items="${AllFoods}">
		<tr align='center' valign='middle'>
			<td style="background:#2c3e50; color:white">${foods.id}</td>
			<td>${foods.name}</td>
			<td>${foods.foodType}</td>
			<td><img src='${pageContext.servletContext.contextPath}/getImage?id=${foods.id}&type=food' style="height:60px; width:60px"/></td>
			<td>${foods.calories}</td>
			<td>${foods.foodStatus}</td>
			<td>
		
			<!-- 這些隱藏欄位都會送到後端 -->
				<FORM  action="<c:url value='/Manage/UpdateFood.do' />" method="POST"  enctype="multipart/form-data">
	               <Input type='hidden' name='foodId' value='${foods.id}'><P/>
	               <Input type='hidden' name='foodName' value='${foods.name}'><P/>
	               <Input type='hidden' name='foodType' value='${foods.foodType}'><P/>
	               <Input type='hidden' name='foodPic' value='${foods.pic}'><P/>
	               <Input type='hidden' name='foodCalories' value='${foods.calories}'><P/>
	               <Input type='hidden' name='foodStatus' value='${foods.foodStatus}'><P/>
	               	               
	               <input type="submit" name="foodtion" value="修改" class="btn btn-primary"></input>
				   <input type="submit" name="foodtion" value="隱藏" class="btn btn-primary"></input>
				   				   
				</FORM>	
			</td>
		</tr>
	</c:forEach>	
</tbody>			
</table>

</div> 
 <!-- table end -->
</div>            

<!-- **************************************  -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/global/manager_bottom.jsp" />
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery.dataTables.min.js"></script>	

</body>
</html>