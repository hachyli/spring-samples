<%@ include file="taglib.jsp" %>
<html>
<head>
<title>Login Page</title>
	<script src="resources/jquery/js/jquery-1.8.2.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	
<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
</head>
<body>

	<div class="container">
	<form:form action="login.htm" method="POST" commandName="user" cssClass="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <form:input path="userName" cssClass="input-block-level" />
        <form:password path="password" cssClass="input-block-level"/>
       
        <button class="btn btn-small btn-primary" type="submit">Sign in</button>
       
        <c:if test="${not empty error}">
		<div class="errorblock">
			<label class="text-error"><strong>
			${error}
			</strong></label>
		</div>
		</c:if>
      </form:form>
      

    </div>
    
	
</body>
</html>