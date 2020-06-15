
package view.crud;

import com.webservice.RequestJson;
import configuration.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class GetCancelPayment extends HttpServlet {
    
    
  private Configuration configuration = null;
  
  
  public GetCancelPayment()  {       

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
        
        String ipAmcoOperation=configuration.getUrlAmcoOperationClaroVideo();
        String country = configuration.getPrefixCountry();
        String countryId = configuration.getCountry();
        
        
        String payment = String.valueOf(request.getParameter("payment"));
        String msisdn = String.valueOf(request.getParameter("phone"));
     
       
        
        String url="http://"+ipAmcoOperation+"/hubOTT/internal/rest/UpdateUserOtt";
        //String countryId = "GT";
        String comando = "quitarmediodepago";
        String responseRequest = "Error al quitar medio de pago";
        
   
        RequestJson requestJson = new RequestJson();
        
     
       responseRequest=requestJson.cancelOttPaymentMethod(url, countryId, payment, country+msisdn.trim(), comando);
            
         
 
        
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
