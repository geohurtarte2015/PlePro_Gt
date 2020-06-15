/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crud;

import clientWebservice.ParameterService;
import clientWebservice.RepuestaInvokeParams;
import clientWebservice.RepuestaInvokeParams.Parameters;
import clientWebservice.ServiceSuscriptions;
import configuration.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author LENOVO
 */
public class GetCancelSuscriptionsAddons extends HttpServlet {
    
     private Configuration configuration = null;
    
      public GetCancelSuscriptionsAddons()  {       

        configuration = new Configuration();
         

  }

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String country = configuration.getPrefixCountry();
        
        
        String phone ="";
        String idAmco ="";
        String keyword ="";
        //String country="502";
        
        phone = String.valueOf(request.getParameter("phone"));
        idAmco = String.valueOf(request.getParameter("amcoId"));
        
        ServiceSuscriptions serviceSuscriptions = new ServiceSuscriptions();
        ParameterService parameters = new ParameterService();
        parameters.setPHONE(country+phone.trim());
        parameters.setCUSTOMERID("");
        parameters.setPAYMENTTYPE("GUIWEB");
        parameters.setPRODUCTID(idAmco);
        RepuestaInvokeParams responseParams = serviceSuscriptions.serviceDesactive(parameters);
        String message = "Error al cancelar suscripción";
        String status = String.valueOf(responseParams.getStatus());
        
        int val = -999;
         
        if(status!=null){
            val=Integer.parseInt(status);
        }
        
        if(Integer.parseInt(status)>=0){            
                message="Suscripción Cancelada";         
        }else{
            switch (val) {
                case -111:
                    message = "Servicio No Valido por Situacion Actual";
                    break;
                case -110:
                    message = "Servicio no activo";
                    break;
                case -109:
                    message = "Saldo Insuficiente para Combo";
                    break;
                case -108:
                    message = "No se pudo Realizar el Rollback de Debito";
                    break;
                case -107:
                    message = "Fallo Recarga de Paquete";
                    break;
                case -106:
                    message = "Tipo de Cuenta No definido";
                    break;
                case -105:
                    message = "No se pudo Realizar el Debito Para Esta Operación";
                    break;
                case -104:
                    message = "Saldo Insuficiente Para Este Servicio";
                    break;
                case -103:
                    message = "No se pudo Realizar el Credito Para Esta Operación";
                    break;
                case -102:
                    message = "Tarifa No Registrada";
                    break;
                case -101:
                    message = "Perfil No valido Para Este Servicio";
                    break;
                case -100:
                    message = "Clave/Origen No Existe en el sistema";
                    break;
            }

        }
        
        
        JSONObject json = new JSONObject();
        json.put("status", status);
        json.put("message", message);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(json.toString());
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
