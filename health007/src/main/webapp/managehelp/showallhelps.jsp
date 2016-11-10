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
<title>ShowAllHelp Manager Page</title>
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
			問題管理 <small>Manage Help</small>
			
		<input type="button" value="新增" class="btn btn-primary pull-right" onclick="window.location.href='<c:url value="/managehelp/insertonehelp.jsp" />'"></input>
			
		</h1>	
	</div>



	<div class="col-lg-12">
<!-- table -->			
	<div class="table-responsive">   
    <table style="font-size:16px;" id="myTable">
    <thead style="background:#2c3e50; color:white; font-size:20px;">
	<tr>
		<th width="10%">　　編號</th>
		<th width="20%">　　　　　關鍵字</th>
		<th width="20%">　　　　　問題</th>
		<th width="30%">　　　　　　　　　答案</th>
		<th width="10%">　顯示狀態</th>
		<th width="10%">　　管理</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="helps" items="${AllHelps}">
		<tr>
			<td style="background:#2c3e50; color:white">${helps.id}</td>
			<td>${helps.keyword}</td>
			<td style="text-align:left;">${helps.question}</td>
			<td style="text-align:left;">${helps.answer}</td>
			<td>${helps.helpStatus}</td>
			<td>

		<!-- 這些隱藏欄位都會送到後端 -->
			<FORM  action="<c:url value='/Manage/HelpChange.do' />" method="POST">
               <Input type='hidden' name='helpID' value='${helps.id}'><P/>
               <Input type='hidden' name='helpKEYWORD' value='${helps.keyword}'><P/>
               <Input type='hidden' name='helpQUESTION' value='${helps.question}'><P/>
               <Input type='hidden' name='helpANSWER' value='${helps.answer}'><P/>
               <Input type='hidden' name='helpHelpStatus' value='${helps.helpStatus}'><P/>
               
			   <input type="submit" name="helption" value="修改" class="btn btn-primary"></input>
			   <input type="submit" name="helption" value="隱藏" class="btn btn-primary"></input>
			   
			</FORM>	
		</td>
		</tr>
	</c:forEach>
	</tbody>		
	</table>
	</div><!-- table-responsive -->			
<!-- table -->
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