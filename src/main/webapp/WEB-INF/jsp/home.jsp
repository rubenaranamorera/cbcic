<!DOCTYPE html>
<html>
<head>
<meta name="google-site-verification" content="J-DfwW20slq2JXv7ZN4FfY_8rm-ickkxZqPDF1tbVS4" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<title>CBCIC</title>
<meta name="description"
	content="CBCIC website">
</head>

<body>		
	<div class="container main-container">		
		<%@ include file="header.jsp" %>		
	       <!-- Carousel
	    ================================================== -->
	    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom:40px;">
	      <!-- Indicators -->
	      <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	        <li data-target="#myCarousel" data-slide-to="3"></li>
	      </ol>
	      <div class="carousel-inner">
	        <div class="item active">
	          <img class="img-carousel" src="resources/img/home/seniorAmasc.jpg" alt="First slide" style="height:275px;">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>Diversió</h1>
	            </div>
	          </div>
	        </div>
	        <div class="item">
	          <img class="img-carousel" src="resources/img/home/sub21fem.jpg" alt="Second slide" style="height:275px;">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>Joventut</h1>
	            </div>
	          </div>
	        </div>
	        <div class="item">
	          <img class="img-carousel" src="resources/img/home/seniorAfem.jpg" alt="Third slide" style="height:275px;">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>Força</h1>
	            </div>
	          </div>
	        </div>
	        <div class="item">
	          <img class="img-carousel" src="resources/img/home/seniorBfem.jpg" alt="Fourth slide" style="height:275px;">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>Equip</h1>     
	            </div>
	          </div>
	        </div>
	      </div>
	      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
	      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
	    </div><!-- /.carousel -->
	    	
	    <div class="container-fluid">  		    
	        <div class="col-md-4 col-sm-12 col-xs-12" style="text-align: center;">
	       		<span class="glyphicon glyphicon-eye-open" style="font-size:6em; text-align: center;"></span>
	          <h2 style="text-align: center;">Informa't</h2>
	          <p>No et perdis l'actualitat del CB CIC! viu els útims partits amb les cròniques, assabenta't de les últimes novetats i coneix tots els horaris de la setmana</p>
	        </div>
	        <div class="col-md-4 col-sm-12 col-xs-12" style="text-align: center;">
	        	<span class="glyphicon glyphicon-user" style="font-size:6em; text-align: center;"></span>
	          <h2 style="text-align: center;">Coneix-nos</h2>
	          <p>Descobreix d'on venim i com som dins de la gran família del CB CIC</p>
	       	</div>
	        <div class="col-md-4 col-sm-12 col-xs-12" style="text-align: center;">
	        	<span class="glyphicon glyphicon-envelope" style="font-size:6em; text-align: center;"></span>	 
	          <h2 style="text-align: center;">Contacta</h2>
	          <p>Estàs buscant equip? Vols implicar-te en el club? Vols anunciar-te a la web? No ho dubtis, contacta amb nosaltres!</p>
	        </div>		      	
      	</div>    
	      
	      <div class="container-fluid">
	      	<div class="bs-docs-section">
	      		<h2 id="novetats" class="page-header" style="font-style:italic;">Novetats</h2>	     
      			<!-- <div class="row">  -->  
     			 	<div class="col-md-8 col-sm-8 col-xs-12" style="margin-bottom:30px;" >
     			 			<a href="article?idNoticia=${noticia.idNoticia}"> 
      			 			<img class="img-border" style="max-width:100%;width:100%; max-height:500px; height:auto;" src="${noticia.fotoUrl}">
      			 		</a>
      			 		<a class="black bold" href="article?idNoticia=${noticia.idNoticia}">
      			 			<h3>${noticia.titol}</h3>
      			 		</a>
      			 		<a class="black" href="article?idNoticia=${noticia.idNoticia}">
      			 			<p class="lines3" style="text-align: center;">${noticia.resum}</p>
      			 		</a>
      			 	</div>  	
	      			<div class="col-md-4 col-sm-4 col-xs-12" style="margin-bottom:30px;" >
   			 			<a class="twitter-timeline" height="500px"  href="https://twitter.com/ClubBasquetCIC" data-widget-id="516704810788085760">Tuits de @ClubBasquetCIC</a>
           				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>  
      				</div>	
      				
      				
      				<c:forEach var="noticia" items="${noticiesList}" varStatus="counter">      			 		
      			 		<div class="col-md-6 col-sm-6 col-xs-12" style="margin-bottom:30px;" >
      			 			<a class="black bold" href="article?idNoticia=${noticia.idNoticia}">
	      			 			<h3>${noticia.titol}</h3>
	      			 		</a>
	      			 		<a href="article?idNoticia=${noticia.idNoticia}"> 
	      			 			<img class="img-border" style="max-width:100%;width:100%; max-height:300px; height:auto; margin-bottom:10px;" src="${noticia.fotoUrl}">
	      			 		</a>
	      			 		<a class="black" href="article?idNoticia=${noticia.idNoticia}">
	      			 			<p class="lines3">${noticia.resum}</p>
	      			 		</a>
	      			 	</div>  
	      			 </c:forEach> 	
	      	</div>	 
	      		      	
	      	<div class="col-xs-12" style="margin-bottom:30px;margin-top:30px;">
	      		<!-- SnapWidget -->
				<script src="http://snapwidget.com/js/snapwidget.js"></script>
				<iframe src="http://snapwidget.com/in/?h=Y2JjaWN8aW58MTAwfDV8MXx8bm98NXxub25lfG9uU3RhcnR8bm98eWVz&ve=300914" title="#cbcic Instagram" class="snapwidget-widget" allowTransparency="true" frameborder="0" scrolling="no" style="border:none; overflow:hidden; width:100%;"></iframe>
	      	</div>      
	      	     
	      </div>
	      
	      <%@ include file="footer.jsp" %>
	      
	   </div> <!-- /container -->	
</body>


<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>