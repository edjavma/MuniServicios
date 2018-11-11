<%-- 
    Document   : principal
    Created on : 20/09/2017, 08:35:57 AM
    Author     : ejmorales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        
         <!-- jquery -->
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/jquery/jquery-ui.min.css'/>" ></link>
    
        <!-- bootstrap -->
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/bootstrap/css/bootstrap.min.css' />" ></link>
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/bootstrap/css/bootstrap-theme.min.css'/>" ></link>
    
        <!-- Autocomplete -->
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/angularstrap/docs.min.css'/>" ></link>
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/angularstrap/libs.min.css' />" ></link>	
                
        <!-- Angular material -->
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/angular/angular-material.css'/>" ></link>	
        
        <!-- Angular Table -->
        <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/angular/ng-table.min.css'/>" ></link>
        
        <link rel="stylesheet" href="<c:url value='resources/css/font-awesome/css/font-awesome.min.css'/>" ></link>
        
        <!-- Ionicons -->
		  <link rel="stylesheet" href="<c:url value='resources/css/Ionicons/css/ionicons.min.css'/>" ></link>
		  <!-- Theme style -->
		  <link rel="stylesheet" href="<c:url value='resources/css/AdminLTE.min.css'/>" ></link>
		  <!-- AdminLTE Skins. Choose a skin from the css/skins
		       folder instead of downloading all of them to reduce the load. -->
		  <link rel="stylesheet" href="<c:url value='resources/css/skins/_all-skins.min.css'/>" ></link>
		  <link rel="stylesheet" href="<c:url value='resources/css/styles.css'/>" ></link>
		  <style type="text/css">
		  .editable-table > tbody > tr > td {
			  padding: 4px
			}
			.editable-text {
			  padding-left: 4px;
			  padding-top: 4px;
			  padding-bottom: 4px;
			  display: inline-block;
			}
			.editable-table tbody > tr > td > .controls {
			  //width: 100%
			}
			.editable-input {
			  padding-left: 3px;
			}
			.editable-input.input-sm {
			  height: 30px;
			  font-size: 14px;
			  padding-top: 4px;
			  padding-bottom: }
			  .green {
			  	color:green;
			  }
			  .red{
			  	color:red;
			  }
		  </style>
    </head>
    <body ng-app="modelApp" class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
    	<header class="main-header">
		    <!-- Logo -->
		    <a href="#!/" class="logo">
		      <!-- mini logo for sidebar mini 50x50 pixels -->
		      <span class="logo-mini"><img src="resources/img/50x24px.png" ></span>
		      <!-- logo for regular state and mobile devices -->
		      <span class="logo-lg"><img src="resources/img/124x50px.png" ></span>
		    </a>
		    <!-- Header Navbar: style can be found in header.less -->
		    <nav class="navbar navbar-static-top">
		      <!-- Sidebar toggle button-->
		      <a style="cursor:pointer;" class="sidebar-toggle" data-toggle="push-menu" role="button">
		        <span class="sr-only">Toggle navigation</span>
		      </a>
			<ul class="nav navbar-nav navbar-right" style="padding-right:1%;">
			  <li><a href="#!/pass"><span class="fa fa-compass" style="color:black;"></span> Cambiar Contraseña </a></li>
		      <li><a style="cursor:pointer;"><span class="fa fa-user" style="color:black;"></span> ${username}</a></li>
		      <li><a href="<c:url value="/logout" />"><span class="fa fa-sign-out" style="color:black;"></span>Logout</a></li>
		    </ul>
		    </nav>
		  </header>
		  
		<aside class="main-sidebar">
	    <!-- sidebar: style can be found in sidebar.less -->
	    <section class="sidebar">
	      <!-- Sidebar user panel -->
	      <div class="user-panel">
	      </div>
	     
	      <!-- sidebar menu: : style can be found in sidebar.less -->
	      <ul class="sidebar-menu" data-widget="tree">
	        <li class="header">Menu</li>
	        <li class="treeview">
	         <a href="#">
	            <i class="fa fa-user-o"></i> <span>Mantenimiento Usuario</span>
	            <span class="pull-right-container">
	              <i class="fa fa-angle-left pull-right"></i>
	            </span>
	          </a>
	        
	          	<ul class="treeview-menu">	         
		        <li>
		          <a href="#!/usuario">
		            <i class="fa fa-user-circle-o"></i> <span>Ingreso Usuario</span>
		            <span class="pull-right-container">
		              <!-- <small class="label pull-right bg-green">new</small> -->
		            </span>
		          </a>
		        </li>
		         <li>
		          <a href="#!/role">
		            <i class="fa fa-edit"></i> <span>Ingreso Roles</span>
		            <span class="pull-right-container">
		              <!-- <small class="label pull-right bg-green">new</small> -->
		            </span>
		          </a>
		        </li>
		         <li>
		          <a href="#!/asignar">
		            <i class="fa fa-external-link-square"></i> <span>Asignar UsuarioRole</span>
		            <span class="pull-right-container">
		              <!-- <small class="label pull-right bg-green">new</small> -->
		            </span>
		          </a>
		        </li>
	          </ul>
	        </li>
	        
	       <li class="treeview">
	          <a href="#">
	            <i class="fa fa-share"></i> <span>Rendiciones Provicionales</span>
	            <span class="pull-right-container">
	              <i class="fa fa-angle-left pull-right"></i>
	            </span>
	          </a>
	          <ul class="treeview-menu">
	        <li>
	          <a href="#!/ingreso">
	            <i class="fa fa-edit"></i> <span>Ingreso</span>
	            <span class="pull-right-container">
	              <!-- <small class="label pull-right bg-green">new</small> -->
	            </span>
	          </a>
	        </li>
	        <li>
	          <a href="#!/consulta">
	            <i class="fa fa-edit"></i> <span>Consulta</span>
	            <span class="pull-right-container">
	              <!-- <small class="label pull-right bg-green">new</small> -->
	            </span>
	          </a>
	        </li>
	          </ul>
	        </li> 
	      </ul>
	    </section>
	    <!-- /.sidebar -->
	  </aside>
	  
	  <div class="content-wrapper">
	    <!-- Main content -->
	    <section class="content">
	   		 <div ng-view></div>
	    </section>
    <!-- /.content -->
  </div>
    </div>
        
         <!-- Angularjs -->
        <script src="<c:url value='resources/js/angular/angular.min.js'/>" ></script>
        <script src="<c:url value='resources/js/angular/angular-route.min.js'/>" ></script>
        <script src="<c:url value='resources/js/angular/angular-animate.min.js'/>" ></script>
        <script src="<c:url value='resources/js/angular/angular-aria.js'/>" ></script>
        <script src="<c:url value='resources/js/angular/angular-material.js'/>" ></script>
        
        <!-- jquery y bootstrap -->
        <script src="<c:url value='resources/js/jquery/jquery-1.11.3.min.js'/>" ></script>
        <script src="<c:url value='resources/js/jquery/jquery-ui.min.js'/>" ></script>
        <script src="<c:url value='resources/js/bootstrap/bootstrap.min.js'/>" ></script>
        <script src="<c:url value='resources/js/adminlte.min.js'/>" ></script>
        
        <script src="<c:url value='resources/js/angular-strap/angular-strap.js'/>" ></script>
        <script src="<c:url value='resources/js/angular-strap/angular-strap.tpl.js'/>" ></script>
                <!-- Datepicker -->
        <script src="<c:url value='resources/js/angular-strap/datepicker.js'/>" ></script>
        <script src="<c:url value='resources/js/angular-strap/datepicker.tpl.js'/>" ></script>
        
       
        <!-- momentjs -->	
        <script src="<c:url value='resources/js/moment/moment-with-locales.js'/>" ></script>
        <script src="<c:url value='resources/js/moment/moment-precise-range.js'/>" ></script>
         <script src="<c:url value='resources/js/moment/angular-moment.min.js'/>" ></script>
        
         <!-- Componentes de Bootstrap escritos en angularjs -->
        <script src="<c:url value='resources/js/ui-bootstrap/ui-bootstrap-tpls-0.14.3.min.js'/>" ></script>
        
        <!-- <script type="text/javascript" src="<c:url value='resources/js/google/ng-google-chart.min.js'/>" ></script>-->
        
          <!-- Angular Table -->
         <script src="<c:url value='resources/js/angular/ng-table.min.js'/>" ></script>
         <script src="<c:url value='resources/js/lodash.min.js'/>" ></script>
                
        <script src="<c:url value='resources/js/angular/picklist.js'/>" ></script>
         <!-- Configuracion de angular y ruteos -->
        <script src="<c:url value='resources/app/app.js'/>" ></script>
        
        <!--  Configuracion de controladores -->
        <script src="<c:url value='resources/app/controllers/usuarioController.js'/>" ></script>
        <script src="<c:url value='resources/app/controllers/modeloController.js'/>" ></script>                       
        
        <!--  Configuracion de servicios -->
        <script src="<c:url value='resources/app/services/usuarioService.js'/>" ></script>
        
        <!--  Directivas  -->
         <script type="text/javascript" src="<c:url value='resources/app/directives/trackedTable.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='resources/app/directives/trackedTableCell.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='resources/app/directives/trackedTableRow.js'/>" ></script>
		
		
    </body>
</html>
