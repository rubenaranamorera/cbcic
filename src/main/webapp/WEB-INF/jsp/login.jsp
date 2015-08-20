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
	<div class="container">	
	
		<%@ include file="header.jsp" %>


		</form action="login" method="POST">
           </input type="text" name="user" value="usuario">
           </input type="password" name="password" value="contraseña">
           </input type="submit" value="Enviar">
        </form>

		<form action="/login/login" method"POST">
			<ul>
				<li>
					<label for="usuari">Usuari:<label/>
                    <input type="text" name="usuari"></input>
				</li>
				<li>
					<label for="password">Password:<label/>
                    <input type="password" name="password"></input>
				</li>
			</ul>
			<button class="btn btn-default btn-lg" type="submit">Entrar</a>
		</form>

		<div>
			<p>Error: ${error}</p>
		</div>

	</div>
</body>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>