

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
                          <li><a href="cambioCuenta.jsp">Cuentas</a></li> 
                          <li><a href="consultaReportes.jsp">Reportes</a></li>                
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
                                              <div class='input-group date' id='fechainicioDato'>                                            
                                                  <input type='text' id="fechainicioDatotxt" class="form-control" />
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
                                                  <input id="fechafinalDatotxt" type='text' class="form-control" />
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
                                            <input type="radio"  name="optradio" value="0">Telefono
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
                                            <input class="form-control" name="valor" id="valor" placeholder="valor" required="">
                                        </div>
                                    </div>   
                                  </div>
                                 
                             <div class="row"> 
                                <div class="col-sm-4">
                                    <div class="form-group">
                                       <button type="submit" class="btn btn-primary">Buscar</button>
                                       <button type="button" name="btnClear" id = "btnClear"  class="btn btn-primary">Limpiar</button>
                                    </div>
                                </div>
                               
                             </div>
                            </form>

                            <div id="message">
                                <div class="progress">
                                    <div id="progressId" class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
                              
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
                                                          <th>Editar</th>  
                                                          <th>Alta</th> 
                                                          <th>Baja</th> 
                                                     
                                                      </tr>
                                                  </thead>
                                                  <tfoot>
                                                      <tr>
                                                          <th>Email</th>                                                      
                                                          <th>Nombre</th>
                                                          <th>Apellido</th>
                                                          <th>Id. Usuario</th>    
                                                          <th>Medio de Pago</th>          
                                                          <th>No.Cuenta</th> 
                                                          <th>Editar</th> 
                                                          <th>Alta</th> 
                                                          <th>Baja</th> 
                                                      </tr>
                                                  </tfoot>
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
                                  
                              <div class="panel panel-default">    
                              
                              </div>       
                                                                    
                                  <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">

                                              <table id="TABLECONSUMOCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>DESCRIPCION</th>
                                                          <th>IP</th>
                                                          <th>FECHA_ALTA</th>
                                                          <th>FECHA_EXPIRACION</th>
                                                          <th>FECHA_CANCELACION</th>
                                                          <th>PRECIO</th>    
                                                          <th>ACTIVO</th>          
                                                          <th>MONEDA</th>   
                                                      </tr>
                                                  </thead>
                                                  <tfoot>
                                                      <tr>
                                                          <th>DESCRIPCION</th>
                                                          <th>IP</th>
                                                          <th>FECHA_ALTA</th>
                                                          <th>FECHA_EXPIRACION</th>
                                                          <th>FECHA_CANCELACION</th>
                                                          <th>PRECIO</th>    
                                                          <th>ACTIVO</th>          
                                                          <th>MONEDA</th>   
                                                      </tr>
                                                  </tfoot>
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
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                                      Alquileres del Usuario</a>
                              </h4>
                          </div>
                          <div id="collapse3" class="panel-collapse collapse">
                              
                              
                              <div class="panel-body">
                                           <div class="panel-body">
                      
                             </div>  
                                  
                                    <div class="col-lg-12">
                                      <div class="panel-body">
                                          <div class="table-responsive">
                                              <table id="TABLEALQUILERCV" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                  <thead>
                                                      <tr>
                                                          <th>Titulo</th>
                                                          <th>Ip</th>
                                                          <th>Tiempo de Visualización</th>
                                                          <th>Tiempo Max. de Visualización</th>
                                                          <th>Fecha de Alta</th>
                                                          <th>Fecha Expiración</th>    
                                                          <th>Precio</th>          
                                                          <th>Medio de Pago</th>   
                                                          <th>Acciones</th>   
                                                      </tr>
                                                  </thead>
                                                  <tfoot>
                                                      <tr>
                                                          <th>Titulo</th>
                                                          <th>Ip</th>
                                                          <th>Tiempo de Visualización</th>
                                                          <th>Tiempo Max. de Visualización</th>
                                                          <th>Fecha de Alta</th>
                                                          <th>Fecha Expiración</th>    
                                                          <th>Precio</th>          
                                                          <th>Medio de Pago</th>   
                                                          <th>Acciones</th>    
                                                      </tr>
                                                  </tfoot>
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
                                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">
                                      Dispositivos del Usuario</a>
                              </h4>
                          </div>
                          <div id="collapse4" class="panel-collapse collapse">
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
                                                          <th>Acciones</th>                                                    
                                                      </tr>
                                                  </thead>
                                                  <tfoot>
                                                      <tr>
                                                          <th>Id Dispositivo</th>
                                                          <th>Tipo de Dispositivo</th>
                                                          <th>Nombre de Dispositivo</th>
                                                          <th>Fecha Activación</th>
                                                          <th>Acciones</th>     
                                                      </tr>
                                                  </tfoot>
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
            

        
        
        <!-- Modal -->
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
                                    <button type="submit" class="btn btn-primary mb-2">Confirmar</button>
                                </div>
                            </div>
            
                        </form>
                        </div>
                        <div class="well well-sm">
                            <form method="post" id="form_serviceUpdatePassword">
                                <div class="form-group row">
                                    <label for="inputPassword" class="col-sm-2 col-form-label">Renovación Password</label>  
                                     <div class="col-sm-10">
                                        <button type="submit" class="btn btn-primary mb-2">Confirmar</button>
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
        <!-- /page content -->

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

    <!-- Custom Theme Scripts -->
    <script src="../plantilla/build/js/custom.min.js"></script>
  

    
     <script type="text/javascript">
      var id;
      var rol;
      var progress=0;
        
      var dateinit="";  
      var datefinish="";
      var msisdn="";
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
        
        function barProgress(val){
                 progress=progress+val;
                 document.getElementById("progressId").style.width = progress+"%";
                 $("#progressId").text(progress+"%");
        }
        
   
            
        var tableConsumo= $('#TABLECONSUMOCV').DataTable( {           
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
                                    {"title": "DESCRIPCION"},
                                    {"title": "IP"},
                                    {"title": "FECHA_ALTA"},
                                    {"title": "FECHA_EXPIRACION"},
                                    {"title": "FECHA_CANCELACION"},
                                    {"title": "PRECIO"},
                                    {"title": "ACTIVO"},
                                    {"title": "MONEDA"}   

                            ]
         });    
        
        var tableDispositivos= $('#TABLEDISPOSITIVOSCV').DataTable( {
                            "ajax" : {
                            "url": "../GetListDeviceHubClaro",
                            "type": "POST",
                            "data" : function(d){                            
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
                                    {"title": "Fecha Activación"},
                                    {"title": "Acciones"}     
                            ]
                    });
                    
        var tableUser= $('#TABLEUSERCV').DataTable( {    
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
                                    {"title": "Medio de Pago"}, 
                                    {"title": "No.Cuenta"}
                            ],
                                    "columnDefs": [
                                        {
                                            "targets": 6,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='updateCuenta' data-toggle='tooltip' data-placement='top' title='Editar datos'>" +
                                                    "<img  src='../img/pencil.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        },
                                        {
                                            "targets": 7,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='addCuenta' data-toggle='tooltip' data-placement='top' title='Altas'>" +
                                                    "<img  src='../img/add.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        },
                                        {
                                            "targets": 8,
                                            "data": null,
                                            "defaultContent": "<center><a href='#' id='deleteCuenta' data-toggle='tooltip' data-placement='top' title='Bajas'>" +
                                                    "<img  src='../img/remove.png' width='16' height='16'  border='0' />" +
                                                    "</a></center>"
                                        }
                                    ]
                    });
                    
        var tableAlquiler= $('#TABLEALQUILERCV').DataTable( {
                            "ajax" : {
                            "url": "../GetListRentHubClaro",
                            "type": "POST",
                            "data" : function(d){                            
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
                                    {"title": "Titulo"},
                                    {"title": "Ip"},
                                    {"title": "Tiempo de Visualización"},
                                    {"title": "Tiempo Max. de Visualización"},
                                    {"title": "Fecha de Alta"},     
                                    {"title": "Fecha Expiración"}, 
                                    {"title": "Precio"}, 
                                    {"title": "Medio de Pago"}, 
                                    {"title": "Acciones"}
                            ]
                    });
              
            
        $("#form_serviceGetSubscription").submit(function(event){
            
             
                    event.preventDefault(); //prevent default action 
                   
                    tableUser.clear().draw();
                    tableDispositivos.clear().draw();
                    tableAlquiler.clear().draw();
                    tableConsumo.clear().draw();
                
                    progress=0;  
                    barProgress(0);
              
                    dateinit=$("#fechainicioDatotxt").val();
                    datefinish=$("#fechafinalDatotxt").val();
                    opcion =$("input[name='optradio']:checked").val();
                    valor=$("#valor").val();    
                    msisdn=valor;
                     $('#message').show();                 
                    
                   
                    tableConsumo.ajax.reload();
                    tableDispositivos.ajax.reload();
                    tableAlquiler.ajax.reload();
                    tableUser.ajax.reload();
                    barProgress(20); 
               
           
                 
            });
            
        $("#form_serviceUpdateEmail").submit(function(event){
                event.preventDefault(); //prevent default action 
                
                var type = "1";
                var auditory="Update Usuario Claro Video";               
                var name = $("#inputNombre").val();
                var lastName = $("#inputApellido").val();                
                var email = $("#inputEmail").val();
       
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
                alert(json.message); 
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
                  alert(json.message); 
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
                alert(json.message);              
                });

        });
                    
        $("#btnClear").click(function(){
            clearBar();
        });
        
        function clearBar(){
            $("#valor").val(""); 
            tableConsumo.clear().draw();
            tableUser.clear().draw();
            tableDispositivos.clear().draw();
            tableAlquiler.clear().draw(); 
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
        var email = data[0];
        var nombre = data[1];
        var apellido = data[2];
     
        var option = confirm("¿Desea dar de baja al usuario?");
        if (option == true) {
            
              $.post(
                        "../GetDeleteBundle",
                        {   
                            msisdn: msisdn
                        },
                function (json) {  
                alert(json.message);              
                });

                     
                     
            } else {
            alert("Cancelado");
        }
        
        
         });
        
        
        
        
        


        

    
         progress=0;  
        barProgress(0);


    });
            

   
        
        
    
                    
       


         
         
         
    </script>


  </body>
</html>

