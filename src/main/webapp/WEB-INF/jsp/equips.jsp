<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"	rel="stylesheet">
<link href="resources/css/general.css" rel="stylesheet" type="text/css">
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
	      	<div class="bs-docs-section">
	      		<h2 id="equips" class="page-header" style="font-style:italic;">${equip.nom}</h2>		      		
	      		<div class="row" style="margin-bottom:50px;">
	      			<div class="col-xs-3 col-xs-offset-1">
	      				<h3 class="page-header">Plantilla</h3>
	      				
	      				<c:forEach var="jugador" items="${jugadorsList}" varStatus="counter">
	      					<a href="javascript:void(0);" onClick="javascript:ocultaJugadors('${counter.index}');"><p>${jugador.numero} - ${jugador.nom} ${jugador.cognom1} ${jugador.cognom2}</p></a>
	      				</c:forEach>     
	      				
	      				<c:forEach var="staffMember" items="${staffMembersList}" varStatus="counter">
	      					<a href="javascript:void(0);" onClick="javascript:ocultaJugadors('${fn:length(jugadorsList) + counter.index}');"><p>${staffMember.carrec} - ${staffMember.nom} ${staffMember.cognom1} ${staffMember.cognom2}</p></a>
	      				</c:forEach> 				
					   				
	      			</div>
	      			<div class="col-xs-7" >
	      				<img style="max-width:100%;width:100%;margin-top:75px; margin-bottom:25px;" src="${equip.fotoUrl}">
	      				<div style="text-align:center;">
	      					<a href="${equip.calendariUrl}"  target="_blank" class="btn btn-default btn-lg" type="button">Calendari</a>
	      					<a href="${equip.classificacioUrl}"  target="_blank" class="btn btn-default btn-lg" type="button">Resultats</a>	      				
	      				</div>
	      			</div>
	      			
	      		</div>
	      		
	      		
	      		<div class="row" style="margin-bottom: 30px;">
	      		
	      			<c:forEach var="jugador" items="${jugadorsList}" varStatus="counter">
	      			
	      				<div id="jugador${counter.index}" style="display:none;">
			      			<div class="col-xs-3 col-xs-offset-4" >
			     				<img src="${jugador.fotoUrl}" style="width:100%;">	      			
			      			</div>
			      			<div class="col-xs-4" style="text-align: center; padding-top: 20px" >
			      				<h3>${jugador.nom} ${jugador.cognom1}</h3>
			      				<p>Número: ${jugador.numero}</p>
			      				<p>Alçada: ${jugador.altura}</p>
			      				<p>Data naixement: ${jugador.dataNaixement}</p>      
			      				<p>Temporades en el club: ${jugador.anysClub}</p>   			
			      			</div>
	      				</div>
	      			</c:forEach>
	      		
	      			<c:forEach var="staffMember" items="${staffMembersList}" varStatus="counter">
	      			
	      				<div id="jugador${fn:length(jugadorsList) + counter.index}" style="display:none;">
			      			<div class="col-xs-3 col-xs-offset-4" >
			     				<img src="${staffMember.fotoUrl}" style="width:100%;">	      			
			      			</div>
			      			<div class="col-xs-4" style="text-align: center; padding-top: 20px" >
			      				<h3>${staffMember.nom} ${staffMember.cognom1}</h3>
			      				<p>Càrrec: ${staffMember.carrec}</p>
			      				<p>Data naixement: ${staffMember.dataNaixement}</p>      
			      				<p>Temporades en el club: ${staffMember.anysClub}</p>     			
			      			</div>
	      				</div>
	      			</c:forEach>
	      	
	     	 </div>
	      </div>
	      </div>
	     	 
	   <%@ include file="footer.jsp" %>		
	      
	   </div> <!-- /container -->
    
	
</body>

<script>
	
	var active;
	
	//A $( document ).ready() block.
	$( document ).ready(function() {
		$("#jugador0").fadeIn(1000);
		active = '0';
	});	

	function ocultaJugadors(numjugador){		
		if (active != numjugador){
			$("#jugador" + active).fadeOut("slow", mostraJugador(numjugador));
		}
	}
	
	function mostraJugador(numjugador){
		$("#jugador" + numjugador).fadeIn("slow");
		active = numjugador;
	}
	

</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>