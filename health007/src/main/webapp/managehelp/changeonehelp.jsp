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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css">  <!-- jQuery -->
    <script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
	<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>	
    <script src="${pageContext.servletContext.contextPath}/bootstrap/js/socketscript.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/bootstrap/css/socketstyle.css" />

<%-- <c:if test="${empty LoginOK}"> --%>
<%-- 	<c:redirect url="/login.jsp" /> --%>
<%-- </c:if>     --%>

<script type="text/javascript">
$(document).ready(function(){
	var re = /<br *\/?>/gi;
	var text = '${update.answer}'.replace(re,"\n");
	$('#mytextarea').val($('#mytextarea').val()+ text );
});
</script>

<style>
#page-wrapper{
	font-family:'consolas' , '微軟正黑體', sans-serif;
}
input[type=text] {
    width: 230px;
}
</style>

<title>ShowAllHelp Manager Page</title>
</head>
<body>

<div id="wrapper">
<jsp:include page="/global/manager.jsp" />
<div id="page-wrapper" style="height:100vh"><!--網頁內容-->
	<div class="container-fluid">
<!-- **************************************  -->


	<div class="col-lg-12">
		<h1 class="page-header">
			問題修改 <small>Update Help</small>		
		</h1>	
	</div>


<div class="col-lg-12">
<!-- form -->
    <div class="table-responsive">        
    <form action="<c:url value='/Manage/HelpInsert.do' />" method="POST">
		<table>
			<tr>
				<td height="50px" width="80px">編　　號:</td>
				<td><input type="text" name="id" value="${update.id}" readonly></td>
				<td>${error.id}</td>
			</tr>
			<tr>
				<td height="50px">關鍵文字:</td>
				<td><input type="text" name="keyword" value="${update.keyword}"></td>
				<td>${error.keyword}</td>
			</tr>
			<tr>
				<td height="50px">問　　題:</td>
				<td><input type="text" name="question" value="${update.question}"></td>
				<td>${error.question}</td>
			</tr>
			<tr>
				<td height="180px">答　　案:</td>
				<td><textarea id="mytextarea" rows="7" cols="50" name="answer" style="resize: none;"></textarea></td>
				<td>${error.answer}</td>
			</tr>
			<tr>
				<td height="50px">顯示狀態:</td>
				<td>
					<select name="helpStatus">
						<option value="true">顯示</option>
						<option value="false">隱藏</option>
					</select>
				</td>
			</tr>
			<tr>
				<td height="80px" colspan="2">
								
					<input type="submit" name="helption" value="確認修改" class="btn btn-primary"></input>
					<input type="button" value="取　　消" class="btn btn-primary" onclick="window.location.href='<c:url value="/Manage/AllHelps.do" />'"></input>

				</td>
			</tr>
		</table>
	</form>
    </div> 
<!-- form end -->
</div>       

<!-- **************************************  -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/global/manager_bottom.jsp" />
	

</body>
</html>