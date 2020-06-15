/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crud;

import com.pojo.Response;
import com.pojo.ResultQueryUserResponse;
import com.webservice.RequestJson;
import configuration.Configuration;
import controller.GetJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExecuteSql;


public class GetListRentHubClaro extends HttpServlet {
    
    
       private Configuration configuration = null;
    
      public GetListRentHubClaro()  {       

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
        String countryId = configuration.getCountry();
        String urlAmcoOperation = configuration.getUrlAmcoOperationClaroVideo();
        
        String msisdn="";
        String email="";
        String json ="";
        String dateInit="";
        String dateFinish="";
        //String country="502";
        String dateInitP="";
        String dateFinishP="";
        

       
        dateInitP = String.valueOf(request.getParameter("dateinit"));
        dateFinishP = String.valueOf(request.getParameter("datefinish"));
        String valor = String.valueOf(request.getParameter("valor")).trim();
        String option = String.valueOf(request.getParameter("option"));
        
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        Date dateInitFormat;
        try {
            dateInitFormat = format.parse(dateInitP);
            Date dateFinishFormat = format.parse(dateFinishP);
            format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
            dateInit = format.format(dateInitFormat);
            dateFinish = format.format(dateFinishFormat);
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        
       
                
      
        
        if (option.contains("0")){
            msisdn=country+valor;
        }else{
            email=valor;
        }

        
        
    
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
          RequestJson requestJson = new RequestJson();
        ResultQueryUserResponse responseQueryUserResponse = new ResultQueryUserResponse();

        
        responseQueryUserResponse = requestJson.queryOttRent("http://"+urlAmcoOperation+"/hubOTT/internal/rest/QueryOtt", countryId, email, msisdn,"consultarrentascliente",dateInit,dateFinish);
        
        String description = responseQueryUserResponse.getResponse().getDescription();
        int code = responseQueryUserResponse.getResponse().getCode();
        ArrayList<String[]> responseList = responseQueryUserResponse.getUserResponse();

    
        GetJson getJson = new GetJson();
    
     
    
    json = getJson.getJsonDataTable(responseList);
    
       if (valor.isEmpty() || code==-1) {
            json = "{\n"
                    + "  \"aaData\": [\n"
                    + " \n"
                    + "    \n"
                    + "  ]\n"
                    + "}";
        }
    
    out.print(json);
        

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
