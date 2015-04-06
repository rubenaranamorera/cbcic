<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"	rel="stylesheet">
<link href="resources/css/general.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script src=http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false"></script>

<title>CBCIC</title>
<meta name="description"
	content="CBCIC website">
</head>

<body onLoad="initialize()">		
	<div class="container main-container">	
	
		<%@ include file="header.jsp" %> 
	      
	      <div class="container-fluid">
	      	<div class="bs-docs-section" >
	      		<h2 id="onSom" class="page-header" style="font-style:italic;">On som</h2>	      		 
	      		 <div class="row">			
	      		 <p style="margin-top:10px;">Els equips del club, juguen al pavelló Infant Jesús, situat a Travessera de Gràcia entre Aribau i Tusset.</p>      
	      		 <p>En concret, el pavelló s'ubica a <strong>Travessera de Gràcia 57-63</strong>, 08006 Barcelona</p>     
      			 	<div class="col-xs-8 col-xs-offset-2" style="margin-bottom:30px;margin-top:30px;" >
      			 		<div id="googleMap" style="width:100%;height:400px;"></div>	  
      			 	</div>
      			 </div>
	      	</div>	            
	      </div>
	      
	  
	    <%@ include file="footer.jsp" %>		
	  
	   </div> <!-- /container -->
    
	
</body>

<script type="text/javascript">
	function initialize() {
	  var mapOptions = {
	    center: new google.maps.LatLng( 41.396432, 2.150087),
	    zoom: 17,
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	  };
	  var map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
	  
	  var marker = new google.maps.Marker({
		    position: new google.maps.LatLng( 41.396432, 2.150087),
		    title:"Pavelló Infant Jesús"
		});

		// To add the marker to the map, call setMap();
		marker.setMap(map);
	  
	}
</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>