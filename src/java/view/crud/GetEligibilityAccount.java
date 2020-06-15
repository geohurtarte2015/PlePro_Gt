/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crud;

import clientWebservice.RepuestaInvokeParams;
import clientWebservice.RepuestaInvokeParams.Parameters;
import clientWebservice.RepuestaInvokeParams.Parameters.Entry;
import clientWebservice.ServiceSuscriptions;
import configuration.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class GetEligibilityAccount extends HttpServlet {
    
    
      private Configuration configuration = null;
    
      public GetEligibilityAccount()  {       

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
        
        String responseRequest = "error";
        String keyword = String.valueOf(request.getParameter("keyword"));
        String phone = String.valueOf(request.getParameter("phone"));
        String amcoId = String.valueOf(request.getParameter("amcoId"));
        String idAccount = String.valueOf(request.getParameter("idAccount"));
        ServiceSuscriptions serviceSuscriptions = new ServiceSuscriptions();
        //String country = "502";
       String resultResponse="";
       String keywordResponse="";
       String IdAnmco="";
       
       
        
       RepuestaInvokeParams responseInvoke = serviceSuscriptions.eligibilityAccount(idAccount, keyword, country+phone.trim(), amcoId);
 
       if(responseInvoke.getParameters()!=null){
      
       List<Entry> values = responseInvoke.getParameters().getEntry();
       
       int valSize =  values.size();
       resultResponse="";
       keywordResponse="";
       IdAnmco="";
       
       if(valSize>=2){
       resultResponse = values.get(0).getValue();       
            if(values.get(1).getValue()!=null){
                   keywordResponse = values.get(1).getValue().trim();
            }
       responseRequest="ok";       
       }
       }else{
           responseRequest = responseInvoke.getDescription();
       
       };
       int status = -1;
       status = responseInvoke.getStatus();
        
         
        JSONObject json = new JSONObject();
        json.put("status", String.valueOf(status));
        json.put("message", responseRequest);
        json.put("result", resultResponse);
        json.put("keyword", keywordResponse);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(json.toString());
        
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
