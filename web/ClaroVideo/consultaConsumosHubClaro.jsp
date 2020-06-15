

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>





<!DOCTYPE html>
<html lang="en">
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Ple</title>
    
  

       <!-- DatePick -->
    <link href="../plantilla/bootdate/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
    
    <!-- Bootstrap -->
    <link href="../plantilla/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Dialog -->
    <link href="../plantilla/css/bootstrap-dialog.min.css" rel="stylesheet">
    
    <!-- Font Awesome -->
    <link href="../plantilla/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../plantilla/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../plantilla/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../plantilla/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../plantilla/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../plantilla/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../plantilla/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">

        <!-- Alert Bootbox -->
    <script src="../plantilla/bootbox/bootbox.min.js"></script> 
    

    <!-- Custom Theme Style -->
    <link href="../plantilla/build/css/custom.min.css" rel="stylesheet">
    
    <!-- Style Modal -->
 
     <style id="compiled-css" type="text/css">
    
        table.display tbody tr:nth-child(even):hover td{
            background-color: #ffc2c2;
        }

        table.display tbody tr:nth-child(odd):hover td {
            background-color: #ffc2c2;
        }


  </style>

    
 
    
  </head>

  <body class="nav-md">
      
      
  <%  
       System.out.println(session.getAttribute("nombre"));
       System.out.println(session.getMaxInactiveInterval());
        if((session.getAttribute("nombre") == null)){
            response.sendRedirect("../index.jsp");
        }
         
        String nombre = (String) session.getAttribute("nombre");    
        String apellido = (String) session.getAttribute("apellido");
        String rol = (String) session.getAttribute("rol");
            
            String displaySegmentacion = "display:block";
            String displayClaroVideo = "display:block";
            String display1 = "display:block";
            String display2 = "display:block";
            String display3 = "display:block";
            String display4 = "display:block";
            String display5 = "display:block";
            String display6 = "display:block";
            String display7 = "display:block";
            
            int selectRol = Integer.parseInt(rol);
            
            switch (selectRol){
             
                     case 2:
                         displaySegmentacion = "display:none";
                         display2 = "display:none";
                         display3 = "display:none";
                         display4 = "display:none";
                         display5 = "display:none";
                         display6 = "display:none";
                         response.sendRedirect("../principal.jsp");
                         break;
                     case 3:
                         display1 = "display:none";
                         display5 = "display:none";
                         display6 = "display:none";
                         response.sendRedirect("../principal.jsp");
                         break;
                     case 4:
                         display5 = "display:none";
                         response.sendRedirect("../principal.jsp");
                         break;
                     case 5:
                         displaySegmentacion = "display:none";
                         display1 = "display:none";
                         display2 = "display:none";
                         display3 = "display:none";
                         display4 = "display:none";
                         display6 = "display:none";
                         response.sendRedirect("../principal.jsp");
                         break;
                     case 6:
                         displaySegmentacion = "display:none";
                         display1 = "display:none";
                         display2 = "display:none";
                         display3 = "display:none";
                         display4 = "display:none";
                         display5 = "display:none";
                         response.sendRedirect("../principal.jsp");
                         break;
                     case 7:
                         displaySegmentacion = "display:none";
                         display2 = "display:none";
                         display3 = "display:none";
                         display4 = "display:none";
                         display5 = "display:none";
                         response.sendRedirect("../principal.jsp");
                         break;
                     case 8:
                         displaySegmentacion = "display:none";
                         display1 = "display:none";
                         display2 = "display:none";
                         display3 = "display:none";
                         display4 = "display:none";
                         display5 = "display:none";
                         display6 = "display:none";

                         break;
                 }
                   
%>
         

        
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><span>CLARO</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
            
              <div class="profile_info">
                    <span>Bienvenido,<%=" "+nombre%></span>
                <h2></h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
             <br />
              <br />
               <br />
                <br />

        
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <!-- <li><a><i class="fa fa-home"></i> Consultas <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                     <li><a href="#">Consulta aprovisionamientos</a></li>
                       <li><a href="#">Consulta aprovisionamientos</a></li>    
                      <li><a href="#">Consulta notificaciones</a></li>    
                       <li><a href="#">Modificaciones</a></li>   
                    </ul>
                  </li>-->
                    <li style="<%=display1%>"><a><i class="fa fa-cogs"></i> Catalogos <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="../configuracion.jsp">Configuracion</a></li>  
                          <li><a href="../aprovisionarpacks.jsp">Aprovisionar</a></li> 
                      </ul>
                  </li>
                  <li style="<%=display6%>"><a><i class="fa fa-home"></i> Consultas <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="../aprovisionamiento.jsp">Consulta aprovisionamientos</a></li>  
                      <li><a href="../notification.jsp">Consulta notificaciones</a></li>  
                     <!--  <li><a href="modificacion.jsp">Modificaciones</a></li>   -->
                    </ul>
                  </li>
                  <li style="<%=displaySegmentacion%>"><a><i class="fa fa-mobile"></i>Focalizada POS <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">                              
                          <li style="<%=display3%>"><a href="../creacion.jsp">Carga de clientes POS</a></li> 
                          <li style="<%=display4%>"><a href="../eliminar.jsp">Eliminar clientes POS</a></li>   
                          <li style="<%=display7%>"><a href="../mantenimiento.jsp">Mantenimiento clientes POS</a></li>
                      </ul>
                  </li>
                  <li style="<%=display5%>"><a><i class="fa fa-user-plus"></i> Administración <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="../userManagement.jsp">Usuarios y Perfiles</a></li>                     
                      </ul>
                  </li>
                   <li style="<%=displayClaroVideo%>"><a><i class="fa fa-play-circle"></i>Gestión Claro Video <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="altasUsuarioHubClaro.jsp">Alta de usuario</a></li> 
                          <li><a href="consultaConsumosHubClaro.jsp">Consulta consumos</a></li>                                    
                      </ul>
                    </li>
                </ul>
              </div>
            </div>         
            <!-- /sidebar menu -->

         
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Opciones
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">                    
                    <li><a href="../EndSesion"><i class="fa fa-sign-out pull-right"></i> Salir</a></li>
                  </ul>
                </li>
         
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
                     
         
            
              <div class="container">
                <h2>Consulta de consumos: Detalle de Cuentas del Usuario</h2>
                <br>
                <div class="panel panel-default">
                  <div class="panel-heading">Detalle cuenta de Usuarios</div>
          
                  <div class="panel-body">
                                  
                        <div class="panel-body">
                            <form action="form_serviceGetSubscription" method="post" id="form_serviceGetSubscription">  
                     
                             <div class="row"> 
                                <div class='col-lg-4'>
                                          <div class="form-group">
                                              <label>Fecha Inicio</label>
                                              <div class='input-group date' id='fechainicioDato' >                                            
                                                  <input type='text' id="fechainicioDatotxt"  data-date-format="DD-MM-YYYY hh:mm:ss a" class="form-control"/>
                                                  <span class="input-group-addon">
                                                      <span class="glyphicon glyphicon-calendar"></span>
                                                  </span>
                                              </div>
                                          </div>
                                      </div>
                                      <div class='col-lg-4'>
                                          <div class="form-group">
                                              <label>Fecha Final</label>
                                              <div class='input-group date'  id='fechafinalDato'>                                            
                                                  <input id="fechafinalDatotxt" type='text' class="form-control"/>
                                                  <span class="input-group-addon">
                                                      <span class="glyphicon glyphicon-calendar"></span>
                                                  </span>
                                              </div>
                                          </div>
                                      </div>        
                                      <br>
                             </div>
                                
                      
                                <br>
                               
                                <div class="row"> 
                                    <div class="col-sm-6">
                                            <div class="form-group">
                                        <label>Selecciona el tipo de busqueda: </label>
                                        <label class="radio-inline">
                                            <input checked="checked" type="radio"  name="optradio" value="0">Telefono
                                        </label>
                                        
                                        <label class="radio-inline">
                                            <input type="radio"  name="optradio" value="1">Email
                                        </label>  
                                     
                                            </div>
                                    </div>
                                </div>
                                
                                 <br>
                                  <div class="row"> 
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label>Ingresa la identidad de la selección:</label>
                                            <input class="form-control" type="text" name="valor" id="valor" placeholder="valor" required="">
                                            <input  class="form-control" type="text" name="valor2" id="valor2" style="display: none;">
                                        </div>
                                    </div>   
                                  </div>
                                 
                             <div class="row"> 
                                <div class="col-sm-4">
                                    <div class="form-group">
                                       <button type="submit" id="btnSubmitSearch" class="btn btn-primary">Buscar</button>
                                       <button type="button" name="btnClear" id = "btnClear"  class="btn btn-primary">Limpiar</button>
                                    </div>
                                </div>
                               
                             </div>
                            </form>

                            <div id="message">
                                <div class="progress">
                                    <div id="progressId" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
                              
                                    </div>
                             
                                </div>   
                                
                               
                            </div>

                            </div>
                        </div>
                 
                  <br />
                  
                  <div class="panel-group" id="accordion">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <h4 class="panel-title">
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                      Datos del Usuario
                                  </a>
                              </h4>
                          </div>
                          <div id="collapse1" class="panel-collapse collapse in">
                              <div class="panel-body">

                                
                                  <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">
                                              <table id="TABLEUSERCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>Email</th>                                                      
                                                          <th>Nombre</th>
                                                          <th>Apellido</th>
                                                          <th>Id. Usuario</th>    
                                                          <th>Medio de Pago</th>          
                                                          <th>No.Cuenta</th>
                                                          <th>Id Cliente</th>
                                                          <th>Estado</th>  
                                                          <th>Tipo</th>
                                                          <th>Editar</th> 
                                                          <th>Cancelación</th>                                                      
                                                      </tr>
                                                  </thead>                                         
                                              </table>
                                          </div>


                                      </div>
                                      <div class="ln_solid"></div>
                                  </div>

                               
                              
                              </div>
                          </div>
                      </div>
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <h4 class="panel-title">
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                      Suscripciones del Usuario</a>
                              </h4>
                          </div>
                          <div id="collapse2" class="panel-collapse collapse">
                              <div class="panel-body">
                                   <div class="panel-body">                                  

                                       <div class="panel panel-default">  

                                           <div class="panel-body">
                                              <div class="container">
                                                   <div class="row">                                                  
                                                   <div class="col-sm-2">                                                           
                                                           <button type="button" id="addSuscriptionAddon" class="btn btn-primary">Agregar Suscripción</button>  
                                                   </div>                                             
                                                   </div>
                                              </div>
                                           </div>  
                                       </div>
                                       
                                   </div>
                                                                    
                                  <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">

                                              <table id="TABLECONSUMOCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>Descripcion</th>
                                                          <th>Ip</th>
                                                          <th>Fecha Alta</th>
                                                          <th>Fecha Expiración</th>
                                                          <th>Fecha Cancelación</th>
                                                          <th>Precio</th>    
                                                          <th>Estado</th>          
                                                          <th>Moneda</th>   
                                                          <th>Id Product</th>   
                                                          <th>Baja</th>
                                                      </tr>
                                                  </thead>                                           
                                              </table>


                                          </div>


                                      </div>
                                      <div class="ln_solid"></div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                     <div class="panel panel-default">
                          <div class="panel-heading">
                              <h4 class="panel-title">
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">
                                      Medios de pago</a>
                              </h4>
                          </div>
                          <div id="collapse5" class="panel-collapse collapse">
                              <div class="panel-body">
                                  
                                  
                                    <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">
                                              <table id="TABLEPAGOSCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>Id</th>
                                                          <th>Descripción</th>                                            
                                                          <th>Baja</th>                                                    
                                                      </tr>
                                                  </thead>                                               
                                              </table>
                                          </div>


                                      </div>
                                      <div class="ln_solid"></div>
                                  </div>

                                  
                                  
                              </div>
                          </div>
                      </div>
                      
                     <div class="panel panel-default">
                          <div class="panel-heading">
                              <h4 class="panel-title">
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">
                                      Rentas</a>
                              </h4>
                          </div>
                          <div id="collapse6" class="panel-collapse collapse">
                              <div class="panel-body">
                                  
                                  
                                    <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">
                                              <table id="TABLEALQUILERCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>Titulo</th>
                                                          <th>Tiempo de Visualización</th>
                                                          <th>Tiempo Max. Visualización</th>
                                                          <th>Fecha de Alta</th>
                                                          <th>Fecha Expiración</th> 
                                                          <th>Precio</th>
                                                          <th>Medio de Pago</th>  
                                                          <th>Renta</th>    
                                                          <th>Moneda</th> 
                                                      </tr>
                                                  </thead>                                            
                                              </table>
                                          </div>


                                      </div>
                                      <div class="ln_solid"></div>
                                  </div>

                                  
                                  
                              </div>
                          </div>
                      </div>
          
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <h4 class="panel-title">
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse7">
                                      Dispositivos del Usuario</a>
                              </h4>
                          </div>
                          <div id="collapse7" class="panel-collapse collapse">
                              <div class="panel-body">
                                  
                                  
                                    <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">
                                              <table id="TABLEDISPOSITIVOSCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>Id Dispositivo</th>
                                                          <th>Tipo de Dispositivo</th>
                                                          <th>Nombre de Dispositivo</th>
                                                          <th>Fecha Activación</th>
                                                          <th>Baja</th>                                                    
                                                      </tr>
                                                  </thead>                                                 
                                              </table>
                                          </div>


                                      </div>
                                      <div class="ln_solid"></div>
                                  </div>

                                  
                                  
                              </div>
                          </div>
                      </div>
                  </div>
                  
                        

                  
                  
                  
                  
              


              </div>
                      
                  </div>
                </div>
            </div>
            

        
        
        <!-- Modal EDICION -->
        <div style="display: none;" class="modal fade" id="myModalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Edicion de datos</h4>
                </div>
                    
                    
             <div class="modal-body">
                <div class="panel panel-default">
                    <div class="panel-heading">Modificación</div>
                    <div class="panel-body">
                        <div class="well well-sm">
                        <form method="post" id="form_serviceUpdateEmail">
                            <div class="form-group row">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                                </div>    
                            </div>
                            <button type="submit" id="emailBtn" class="btn btn-primary mb-2">Confirmar</button>
                        </form>
                   
                        </div>
                        <div class="well well-sm">
                        <form method="post" id="form_serviceUpdateName">
                            <div class="form-group row">
                                <label for="staticEmail" class="col-sm-2 col-form-label">Nombre</label>
                                 <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputPassword" class="col-sm-2 col-form-label">Apellido</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputApellido" placeholder="Apellido">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-10">
                                    <button type="submit" id="updateServiceName" class="btn btn-primary mb-2">Confirmar</button>
                                </div>
                            </div>
            
                        </form>
                        </div>
                        <div class="well well-sm">
                            <form method="post" id="form_serviceUpdatePassword">
                                <div class="form-group row">
                                    <label for="inputPassword" class="col-sm-2 col-form-label">Renovación Password</label>  
                                     <div class="col-sm-10">
                                        <button type="submit" id="updatePassword" class="btn btn-primary mb-2">Confirmar</button>
                                    </div>
                                </div>
                            </form>      
                        </div>
                        
                    </div>
                </div>
                </div>
                </div>
                


            </div>
        </div> 
        <!-- /page EDICION content -->
        
         <!-- Modal ELEGIBILIDAD -->
        <div style="display: none;" class="modal fade" id="myModalEligibility" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Elegibilidad</h4>
                </div>
                    
                    
                    <div class="modal-body">
                        <div class="panel panel-default">
                            <div class="panel-heading">Seleccionar Suscripción</div>
                            <div class="panel-body">


                                <div class="col-lg-12">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table id="TABLEADDONS" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                <thead>
                                                    <tr>                                          
                                                        <th>Id</th>
                                                        <th>Suscripcion</th>
                                                        <th>Key</th>
                                                        <th>Amco</th>   
                                                        <th>Estado</th>
                                                        <th>Agregar</th>   

                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Suscripcion</th>
                                                        <th>Key</th>
                                                        <th>Amco</th>   
                                                        <th>Estado</th>
                                                        <th>Agregar</th>  
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>


                                    </div>
                                    <div class="ln_solid"></div>
                                </div>

                                <div class="row"> 
                                    <div class="col-sm-4">
                                        <div class="form-group">                                   
                                            <button type="button" name="btnCancel" id = "btnCancel"  class="btn btn-primary">Cerrar</button>
                                        </div>
                                    </div>

                                </div>



                            </div>
                        </div>
                    </div>
                </div>
                


            </div>
        </div> 
        <!-- /page ELEGIBILIDAD content -->


        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Ple - Desarrollado por: <a href="https://www.claro.com.gt"> Gerencia Desarrollo de Productos</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>


      <!-- DatePick -->
    <script src="../plantilla/js/jquery-1.9.1.min.js"></script>            
                
    <!-- bootstrap-daterangepicker -->
    <script src="../plantilla/vendors/moment/min/moment.min.js"></script>
    <script src="../plantilla/bootdate/src/js/bootstrap-datetimepicker.js"></script>  
  
    <!-- Bootstrap -->
    <script src="../plantilla/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../plantilla/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../plantilla/vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../plantilla/vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="../plantilla/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../plantilla/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../plantilla/vendors/jszip/dist/jszip.min.js"></script>
    <script src="../plantilla/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../plantilla/vendors/pdfmake/build/vfs_fonts.js"></script>
    
    <!-- Dialog -->
    <script src="../plantilla/js/bootstrap-dialog.min.js"></script>   

    <!-- Custom Theme Scripts -->
    <script src="../plantilla/build/js/custom.min.js"></script>
    
     <!-- Mask -->
     <script src="../plantilla/js/jquery.mask.min.js"></script>
  

    
     <script type="text/javascript">
      var id;
      var rol;
      var progress=0;
        
      var dateinit="";  
      var datefinish="";
      var msisdn="";
      var type="";
      var opcion= "";
      var valor="";
     
      
      $('#message').hide();
     $(function () {
                    $('#fechainicioDato').datetimepicker({                                       
                        format: "DD-MM-YYYY hh:mm:ss a"                      
                        });
                    });
                    
     $(function () {
                    $('#fechafinalDato').datetimepicker({
                        format: "DD-MM-YYYY hh:mm:ss a"                      
                        });
                    });

        
        $(document).ready(function(){
                     
          var newTimeFinish =  moment().format('DD-MM-YYYY');
          
          var newTimeInit =  moment().subtract(31,'day').format('DD-MM-YYYY');
          //var timeAndDate = moment('21-05-2020 00:00:00' , 'DD-MM-YYYY hh:mm:ss',true).format('DD-MM-YYYY hh:mm:ss');
          var initTime = moment(newTimeInit+' '+'11:59:59 PM', 'DD-MM-YYYY hh:mm:ss a').format('DD-MM-YYYY hh:mm:ss a');
          var finishTime = moment(newTimeFinish+' '+'11:59:59 PM', 'DD-MM-YYYY hh:mm:ss a').format('DD-MM-YYYY hh:mm:ss a');
           
         
            $('#fechainicioDatotxt').val(initTime);
            $('#fechafinalDatotxt').val(finishTime);
         
         
         function formatAMPM(date) {
                var hours = date.getHours();
                var minutes = date.getMinutes();
                var ampm = hours >= 12 ? 'pm' : 'am';
                hours = hours % 12;
                hours = hours ? hours : 12; // the hour '0' should be '12'
                minutes = minutes < 10 ? '0'+minutes : minutes;
                var strTime = hours + ':' + minutes + ' ' + ampm;
                return strTime;
        }
        
        
        
        $('#valor').mask('0000 0000');
        
        
        $('input:radio').change(function(){         
            
             var opcion =$("input[name='optradio']:checked").val();
             if(opcion==0){
                 $('#valor').mask('0000 0000');
             }else{
                 $('#valor').unmask();
             }   
        });   
        
        function barProgress(val){
                 progress=progress+val;
                 document.getElementById("progressId").style.width = progress+"%";
                 $("#progressId").text(progress+"%");
                 if (progress == 100) {
                    $("#btnSubmitSearch").attr("disabled", false);
                }
        }
                    
        var tableConsumo= $('#TABLECONSUMOCV').DataTable( );  
        var tableDispositivos= $('#TABLEDISPOSITIVOSCV').DataTable( ); 
        var tableUser=$('#TABLEUSERCV').DataTable( ); 
        var tablePagos=$('#TABLEPAGOSCV').DataTable( ); 
        var tableAlquiler=$('#TABLEALQUILERCV').DataTable( ); 
        var tableAddons=$('#TABLEADDONS').DataTable( ); 
        
        
        function listTables(){
            
          tableAddons.destroy(); 
          tableConsumo.destroy();
          tableDispositivos.destroy();
          tableUser.destroy();
          tablePagos.destroy();
          tableAlquiler.destroy();
          
          tableAddons.clear().draw();
          tableConsumo.clear().draw();
          tableDispositivos.clear().draw();
          tableUser.clear().draw();
          tablePagos.clear().draw();
          tableAlquiler.clear().draw();
          
          
            
          tableConsumo = $('#TABLECONSUMOCV').DataTable( {           
                            "ajax" : {
                            "url": "../GetListSubscriberUserHubClaro",
                            "type": "POST",
                            "data" : function(d){                            
                                             d.option=opcion;
                                             d.valor=valor; 
                                             d.dateinit=dateinit;
                                             d.datefinish=datefinish;
                                            },
                                    "complete" : function(response){
                                       
                                        barProgress(20);    
                                  
                                    }              
                             },           
                            "global" : false,
                            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                            "dataType" : "json",
                            "dom" : "Bfrtip",
                            "buttons" : [
                                  'csv', 'excel'
                                       ],
                            "columns" : [       
                                    {"title": "Descripción"},
                                    {"title": "Ip"},
                                    {"title": "Fecha Alta"},
                                    {"title": "Fecha Expiración"},
                                    {"title": "Fecha Cancelación"},
                                    {"title": "Precio"},
                                    {"title": "Estado"},
                                    {"title": "Moneda"},
                                    {"title": "Id Product"}   

                           ],
                                    "columnDefs": [
                                        {
                                            "targets": 9,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='deleteAddon' data-toggle='tooltip' data-placement='top' title='Eliminar Bundle'>" +
                                                    "<img  src='../img/remove.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        }
                                    ]
                    });  
                    
          tableDispositivos = $('#TABLEDISPOSITIVOSCV').DataTable( {
                            "ajax" : {
                            "url": "../GetListDeviceHubClaro",
                            "type": "POST",
                            "data" : function(d){   
                                             d.dateinit=dateinit;
                                             d.datefinish=datefinish;
                                             d.option=opcion;
                                             d.valor=valor; 
                                            },
                                    "complete" : function(response){                                       
                                        barProgress(20); 
                                    }              
                             }, 
                            "global" : false,
                            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                            "dataType" : "json",
                            "dom" : "Bfrtip",
                            "buttons" : [
                                  'csv', 'excel'
                                       ],
                            "columns" : [       
                                    {"title": "Id Dispositivo"},
                                    {"title": "Tipo de Dispositivo"},
                                    {"title": "Nombre de Dispositivo"},
                                    {"title": "Fecha Activación"}                                     
                            ],
                                    "columnDefs": [
                                        {
                                            "targets": 4,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='deleteDevice' data-toggle='tooltip' data-placement='top' title='Quitar Dispositivo'>" +
                                                    "<img  src='../img/remove.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        }
                                    ]
                    });
                    
          tableUser =  $('#TABLEUSERCV').DataTable( {    
                            "ajax" : {
                            "url": "../GetListDataUserHubClaro",
                            "type": "POST",
                            "data" : function(d){                            
                                             d.option=opcion;
                                             d.valor=valor; 
                                             d.dateinit=dateinit;
                                             d.datefinish=datefinish;
                                            },
                                    "complete" : function(response){                                   
                                     barProgress(20);                                      
                                    }              
                             },
                            "global" : false,
                            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                            "dataType" : "json",
                            "dom" : "Bfrtip",
                            "buttons" : [
                                  'csv', 'excel'
                                       ],
                            "columns" : [   
                                    {"title": "Email"},                      
                                    {"title": "Nombre"},
                                    {"title": "Apellido"}, 
                                    {"title": "Id. Usuario"}, 
                                    {"title": "Id. Cliente"}, 
                                    {"title": "Medio de Pago"}, 
                                    {"title": "No.Cuenta"},
                                    {"title": "Estado"},
                                    {"title": "Tipo"}
                                
                            ],
                                    "columnDefs": [
                                        {
                                            "targets": 9,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='updateCuenta' data-toggle='tooltip' data-placement='top' title='Editar datos'>" +
                                                    "<img  src='../img/pencil.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        },                                  
                                        {
                                            "targets": 10,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='deleteCuenta' data-toggle='tooltip' data-placement='top' title='Bajas'>" +
                                                    "<img  src='../img/remove.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        }
                                    ]
                    });
                    
          tablePagos= $('#TABLEPAGOSCV').DataTable( {
                            "ajax" : {
                            "url": "../GetListPaymentHubClaro",
                            "type": "POST",
                            "data" : function(d){                            
                                             d.option=opcion;
                                             d.valor=valor; 
                                             d.dateinit=dateinit;
                                             d.datefinish=datefinish;
                                            },
                                    "complete" : function(response){                                       
                                        barProgress(20); 
                                    }              
                             }, 
                            "autoWidth": true,                   
                            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                            "dataType" : "json",
                            "dom" : "Bfrtip",       
                            "buttons" : [
                                  'csv', 'excel'
                                       ],
                            "columns" : [       
                                    {"title": "Id"},
                                    {"title": "Descripcion"}  
                            ],
                                    "columnDefs": [  
                                        {
                                            "width": "10%",
                                            "targets": 2,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='deletePago' data-toggle='tooltip' data-placement='top' title='Quitar Pago'>" +
                                                    "<img  src='../img/remove.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        }
                                    ],
                                    fixedColumns: true
                           
                    });
                    
          tableAlquiler= $('#TABLEALQUILERCV').DataTable( {
                            "ajax" : {
                            "url": "../GetListRentHubClaro",
                            "type": "POST",
                            "data" : function(d){                            
                                             d.option=opcion;
                                             d.valor=valor; 
                                             d.dateinit=dateinit;
                                             d.datefinish=datefinish;
                                            },
                                    "complete" : function(response){                                       
                                        barProgress(20); 
                                    }              
                             }, 
                            "global" : false,
                            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                            "dataType" : "json",
                            "dom" : "Bfrtip",
                            "buttons" : [
                                  'csv', 'excel'
                                       ],
                            "columns" : [       
                                    {"title": "Titulo"},
                                    {"title": "Tiempo de Visualización"}, 
                                    {"title": "Tiempo Max. Visualización"},
                                    {"title": "Fecha de Alta"},
                                    {"title": "Fecha Expiración"},
                                    {"title": "Precio"},
                                    {"title": "Medio de Pago"},
                                    {"title": "Renta"},
                                    {"title": "Moneda"}
                            ]
                    });
                    
          tableAddons= $('#TABLEADDONS').DataTable( {
                            "ajax" : {
                            "url": "../TableListAddons",
                            "type": "POST",
                            "data" : function(d){       
                                            d.tableParameter1 = "select fp.ID_FAMILY,fp.PRODUCT_NAME,fp.PRODUCT_KEY,fp.ID_AMCO,( select count(1) from sm_onlinetrx.mpm_subscription_service ss inner join sm_catalog.mpm_service_pack_source ps on(ss.id_source=ps.id_source)  inner join sm_catalog.mpm_products_per_service pps on(ps.service=pps.service)  inner join sm_catalog.mpm_config_pack cp on(pps.pack=cp.id_pack)   where ss.phone=";          
                                            d.tableParameter2= " and ss.state=1 and cp.id_tecnomen=fp.id_amco) as activado from SM_CATALOG.TB_HUB_FAMILY_PRODUCT fp  where GUI_VISIBILITY=1   AND PRODUCT_STATE = 1 AND CLIENT_TYPE='"+type+"'";
                                            d.msisdn = msisdn;
                                            },
                                    "complete" : function(response){                                   
                                 
                                    }              
                             }, 
                            "global" : false,
                            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                            "dataType" : "json",
                            "dom" : "Bfrtip",
                            "buttons" : [
                                  'csv', 'excel'
                                       ],
                            "columns" : [       
                                    {"title": "Id"},
                                    {"title": "Suscripcion"},
                                    {"title": "Key"},
                                    {"title": "Amco"},
                                    {"title": "Estado"}    
                            ],
                                    "columnDefs": [
                                         {
                                        "targets": 4,
                                        "visible": false,
                                        "searchable": false
                                        },
                                        {
                                            "targets": 5,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='selectAddon' data-toggle='tooltip' data-placement='top' title='Agregar Suscripción'>" +
                                                    "<img  src='../img/add.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        }
                                    ]
                    });
            
            
        }
                   
   
                   
        $("#form_serviceGetSubscription").submit(function(event){             
                    event.preventDefault(); //prevent default action                   
                                    
                    progress=0;  
                    barProgress(0);
              
                    dateinit=$("#fechainicioDatotxt").val();
                    datefinish=$("#fechafinalDatotxt").val();
                    opcion =$("input[name='optradio']:checked").val();
                    
                    valor=$("#valor").val().replace(/ /g,'');    
                    msisdn=valor.replace(/ /g,'');
                    
                    
                    //****aca inicia cuando seleccione el email, este busca el msisdn***************
                     if (opcion=="1"){
                         email = valor.replace(/ /g,'');
                        console.log("seleccciona email");
                           $.post(
                            "../GetMsisdnHubClaro",
                        {                   
                            tableParameter: "select msisdn from SM_ONLINETRX.TB_HUB_SUBSCRIBER where email='"+email+"'"
                            
                        },
                        function (json) {           
                            msisdn= json.msisdn;
                        });
                    };
                    //****aca termina la busqueda y asignacion del msisdn por email******************
                           
                     
                        
                    
                     $("#btnSubmitSearch").attr("disabled", true);
                      listTables();
                     $('#message').show();      
                    
                    
                 
            });
            
        $("#form_serviceUpdateEmail").submit(function(event){
                event.preventDefault(); //prevent default action 
                
                var type = "1";
                var auditory="Update Usuario Claro Video";               
                var name = $("#inputNombre").val();
                var lastName = $("#inputApellido").val();                
                var email = $("#inputEmail").val();
                $("#emailBtn").attr("disabled", true);
       
                $.post(
                        "../GetUpdateUser",
                        {   
                            msisdn: msisdn,
                            type: type,
                            name: name,
                            lastName: lastName,
                            email: email,  
                            auditory: auditory
                        },
                function (json) {
                BootstrapDialog.alert(json.message);
                $("#emailBtn").attr("disabled", false);
                updateUserTable();
                });

        });    
        
        $("#form_serviceUpdateName").submit(function(event){
                event.preventDefault(); //prevent default action 
                
                var type = "2";
                var auditory="Update Name Claro Video";               
                var name = $("#inputNombre").val();
                var lastName = $("#inputApellido").val();                
                var email = $("#inputEmail").val();
                $("#updateServiceName").attr("disabled", true);
       
       
                $.post(
                        "../GetUpdateUser",
                        {   
                            msisdn: msisdn,
                            type: type,
                            name: name,
                            lastName: lastName,
                            email: email,  
                            auditory: auditory
                        },
                function (json) { 
                  BootstrapDialog.alert(json.message);
                  $("#updateServiceName").attr("disabled", false);
                updateUserTable();

                });

        });
        
        $("#form_serviceUpdatePassword").submit(function(event){
                event.preventDefault(); //prevent default action 
                
                var type = "3";
                var auditory="Update Password Claro Video";               
                var name = $("#inputNombre").val();
                var lastName = $("#inputApellido").val();                
                var email = $("#inputEmail").val();
                var password = $("#inputPassword").val(); 
                $("#updatePassword").attr("disabled", true);
       
                $.post(
                        "../GetUpdateUser",
                        {   
                            msisdn: msisdn,
                            type: type,
                            name: name,
                            lastName: lastName,
                            email: email,  
                            password: password,
                            auditory: auditory
                        },
                function (json) {  
                $("#updatePassword").attr("disabled", false);
                 BootstrapDialog.alert(json.message);
               
                });

        });
                    
        $("#btnClear").click(function(){
            clearBar();
        });
        
        function clearBar(){
            
            $("#valor").val(""); 
            $("#fechainicioDatotxt").val(""); 
            $("#fechafinalDatotxt").val("");
            tableConsumo.clear().draw();
            tableUser.clear().draw();
            tableDispositivos.clear().draw();
            tableAlquiler.clear().draw(); 
            tablePagos.clear().draw();
            progress=0;  
            barProgress(0);
            $('#message').hide();
            
        }
        
        function updateUserTable(){
              progress=0;  
              barProgress(0);
              tableUser.clear().draw();
              tableUser.ajax.reload();
              barProgress(80); 
        }
        
        
        $('#TABLEUSERCV tbody').on('click', '#updateCuenta', function () {

        var data = tableUser.row($(this).parents('tr')).data();
        var email = data[0];
        var nombre = data[1];
        var apellido = data[2];
     
        var option = confirm("¿Desea Modificar el registro?");
        if (option == true) {
                    $("#myModalEdit").modal({backdrop: 'static', keyboard: false});
                     $("#inputEmail").val(email);
                     $("#inputNombre").val(nombre);
                     $("#inputApellido").val(apellido);
                     
                     
            } else {
            alert("Cancelado");
        }
        
        
         });
         
              
        $('#TABLEUSERCV tbody').on('click', '#deleteCuenta', function () {

        var data = tableUser.row($(this).parents('tr')).data(); 
        var paymentMethod = data[8];
     
        var option = confirm("¿Desea dar de baja al usuario?");
        if (option == true) {
            
              $.post(
                        "../GetServiceCancelUserHubClaro",
                        {   
                            msisdn: msisdn,
                            paymentMethod: paymentMethod
                        },
                function (json) {  
                clearBar();
                alert(json.message);              
                });

                     
                     
            } else {
            alert("Cancelado");
        }
        
        
         });
         
         
        $('#TABLEADDONS tbody').on('click', '#selectAddon', function () {

        var data = tableAddons.row($(this).parents('tr')).data();
        var dataUser = tableUser.column( 4 ).data();
        var idAccount=dataUser[0];
        
        var keyword = data[2];
        var amcoId = data[3];
        var state = data[4];
     
        
        if(state==1){
            BootstrapDialog.alert("La suscripción que solicita ya es existente en el usuario, o esta en proceso de activación");        
        }else{
     
        var phone = msisdn;
        var option = confirm("¿Desea aplicar a la elegibilidad de la suscripción seleccionada?");
        if (option == true) {
            
              $.post(
                        "../GetEligibilityAccount",
                        {   
                            idAccount: idAccount,
                            phone: phone,
                            keyword:keyword,
                            amcoId: amcoId
                        },
                function (json) {  
                    var result = json.result;
                    var keyword = json.keyword;  
                    if (keyword === ""){
                        BootstrapDialog.alert("Esta suscripción no puede aplicarse o es inexistente");                  
                    }else{
                        
                            var optionS = confirm("El cliente puede aplicar a la suscripción "+keyword+" "+"¿Desea agregarlo?");
                                if (optionS == true) {
                                    
                                     $.post(
                                            "../GetListSuscriptionsAddons",
                                            {   
                                                phone: phone,                             
                                                amcoId: keyword
                                            },
                                            function (json) {                                              
                                            tableAddons.clear().draw();
                                            tableAddons.ajax.reload();
                                            BootstrapDialog.alert(json.message+"."+"  "+"La suscripción se estará procesando");  
                                        });
                                    
                                    
                                    
                                
                                } else {
                                        alert("Cancelado");
                                        }
                        }

                        
                    
                });

                     
                     
            } else {
            alert("Cancelado");
        }
    }
        
         });
         
        $('#TABLEPAGOSCV tbody').on('click', '#deletePago', function () {

        var data = tablePagos.row($(this).parents('tr')).data();  
        var payment = data[0];
        var phone = msisdn;
        var option = confirm("¿Desea cancelar el metodo de pago seleccionado?");
        if (option == true) {
            
              $.post(
                        "../GetCancelPayment",
                        {   
                            phone: phone,                  
                            payment: payment
                        },
                function (json) {  
                    
                    BootstrapDialog.alert(json.message+".");  
                   
                     tablePagos.clear().draw();
                     tablePagos.ajax.reload();
                   
                     });

                     
                     
            } else {
            alert("Cancelado");
        }
        
        
         });
         
         
        $('#TABLEDISPOSITIVOSCV tbody').on('click', '#deleteDevice', function () {

        var data = tableDispositivos.row($(this).parents('tr')).data();  
        var device = data[0];
        var phone = msisdn;
        var option = confirm("¿Desea quitar el dispositivo seleccionado?");
        if (option == true) {
            
              $.post(
                        "../GetCancelDevice",
                        {   
                            phone: phone,                  
                            device: device
                        },
                function (json) {  
                    BootstrapDialog.alert(json.message+"."); 
                     tableDispositivos.clear().draw();
                     tableDispositivos.ajax.reload();
                   
                     });

                     
                     
            } else {
            alert("Cancelado");
        }
        
        
         });
         
         
        $('#TABLECONSUMOCV tbody').on('click', '#deleteAddon', function () {

        var data = tableConsumo.row($(this).parents('tr')).data();  
        var amcoId = data[8];
        var phone = msisdn;
        var option = confirm("¿Desea cancelar la suscripción seleccionada?");
        if (option == true) {
            
              $.post(
                        "../GetCancelSuscriptionsAddons",
                        {   
                            phone: phone,                  
                            amcoId: amcoId
                        },
                function (json) {  
                     BootstrapDialog.alert(json.message+"."); 
                     tableConsumo.clear().draw();
                     tableConsumo.ajax.reload();
                   
                     });

                     
                     
            } else {
            alert("Cancelado");
        }
        
        
         });
         

               
         $( "#addSuscriptionAddon" ).click(function() {              
                $("#myModalEligibility").modal({backdrop: 'static', keyboard: false}); 
                var data = tableUser.column( 8 ).data();
                type=data[0];
                tableAddons.clear().draw();
                tableAddons.ajax.reload();
                
              
         });
        
        $( "#addSuscriptionBundle" ).click(function() {
                
         });
        
        
        $( "#btnCancel" ).click(function() {                
                 $('#myModalEligibility').modal('toggle');
         });
        
        
        


        
        //tablePagos.clear().draw();
        //tablePagos.ajax.reload();
        //tablePagos.columns.adjust().draw();
        progress=0;  
        barProgress(0);
        
        
        
     
            
      


    });
    


   
        
        
    
                    
       


         
         
         
    </script>


  </body>
</html>

