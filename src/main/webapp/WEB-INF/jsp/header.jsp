<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"	rel="stylesheet">
<link href="resources/css/general.css" rel="stylesheet" type="text/css">

<head profile="http://www.w3.org/2005/10/profile">

<link rel="icon"
      type="image/png"
      href="resources/logoCic.png" />
</head>

<div class="navbar navbar-inverse" style="margin-top:15px;" >	

	<div class="navbar-header">    
		<button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>		
        <a class="navbar-brand" href="home"><img style="max-width:50px; margin-top: -15px;" src="resources/img/general/logoCic.jpg"></a>
	</div>	

		<div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
		
		
            <ul class="nav navbar-nav">
              <li id="noticiesNav"><a href="noticies">Notícies</a></li>
	            <li id="croniquesNav"><a href="croniques">Cròniques</a></li>
	            <li id="equipsNav" class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Equips<span class="caret"></span></a>
	              <ul class="dropdown-menu" role="menu">
	                <li><a href="senioramasc">Sènior A Masc</a></li>
	                <li><a href="seniorbmasc">Sènior B Masc</a></li>
	                <li><a href="juniormasc">Júnior Masc</a></li>
	                <li><a href="seniorafem">Sènior A Fem</a></li>
	                <li><a href="seniorbfem">Sènior B Fem</a></li>
	                <li><a href="sots21fem">Sots-21 Fem</a></li>
	                <li><a href="veterans">Veterans</a></li>
	              </ul>
	            </li>
	            <%--li id="horarisNav"><a href="horaris">Horaris</a></li>
	            <li id="resultatsNav"><a href="resultats">Resultats</a></li --%>
	            <li id="contactaNav"><a href="contacta">Contacta</a></li>
	            <li id="onsomNav"><a href="onsom">On Som</a></li>
	            <li id="historiaNav"><a href="historia">Història</a></li>
            </ul>
            <div style="float: right; margin-right: 10px; margin-top: 10px;">
	        	<a href="https://twitter.com/ClubBasquetCIC" class="twitter-follow-button" data-show-count="false" data-size="large">Follow @ClubBasquetCIC</a>
			<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>          
           	</div>
      
      </div>
         
</div>    

<script>
	$(document).ready(function(){
		 var id = ${navActive};   
		 $(id).addClass('active');
	}); 
</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>