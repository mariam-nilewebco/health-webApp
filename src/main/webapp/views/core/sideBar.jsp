 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diseases List</title>
 <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css"
        rel="stylesheet">
         <link href="${pageContext.request.contextPath}/resources/style.css"
        rel="stylesheet">
        
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
        
  <!--  <link href="${pageContext.request.contextPath}/webjars/font-awesome/css/font-awesome.min.css" rel="stylesheet"></link>
    <link href="${pageContext.request.contextPath}/webjars/font-awesome/5.8.2/css/font-awesome.min.css"  rel="stylesheet"></link>
   --> 
    <link href="${pageContext.request.contextPath}/webjars/font-awesome/5.15.1/css/all.min.css" type="text/css" rel="stylesheet"></link>
    <link href="${pageContext.request.contextPath}/webjars/font-awesome/5.15.1/css/font-awesome.min.css" type="text/css" rel="stylesheet"></link>
  <script src="${pageContext.request.contextPath}/webjars/font-awesome/5.15.1/js/fontawesome.min.js"></script>
  
 <!--<link href="${pageContext.request.contextPath}/webjars/font-awesome/5.8.2/css/font-awesome.min.css"4.7.0
        rel="stylesheet"> -->
<script type="text/javascript">
function navigate(evt){
	
	var btn=evt;
	console.log('evt',evt);
	var form1=document.getElementById('form1'); 
	//var btn=document.getElementById('previous');
	console.log('navigate',btn.id,form1.action+'/'+btn.id);
	form1.action=form1.action+'/'+btn.id;
	var sbm=document.getElementById('submit');
	console.log(sbm);
	sbm.click();
	 
}

</script>

</head>
<body class="sb-nav-fixed">
  <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html">Start Bootstrap</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a>
                        <a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="login.html">Logout</a>
                    </div>
                </li>
            </ul>
        </nav>
          <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                             
                            <div class="sb-sidenav-menu-heading">Health</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-disease"></i></div>
                                Diseases
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/Diseases">Add Diseases</a>
                                    <a class="nav-link" href="${pageContext.request.contextPath}/Diseases/list">Diseases List</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-head-side-cough"></i></div>
                                Symptoms
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                 <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Symptoms">Add Symptoms</a>
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Symptoms/list">Symptoms</a>
                                            
                                        </nav>
                                    
                            </div>
                           
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
         
                  
            