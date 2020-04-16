/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crud;

import com.pojo.Response;
import com.pojo.ResultQueryUserResponse;
import com.webservice.RequestJson;
import controller.GetJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExecuteSql;


public class GetListRentHubClaro extends HttpServlet {


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
        
        String msisdn="";
        String email="";
        String json ="";
        String dateInit="";
        String dateFinish="";
        
        dateInit = "2020-01-01T00:00:00Z";    
        dateFinish = "2020-01-28T23:59:59Z";
        String valor = String.valueOf(request.getParameter("valor"));
        String option = String.valueOf(request.getParameter("option"));
        
        
                
      
        
        if (option.contains("0")){
            msisdn=valor;
        }else{
            email=valor;
        }

        
        
    
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
          RequestJson requestJson = new RequestJson();
        ResultQueryUserResponse responseQueryUserResponse = new ResultQueryUserResponse();

        
        responseQueryUserResponse = requestJson.queryOttRent("http://172.16.204.189:30100/hubOTT/internal/rest/QueryOtt", "GT", email, msisdn,"consultarrentascliente",dateInit,dateFinish);
        
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
