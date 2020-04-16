
package view.crud;

import clientWebservice.BundleClaroVideo;
import clientWebservice.RepuestaInvokeParams;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class GetDeleteBundle extends HttpServlet {


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
        
        String responseRequest = "Error al dar baja";
        int code = -1;
        
        BundleClaroVideo deleteBundle = new BundleClaroVideo();
        RepuestaInvokeParams responseHubDelete = new RepuestaInvokeParams();
        String msisdn = String.valueOf(request.getParameter("msisdn"));
        responseHubDelete =  deleteBundle.accountBundleStateUpdate(msisdn, "B");
        responseRequest = responseHubDelete.getDescription();
        code = responseHubDelete.getStatus();
        
        
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
    }

}
