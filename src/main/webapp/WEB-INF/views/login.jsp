<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

	<link rel="stylesheet" type="text/css" href="<c:url value='resources/css/jquery/jquery-ui.min.css'/>" ></link>
    
        <!-- bootstrap -->
    <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/bootstrap/css/bootstrap.min.css' />" ></link>
    <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/font-awesome/css/font-awesome.min.css' />" ></link>
    
	<style type="text/css">
	.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
body { 
  background: url(resources/img/san_lucas.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.panel-default {
opacity: 0.9;
margin-top:30px;
}
.form-group.last { margin-bottom:0px; }
	</style>  
</head>
<body  onload='document.loginForm.username.focus();'>


<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="fa fa-lock"></span> Login</div>
                <div class="panel-body">
                      <form class="form-horizontal" role="form" name='loginForm'
		 				 action="<c:url value='/login' />" method='POST'>
                    <div class="form-group">
                    	<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>   
                        <label for="nokp" class="col-sm-3 control-label">
                            usuario</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="nokp"  name='username' placeholder="Usuario" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nopend" class="col-sm-3 control-label">
                            Password</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="nopend"  name='password' placeholder="Password" required />
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                                Ingresar</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

		<script src="<c:url value='resources/js/jquery/jquery-1.11.3.min.js'/>" ></script>
        <script src="<c:url value='resources/js/bootstrap/bootstrap.min.js'/>" ></script>
</body>
</html>