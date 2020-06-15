
package view.crud;

import com.webservice.RequestJson;
import configuration.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConnectionOds;
import org.json.JSONObject;


public class GetCancelDevice extends HttpServlet {
    

  private Configuration configuration = null;
  
  
  public GetCancelDevice()
  {       

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
        
        String urlAmcoOperation=configuration.getUrlAmcoOperationClaroVideo();
        String country=configuration.getPrefixCountry();
        String countryId = configuration.getCountry();
        
        String device = String.valueOf(request.getParameter("device"));
        String msisdn = String.valueOf(request.getParameter("phone"));
     
        //String country="502";
       
        
        String url="http://"+urlAmcoOperation+"/hubOTT/internal/rest/UpdateUserOtt";
        //String countryId = "GT";
        String comando = "desvinculardispositivo";
        String responseRequest = "Error al desvincular";
        
   
        RequestJson requestJson = new RequestJson();
        
     
       responseRequest=requestJson.cancelOttDevice(url, countryId, device, country+msisdn.trim(), comando);
            
         
 
        
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("message", responseRequest);
        json.put("type", 0);
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
