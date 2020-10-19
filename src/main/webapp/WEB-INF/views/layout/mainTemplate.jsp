<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<!-- <link href=<c:url value="resources/dist/css/bootstrap.min.css" /> rel="stylesheet">  -->
	<link href="${pageContext.request.contextPath}/resources/dist/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/dist/css/nanumgothic.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/dist/css/nanummyeongjo.css" rel="stylesheet">
	<style type="text/css">
		html {
		  overflow-x: hidden; /* Prevent scroll on narrow devices */
		}
		body {
		  padding-top: 70px;
		  margin-right:20px;
		  margin-left:20px;
		}
		footer {
		  padding: 30px 0;
		}
		
		/*
		 * Off Canvas
		 * --------------------------------------------------
		 */
		@media screen and (max-width: 767px) {
		  .row-offcanvas {
		    position: relative;
		    -webkit-transition: all 0.25s ease-out;
		    -moz-transition: all 0.25s ease-out;
		    transition: all 0.25s ease-out;
		  }
		
		  .row-offcanvas-right
		  .sidebar-offcanvas {
		    right: -50%; /* 6 columns */
		  }
		
		  .row-offcanvas-left
		  .sidebar-offcanvas {
		    left: -50%; /* 6 columns */
		  }
		
		  .row-offcanvas-right.active {
		    right: 50%; /* 6 columns */
		  }
		
		  .row-offcanvas-left.active {
		    left: 50%; /* 6 columns */
		  }
		
		  .sidebar-offcanvas {
		    position: absolute;
		    top: 0;
		    width: 50%; /* 6 columns */
		  }
		}
	</style>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div id="container">
		<tiles:insertAttribute name="navigation" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>