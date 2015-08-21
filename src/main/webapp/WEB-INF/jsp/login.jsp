<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"	rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<title>CBCIC</title>
<meta name="description"
	content="CBCIC website">
</head>

<body>		
	<div class="container main-container">
	    <%@ include file="header.jsp" %>

        <div class="container-fluid">
            <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12" style="text-align: center; margin-top:30px; margin-bottom:30px;">

               <c:if test="${error}">
                    <div class="alert alert-danger" role="alert" style="margin-bottom:10px;">
                     <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                     <span class="sr-only">Error</span>
                     Usuari o contrasenya incorrectes
                   </div>
               </c:if>


                <form action="/login/login" method"POST">
                    <div class="form-group">
                        <label for="usuari">Usuari</label>
                        <input type="text" class="form-control" id="usuari" name="usuari" placeholder="User">
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>

                    <button type="submit" class="btn btn-default">Entrar</button>
          		</form>


            </div>
        </div>

	    <%@ include file="footer.jsp" %>

	</div>
</body>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>