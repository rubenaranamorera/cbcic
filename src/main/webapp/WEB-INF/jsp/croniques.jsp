<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"	rel="stylesheet">
<link href="resources/css/general.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<meta charset="UTF-8">

<title>CBCIC</title>
<meta name="description"
	content="CBCIC website">
</head>

<body>		
	<div class="container main-container">	
	
		<%@ include file="header.jsp" %> 
	      
	      <div class="container-fluid">
	      	<div class="bs-docs-section">
	      		<h2 id="novetats" class="page-header" style="font-style:italic;">Cròniques</h2>	  
	      		
	      		<c:forEach var="noticia" items="${noticiesList}" varStatus="counter">	      			      		
	      			<div class="col-md-4 col-sm-6 col-xs-12" style="margin-bottom:30px;" > 	      				
	      				
	      				<div style="font-size: 10px;width:100%; height:30px;line-height:30px;display:inline-block; vertical-align:middle;padding-left:15px;background-color:#0b173b;color:#FFFFFF; overflow: hidden;">
			      			<strong>${noticia.keywords}</strong>	      				
			      		</div>	
			      		
			      		<div style="font-size: 10px;width:100%; height:30px; margin-bottom:-10px;line-height:30px;display:inline-block; vertical-align:middle;padding-left:15px;background-color:#F0F7FF;color:#0b173b; overflow: hidden;">
			      			<span style="font-size: 10px;font-style:italic;">${noticia.timeAgo}</span>
			      			<div style="float:right; padding-top: 5px;  margin-right:-20px;">
			      				<a href="https://twitter.com/share" class="twitter-share-button" data-via="ClubBasquetCIC" data-hashtags="cbcic">Tweet</a>
								<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
				 	      	</div>      				
			      		</div>	
	      				
     			 		<a href="article?idNoticia=${noticia.idNoticia}"> 
      			 			<h3 style="text-align: center; color:#000000">${noticia.titol}</h3>
      			 		</a>
      			 		<a href="article?idNoticia=${noticia.idNoticia}"> 
      			 			<img style="max-width:100%;width:100%; max-height:200px; height:200px; margin-bottom:10px;" src="${noticia.fotoUrl}">
      			 		</a>
      			 		<p>${noticia.resum}</p>
      			 		<div class="btn-group">						 
						  <button type="button" class="btn btn-default" onClick="javascript:loadArticle(${noticia.idNoticia});" >Llegeix més</button>
						</div>
      			 
			    	</div>			    	
	      		</c:forEach>
	      	</div>	         
	      	
	      	<nav class="col-md-12 col-sm-12 col-xs-12">
				<ul class="pager">
					<c:if test="${pagina gt 0}">
						<li><a href="noticies?pag=${pagina - 1}">Anterior</a></li>
					</c:if>
					<c:if test="${totalPagines gt pagina + 1}">
						<li><a href="noticies?pag=${pagina + 1}">Següent</a></li>
					</c:if>
				</ul>
			</nav>  
			   
	      </div>
	      
	     <%@ include file="footer.jsp" %>
	   </div> <!-- /container -->	
</body>

<script>

	function loadArticle(idNoticia){		
		var url = "article?idNoticia=" + idNoticia;
		location.href = url;
	}
	
</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>