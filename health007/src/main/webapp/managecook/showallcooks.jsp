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
    
<title>ShowAllCook Manager Page</title>


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
			食譜管理 <small>Manage Cook</small>					
		<input type="button" value="新增" class="btn btn-primary pull-right" onclick="window.location.href='<c:url value="/managecook/insertonecook.jsp" />'"></input>
		</h1>	
	</div>

<div class="col-lg-12">
<!-- table -->
<div class="table-responsive">        
<table style="font-size:16px;" id="myTable">
<thead style="background:#2c3e50; color:white; font-size:20px;">
	<tr>
		<th width="5%">編號</th>
		<th width="10%">　 名稱</th>
		<th width="25%">　　　　　　烹煮方式</th>
		<th width="10%">　 分類</th>
		<th width="10%">　 圖片</th>
		<th width="10%">　卡洛里</th>
		<th width="10%">　 適用</th>
		<th width="10%">　顯示狀態</th>
		<th width="10%">　 管理</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="cooks" items="${AllCooks}">
		<tr align='center' valign='middle'>
			<td style="background:#2c3e50; color:white">${cooks.id}</td>
			<td>${cooks.name}</td>
			<td style="text-align:left;">${cooks.cooking}</td>
			<td>${cooks.cookbookType}</td>
			<td><img src='${pageContext.servletContext.contextPath}/getImage?id=${cooks.id}&type=RECOMMAND' style="height:100px; width:100px"/></td>
			<td>${cooks.calories}</td>
			<td>${cooks.suit}</td>
			<td>${cooks.cookbookStatus}</td>
			<td>
		
			<!-- 這些隱藏欄位都會送到後端 -->
				<FORM  action="<c:url value='/Manage/UpdateCook.do' />" method="POST"  enctype="multipart/form-data">
	               <Input type='hidden' name='cookId' value='${cooks.id}'><P/>
	               <Input type='hidden' name='cookName' value='${cooks.name}'><P/> 
	               <Input type='hidden' name='cooking' value='${cooks.cooking}'><P/> 
	               <Input type='hidden' name='cookType' value='${cooks.cookbookType}'><P/>
	               <Input type='hidden' name='cookPic' value='${cooks.pic}'><P/>
	               <Input type='hidden' name='cookCalories' value='${cooks.calories}'><P/>
	               <Input type='hidden' name='cooksuit' value='${cooks.suit}'><P/>
	               <Input type='hidden' name='cookStatus' value='${cooks.cookbookStatus}'><P/>
	               
	               <input type="submit" name="cooktion" value="修改" class="btn btn-primary"></input>
				   <input type="submit" name="cooktion" value="隱藏" class="btn btn-primary"></input>

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