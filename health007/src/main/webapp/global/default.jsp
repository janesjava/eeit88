<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="nav navbar-default navbar-fixed-top"> <!-- 固定頁首 -->
	<!-- 頁首 登入/註冊 -->
	<div class="container sign">
		
		 <ul class="nav navbar-nav navbar-right">
		 <c:if test="${ empty sessionScope.LoginOK }" > <!-- 未登入-->
             <li><a data-toggle="tab" href="#"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
             <li><a data-toggle="tab" href="#"><span class="glyphicon glyphicon-edit"></span> Register</a></li>
         </c:if>    
         <c:if test="${ ! empty sessionScope.LoginOK }" > <!-- 登入-->
             <li><a data-toggle="tab" href="#"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
             <li><a data-toggle="tab" href="#"><span class="glyphicon glyphicon-user"></span> Admin</a></li>
         </c:if>
         </ul>
	
		<!-- 縮放用 -->
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span> 
		</button>
	</div>
	
	
	<div class="collapse navbar-collapse" id="myNavbar"> <!-- 底下放要縮放的內容 -->
	<!-- 頁首 Logo&Buttom -->
	<div class="container-fuild">
	    <div class="row">
	  		<div class="col-md-12 col-xs-12 title">
		  		<div class="row">
			  		<div class="col-md-2 col-xs-2 title" >  <!-- style="background: red" -->
						<div class="col-md-offset-9 col-xs-offset-9">
						<img src="${pageContext.servletContext.contextPath }/images/healthlogo12.png"" 
						class="img-fluid" alt="Responsive image" width="300" height="100">
						</div>		  		
			  		</div>
			  		<div class="col-md-10 col-xs-10 title" style=" text-align: center; padding: 6px 0;">  <!-- background-color:pink; -->
			  			<div class="col-md-offset-4 col-xs-offset-4" >
						<div class="col-md-12 col-xs-12">
			  			<ul class="nav nav-tabs function" style="color:#8EBEAE">
			  			
			
					        <li><a href="#" style="color:#8EBEAE">Home</a></li>
					 
					
					        <li><a href="#" style="color:#8EBEAE">每日推薦</a></li>
					     
					   
					        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:#8EBEAE">熱量計算<span class="caret"></span></a>
					            <ul class="dropdown-menu" style="font-family: 微軟正黑體; font-size: 26px;">
					                <li><a href="#"  style="color:#8EBEAE">食物熱量</a></li>
					                <li><a href="#" style="color:#8EBEAE">運動消耗</a></li>
					            </ul>
					        </li>
					 
					 
					        <li><a href="#" style="color:#8EBEAE">購物專區</a></li>
				
					
					        <li><a href="#" style="color:#8EBEAE">公告訊息</a></li>
					
   						</ul> 
   						</div>
			  			</div>
					</div>	
	  			</div>
			</div>
		</div>
	</div>
	</div>
</div>
		<div class="container" style="height: 160px;background:#8EBEAE;width: 1500px;"></div>	
		<div class="container" style="height: 100px;width: 1500px;"></div>  <!-- 留白不要讓內容跟畫面太近 -->

