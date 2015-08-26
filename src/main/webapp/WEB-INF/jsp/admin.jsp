<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"	rel="stylesheet">
<link href="resources/css/summernote.css" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/summernote.min.js"></script>


<title>CBCIC</title>
<meta name="description"
	content="text/html; charset=UTF-8">
</head>

<body>
	<div class="container main-container">
	    <%@ include file="header.jsp" %>

        <div class="container-fluid">

            <div class="dropdown col-md-10 col-md-offset-1 col-sm-12 col-xs-12" style="margin-bottom:20px;">

                <c:if test="${success}">
                    <div class="alert alert-success" role="alert" style="margin-bottom:10px;">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                        <span class="sr-only">OK</span>
                        ${missatge}
                    </div>
                </c:if>

                <c:if test="${error}">
                    <div class="alert alert-danger" role="alert" style="margin-bottom:10px;">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error</span>
                         ${missatge}
                    </div>
                </c:if>
            </div>


            <c:if test="${superAdmin}">
            <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12" style="margin-top:20px; margin-bottom:10px;">

                <form action="/admin/crear-usuari" method="POST">
                    <div class="form-group">
                        <label for="usuari">Usuari</label>
                        <input type="text" class="form-control" id="usuari" name="usuari" placeholder="User">
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="superAdmin" name="superAdmin" value="false" onClick="javascript:toogleValue('superAdmin')"/> És un super usuari
                        </label>
                     </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="email">
                    </div>

                    <button type="submit" class="btn btn-default">Crear</button>
                </form>
            </div>
            </c:if>

            <div class="dropdown col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12" style="text-align:center; margin-top:20px; margin-bottom:10px;">
                  <button class="btn btn-default dropdown-toggle" type="button" id="noticiesDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Llistat de notícies
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="noticiesDropdown">
                    <c:forEach var="noticia" items="${noticiesList}" varStatus="iteratorIndex">
                        <li>
                            <a href="#" onClick="javascript:loadNoticia('${iteratorIndex.index}', '${noticia.titol}','${noticia.resum}', '${noticia.fotoUrl}', '${noticia.keywords}', ${noticia.portada}, ${noticia.cronica}, '${noticia.owner}', ${noticia.idNoticia});">${noticia.titol}</a>
                            <div class="hide" id="noticia${iteratorIndex.index}">${noticia.contingut}<div>
                        </li>
                    </c:forEach>
                  </ul>
            </div>


            <div class="dropdown col-md-10 col-md-offset-1 col-sm-12 col-xs-12" style="margin-bottom:20px;">
                <form id="form-noticia" action="/" method="POST" accept-charset="ISO-8859-1">
                    <div class="form-group">
                        <label for="titol">Títol</label>
                        <input type="text" class="form-control" id="titol" name="titol" placeholder="Títol de la notícia" />
                    </div>
                    <div class="form-group">
                        <label for="resum">Resum</label>
                        <input type="text" class="form-control" id="resum" name="resum" placeholder="Resum de la noticia en una línia"/>
                    </div>
                    <div class="form-group">
                        <label for="contingut">Contingut</label>
                        <input type="hidden" class="form-control" id="contingut" name="contingut"/>
                        <div id="summernoteContingut">Contingut de la notícia</div>

                    </div>

                    <div class="form-group">
                        <label for="fotoUrl">Url de la imatge</label>
                        <input type="text" class="form-control" id="fotoUrl" name="fotoUrl" placeholder="resources/img/general/logoCic.jpg"/>
                    </div>
                    <div class="form-group">
                        <label for="keywords">Keywords</label>
                        <input type="text" class="form-control" id="keywords" name="keywords" placeholder="Keywords de la notícia"/>
                    </div>
                    <div class="checkbox">
                        <label>
                          <input type="checkbox" id="cronica" name="cronica" onClick="javascript:toogleValue('cronica')" value="false" /> És una crònica
                        </label>
                     </div>
                    <div class="checkbox">
                        <label>
                          <input type="checkbox" id="portada" name="portada" onClick="javascript:toogleValue('portada')" value="false" /> És una notícia de portada
                        </label>
                     </div>
                     <input type="hidden" class="form-control" id="idNoticia" name="idNoticia"/>
                     <input type="hidden" class="form-control" id="owner" name="owner"/>


                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalCrear">Crear</button>
                    <button type="submit" class="btn btn-default" onClick="javascript:editNoticia();">Editar</button>
                    <button type="submit" class="btn btn-default" onClick="javascript:deleteNoticia();">Eliminar</button>



                    <!-- Modal -->
                    <div class="modal fade" id="modalCrear" tabindex="-1" role="dialog" aria-labelledby="Crear notícia">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">

                          <div class="modal-body">
                                <div class="alert alert-danger" role="alert" style="margin-top:10px;margin-bottom:10px;">
                                     <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                     <span class="sr-only">Error</span>
                                    Al crear una notícia apareixerà directament a la web. Estàs segur de voler continuar?
                                 </div>
                          </div>
                          <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" onClick="javascript:createNoticia();">Crear</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel·lar</button>
                          </div>
                        </div>
                      </div>
                    </div>

                    <!-- Modal -->
                        <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="Editar notícia">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">

                              <div class="modal-body">
                                    <div class="alert alert-danger" role="alert" style="margin-top:10px;margin-bottom:10px;">
                                         <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                         <span class="sr-only">Error</span>
                                        Al editar una notícia apareixerà directament a la web. Estàs segur de voler continuar?
                                     </div>
                              </div>
                              <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onClick="javascript:editNoticia();">Editar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel·lar</button>
                              </div>
                            </div>
                          </div>
                        </div>

                        <!-- Modal -->
                        <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="Eliminar notícia">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">

                              <div class="modal-body">
                                    <div class="alert alert-danger" role="alert" style="margin-top:10px;margin-bottom:10px;">
                                         <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                         <span class="sr-only">Error</span>
                                        Al eliminar una notícia desapareixerà directament a la web i es perdrà tota la informació. Estàs segur de voler continuar?
                                     </div>
                              </div>
                              <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onClick="javascript:deleteNoticia();">Crear</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel·lar</button>
                              </div>
                            </div>
                          </div>
                        </div>

                </form>
            </div>
            <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12" style="text-align: center; margin-bottom:20px;">
                 <a class="btn btn-default btn-lg" href="/login/logout" >Tancar la sessió</a>
            </div>

        </div>


	    <%@ include file="footer.jsp" %>

	</div>

</body>

<script>

    $(document).ready(function() {
      $('#summernoteContingut').summernote();
    });

   function loadNoticia(index, titol,resum, fotoUrl, keywords, portada, cronica, owner, idNoticia ){

           $('#summernoteContingut').code("your text");
           $('#summernoteContingut').code($("#noticia" + index).html());
           $("#contingut").val($("#noticia" + index).html());
           $("#titol").val(titol);
           $("#resum").val(resum);
           $("#fotoUrl").val(fotoUrl);
           $("#keywords").val(keywords);
           $("#owner").val(owner);
           $("#idNoticia").val(idNoticia);


           $("#portada").val(portada);

           if (portada){
                $("#portada").attr('checked', 'checked');
           }
           else{
                $("#portada").removeAttr('checked');
           }

           $("#cronica").val(cronica);
           if (cronica){
                $('#cronica').attr('checked', 'checked');
            }
            else{
               $("#cronica").removeAttr('checked');
            }
   	};

    function toogleValue(id){

        var valor = $("#"+id).val();
        if (valor == "false") {
            valor = true;
        }
        else{
            valor = false;
        }
        $("#"+id).val(valor);
    };

    function createNoticia(){
        var sHTML = $('#summernoteContingut').code();
        $("#contingut").val(sHTML);
        $('#form-noticia').attr('action', '/admin/crear-noticia');
    };

    function editNoticia(){
        var sHTML = $('#summernoteContingut').code();
        $("#contingut").val(sHTML);
        $('#form-noticia').attr('action', '/admin/editar-noticia');
    };

    function deleteNoticia(){
        var sHTML = $('#summernoteContingut').code();
        $("#contingut").val(sHTML);
        $('#form-noticia').attr('action', '/admin/eliminar-noticia');
    };


</script>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/summernote.min.js"></script>