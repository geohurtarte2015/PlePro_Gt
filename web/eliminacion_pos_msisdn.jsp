
<!DOCTYPE html>

<%  
     String nombre = (String) session.getAttribute("nombre");    
        String apellido = (String) session.getAttribute("apellido");
        String rol = (String) session.getAttribute("rol");
            
            String display1 = "display:block";
            String display2 = "display:block";
            String display3 = "display:block";
            String display4 = "display:block";
            String display5 = "display:block";
            String display6 = "display:block";
            String display7 = "display:block";
            String displaySegmentacion = "display:block";
              String displayClaroVideo = "display:block";
            
            int selectRol = Integer.parseInt(rol);
            
            switch (selectRol){
             
                case 2:   
                      displayClaroVideo = "display:none";
                        displaySegmentacion = "display:none";
                        display2 = "display:none";
                        display3 = "display:none";
                        display4 = "display:none";
                        display5 = "display:none";
                        display6 = "display:none";
                    break;
                case 3:
                      displayClaroVideo = "display:none";
                        display1 = "display:none"; 
                        display5 = "display:none"; 
                        display6 = "display:none";
                        response.sendRedirect("principal.jsp");
                    break;      
                 case 4:
                       displayClaroVideo = "display:none";
                        display5 = "display:none";               
                      
                        break; 
                 case 5:
                       displayClaroVideo = "display:none";
                        display1 = "display:none"; 
                        display2 = "display:none";
                        display3 = "display:none";
                        display4 = "display:none";
                        display6 = "display:none";
                        response.sendRedirect("principal.jsp");
                        break; 
                 case 6:
                       displayClaroVideo = "display:none";
                        display1 = "display:none"; 
                        display2 = "display:none";
                        display3 = "display:none";
                        display4 = "display:none";
                        display5 = "display:none";
                        response.sendRedirect("principal.jsp");
                        break;        
                  case 7:  
                        displayClaroVideo = "display:none";
                        displaySegmentacion = "display:none";
                        display2 = "display:none";
                        display3 = "display:none";
                        display4 = "display:none";
                        display5 = "display:none";
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

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	  
    <title>PLE CLARO </title>
    


        <!-- DatePick -->
    <link href="plantilla/bootdate/build/css/bootstrap-datetimepicker.css" rel="stylesheet">

     <!-- Bootstrap -->
    <link href="plantilla/new/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    
    
    <!-- Font Awesome -->
    <link href="plantilla/new/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="plantilla/new/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="plantilla/new/vendors/iCheck/skins/flat/green.css" rel="stylesheet">    
    
    <!-- bootstrap-wysiwyg -->
    <link href="plantilla/new/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
	
    <!-- Select2 -->
    <link href="plantilla/new/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="plantilla/new/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="plantilla/new/vendors/starrr/dist/starrr.css" rel="stylesheet">


    
    <!-- Datatables -->
    <link href="plantilla/new/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/new/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/new/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/new/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/new/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="plantilla/new/build/css/custom.min.css" rel="stylesheet">
    
     <!-- Alert Bootbox -->
    <script src="plantilla/bootbox/bootbox.min.js"></script> 

  </head>

  <body class="nav-md"> 
         
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="principal.jsp" class="site_title"> <span>CLARO</span></a>
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
                          <li><a href="configuracion.jsp">Configuracion</a></li>  
                          <li><a href="aprovisionarpacks.jsp">Aprovisionar</a></li> 
                      </ul>
                  </li>
                  <li style="<%=display6%>"><a><i class="fa fa-home"></i> Consultas <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="aprovisionamiento.jsp">Consulta aprovisionamientos</a></li>  
                      <li><a href="notification.jsp">Consulta notificaciones</a></li>  
                     <!--  <li><a href="modificacion.jsp">Modificaciones</a></li>   -->
                    </ul>
                  </li>
                  <li style="<%=displaySegmentacion%>"><a><i class="fa fa-mobile"></i>Focalizada POS <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">                         
                          <li style="<%=display3%>"><a href="creacion.jsp">Carga de clientes POS</a></li> 
                          <li style="<%=display4%>"><a href="eliminar.jsp">Eliminar clientes POS</a></li>   
                          <li style="<%=display7%>"><a href="mantenimiento.jsp">Mantenimiento clientes POS</a></li>
                          <li><a href="eliminacion901.jsp">Clientes 901</a></li>
                      </ul>
                  </li>
                  <li style="<%=display5%>"><a><i class="fa fa-user-plus"></i> Administración <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="userManagement.jsp">Usuarios y Perfiles</a></li>                     
                      </ul>
                  </li>
                   <li style="<%=displayClaroVideo%>"><a><i class="fa fa-play-circle"></i>Gestión Claro Video <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="ClaroVideo/altasUsuarioHubClaro.jsp">Alta de usuario</a></li> 
                          <li><a href="ClaroVideo/consultaConsumosHubClaro.jsp">Consulta consumos</a></li> 
                          <li><a href="ClaroVideo/cambioCuenta.jsp">Cuentas</a></li> 
                          <li><a href="ClaroVideo/consultaReportes.jsp">Reportes</a></li>                
                      </ul>
                    </li>
                </ul>
              </div>
            </div>                  
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
     
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
         <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle" >
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Opciones
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">                    
                    <li><a href="EndSesion"><i class="fa fa-sign-out pull-right"></i> Salir</a></li>
                  </ul>
                </li>
         
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
    
            <div class="clearfix"></div>
            
       
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-bars"></i> Eliminación MSISDN POS </h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
            
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                        


                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                      <ul id="myTab" class="nav nav-tabs nav-justified" role="tablist">
                        <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Busqueda</a>
                        </li>
                        <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Carga Masiva</a>
                        </li>

                     
                      </ul>
                      <div id="myTabContent" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                           <br>       
                           <br>             
                            <%-- page cuenta --%>
                            <div class="row">

                                <div class="panel panel-primary">
                                    <div class="panel-heading">Busqueda para eliminación</div>
                                    <div class="panel-body">
                                        <form>
                                            
                                            <div class="col-lg-2">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" placeholder="Msisdn">
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-default" type="button">Busqueda</button>
                                                    </span>
                                                </div><!-- /input-group -->
                                            </div><!-- /.col-lg-6 -->
                                         
                                        </form>
                                    </div>
                                </div>
                                <div class="panel panel-default class">
                                        <div class="panel-heading">Resultado</div>
                                        <div class="panel-body">
                                            
                                            <div class="col-lg-12">
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <table id="TABLESEARCH" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                            <thead>
                                                                <tr>
                                                                    <th>Id</th>  
                                                                    <th>Phone</th>
                                                                    <th>Pos</th>    
                                                                    <th>Date</th>          
                                                                    <th>Pack</th>  
                                                                    <th>Delete</th> 
                                                 
                                                                </tr>
                                                            </thead>
                                                            <tfoot>
                                                                <tr>
                                                                    <th>Id</th>  
                                                                    <th>Phone</th>
                                                                    <th>Pos</th>    
                                                                    <th>Date</th>          
                                                                    <th>Pack</th>           
                                                                    <th>Delete</th>                                                    
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
                            
                            
                        <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                           <br>       
                           <br>
                        
                            
                           <%-- page paquete--%>
                            <div class="row">
                                
                                <div class="panel panel-primary">
                                        <div class="panel-heading">Carga Masiva</div>
                                        <div class="panel-body">
                                            <div class="col-sm-4">                                
                                                <div class="form-group">
                                                    <label for="file" id="labelFileList" name="labelFileList"></label>                                     
                                                    <input type="file" class="form-control-file" name="fileList" id="fileList">
                                                    
                                                  
                                                </div>   
                                                  <div class="form-group">
                                                    
                                                    <button type="button" class="btn btn-danger" data-loading-text="Loading ..."  id="btnSubmitList"> Cargar </button>
                                                    <!-- <input type="submit" value="Submit" value="uploadList" id="btnSubmitList">  -->
                                                    </div>
                                            </div>                                                 
                                        </div>
                                </div>
                                <div class="panel panel-default class">
                                        <div class="panel-heading">Resultado</div>
                                        <div class="panel-body">
                               
                                                
                                               <div class="col-lg-12">
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <table id="TABLERESULT" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">  
                                                            <thead>
                                                                <tr>
                                                                    <th>Id</th>  
                                                                    <th>Date</th>
                                                                    <th>Phone</th>    
                                                                    <th>State</th>  
                                                                </tr>
                                                            </thead>
                                                            <tfoot>
                                                                <tr>
                                                                     <th>Id</th>  
                                                                    <th>Date</th>
                                                                    <th>Phone</th>    
                                                                    <th>State</th>                                                      
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
           <!-- modals -->  
           <div id="cuentamd">

           </div>

       
        
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>


    <!-- jQuery -->
    <script src="plantilla/new/vendors/jquery/dist/jquery.min.js"></script>

    
    <!-- Bootstrap -->
   <script src="plantilla/new/vendors/bootstrap/dist/js/bootstrap.min.js"></script> 

   
       
   
    
    <!-- bootstrap-daterangepicker -->
    <script src="plantilla/vendors/moment/min/moment.min.js"></script>
    <script src="plantilla/bootdate/src/js/bootstrap-datetimepicker.js"></script>  
    
    
    <!-- FastClick -->
    <script src="plantilla/new/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="plantilla/new/vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="plantilla/new/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="plantilla/new/vendors/iCheck/icheck.min.js"></script>
    
    <!-- bootstrap-wysiwyg -->
    <script src="plantilla/new/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="plantilla/new/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="plantilla/new/vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="plantilla/new/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="plantilla/new/vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="plantilla/new/vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="plantilla/new/vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="plantilla/new/vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="plantilla/new/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="plantilla/new/vendors/starrr/dist/starrr.js"></script>
    <!-- Datatables -->
    <script src="plantilla/new/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="plantilla/new/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="plantilla/new/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="plantilla/new/vendors/jszip/dist/jszip.min.js"></script>
    <script src="plantilla/new/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="plantilla/new/vendors/pdfmake/build/vfs_fonts.js"></script>
    
     <!-- Custom Theme Scripts -->
    <script src="plantilla/new/build/js/custom.min.js"></script>    
    
        <!-- Alert Bootbox -->
    <script src="plantilla/bootbox/bootbox.min.js"></script> 

    
        
        
       <!-- Functions Scripts -->  
    <script type="text/javascript" src="FunctionsJs/jsModals.js"></script>   
    
         <script type="text/javascript">
            
            $(document).ready(function(){    
             
            var tableResult= $('#TABLERESULT').DataTable( {
                            "ajax" : {
                            "url": "TableListPos",
                           "type": "POST",
                            "data" : function(d){                            
                                              d.id = 1;
                                              d.tableParameter = "select * from tb_pos_deleted";
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
                                    {"title": "Id"},
                                    {"title": "Date"},
                                    {"title": "Phone"},
                                    {"title": "State"}
                            ]
                    });

       });
       </script>
    
    
  </body>
</html>



