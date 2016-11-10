<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %> 

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header"><!--縮小的選單-->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Health</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav"><!--右上角使用者-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"  style="font-size:18px"><i class="fa fa-user"></i>　使用者<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse"><!--左邊選單-->
                <ul class="nav navbar-nav side-nav" style="font-size:18px">
                    <li class="active">
                        <a href="#"><i class="glyphicon glyphicon-home"></i>　首頁</a>
                    </li>
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-user"></i>　會員專區</a>
                    </li>
                    <li>
                        <a href="<c:url value='/Manage/ShowAllFood.do' />"><i class="glyphicon glyphicon-apple"></i>　食物管理</a>
                    </li>
                    <li>
                        <a href="<c:url value='/Manage/ShowAllCook.do' />"><i class="glyphicon glyphicon-cutlery"></i>　食譜管理</a>
                    </li>
                    <li>
                        <a href="<c:url value='/Manage/ShowAllSport.do' />"><i class="glyphicon glyphicon-heart"></i>　運動管理</a>
                    </li>
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-piggy-bank"></i>　商品管理</a>
                    </li>
                    <li>
                        <a href="<c:url value='/Manage/AllHelps.do' />"><i class="glyphicon glyphicon-list-alt"></i>　問題管理</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>