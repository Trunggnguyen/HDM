<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <link rel="stylesheet" href="<c:url value='/css/admin.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/css/animate.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>"/>


</head>

<body>

  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<c:url value='/admin'/>">Acom Shop - Trang Quản Trị</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="<c:url value='/admin/profile' />">
              <span class="glyphicon glyphicon-user">&nbsp;</span>Xin chào: ${loggedInUser.hoTen }</a>
          </li>
          <li>
            <a href="<c:url value='/logout' />"><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>