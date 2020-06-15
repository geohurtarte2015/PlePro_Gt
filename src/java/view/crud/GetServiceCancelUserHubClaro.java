
package view.crud;

import com.pojo.UserClaroVideo;
import com.webservice.RequestJson;
import configuration.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class GetServiceCancelUserHubClaro extends HttpServlet {
    
      private Configuration configuration = null;
    
      public GetServiceCancelUserHubClaro()  {       

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
        String urlAmcoUser = configuration.getUrlAmcoUserClaroVideo();        
        String responseMessage = "Error al cancelar ususario";
   
               
        String paymentMethod = String.valueOf(request.getParameter("paymentMethod"));
        String msisdn = String.valueOf(request.getParameter("msisdn")).trim();
        //String country="502";
        
        RequestJson requestJson = new RequestJson();
        UserClaroVideo user = new UserClaroVideo();

        
        
        user.setPaymentMethod(paymentMethod);
        user.setMsisdn(country+msisdn);
        
        responseMessage = requestJson.cancelUserClaroVideo("http://"+urlAmcoUser+"/hubOTT/internal/rest/deleteUserOTT", user);
        
        
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("message", responseMessage);
        json.put("type", 0);
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        
        
        
        

        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
