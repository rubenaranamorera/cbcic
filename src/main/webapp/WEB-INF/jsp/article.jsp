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
	      
	      <div class="container-fluid">
	      	<div class="bs-docs-section">
	      		<h2 id="novetats" class="page-header" style="font-style:italic;">	 
	      			<c:choose>
	      				<c:when test="${noticia.cronica}">Crònica</c:when>
	      				<c:otherwise>Notícia</c:otherwise>
	      			</c:choose>		
	      		</h2>	   
	      	</div>	 	      	      	
	      	
	      	<%-- Keywords --%>
      		<div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1 col-lg-3 col-lg-offset-2" style="background-color:#0b173b;color:#FFFFFF;height:40px;line-height:40px;padding-left:20px; padding-right:20px;vertical-align:middle;" >
      			<strong>${noticia.keywords}</strong>	
      		</div>
      		
      		<%-- Time --%>
      		<div class="col-xs-12 col-sm-6 col-md-5 col-lg-4" style="background-color:#F0F7FF;color:#0b173b;height:40px;line-height:40px;padding-left:20px;vertical-align:middle;overflow: hidden">
      			<span style="font-size: 12px;font-style:italic;">${noticia.timeAgo} (${noticia.dia} / ${noticia.mes} / ${noticia.any})</span>
      		</div>
      		
      		<%-- Twitter --%>
      		<div class="col-xs-12 col-sm-2 col-md-2 col-lg-1"  style="background-color:#F0F7FF;color:#0b173b;height:40px;line-height:40px; padding-top: 5px;">
      			<a href="https://twitter.com/share" class="twitter-share-button" data-via="ClubBasquetCIC" data-hashtags="cbcic">Tweet</a>
				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script> 	    
      		</div>	      		
	      	   
	      	<%-- Títol --%>
	      	<div class="col-xs-12 col-sm-12 col-md-9 col-md-offset-1 col-lg-8 col-lg-offset-2" style="margin-bottom:10px;" >	   	      		
	      		<h3 style="text-align: center;">${noticia.titol}</h3>	      		     	
	      	</div>      	
	      		
	      	<%-- Imatge --%>
	      	<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 imageBorder" style="margin-bottom:30px;">	      		
		 		<img style="width:100%; height:100%; max-height:400px;" src="${noticia.fotoUrl}">		 				 				
		 	</div>	
		 	
		 	<%-- Resum + contingut --%>
		 	<div class="col-xs-12 col-sm-12 col-md-9 col-md-offset-1 col-lg-8 col-lg-offset-2" style="margin-bottom:30px;">	 	
		 		<%--<p style="margin-bottom:20px;"><strong>${noticia.resum}</strong></p> --%>
		 		<p>${noticia.contingut}<p>
		 	</div>        
		 			 	
	      </div>
	   <%@ include file="footer.jsp" %>
	   </div> <!-- /container -->    		
	
</body>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>