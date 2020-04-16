
package view.crud;

import com.webservice.RequestJson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class GetUpdateUser extends HttpServlet {


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
        
        String typeString = String.valueOf(request.getParameter("type"));
        String msisdn = String.valueOf(request.getParameter("msisdn"));
        String url="http://172.16.204.189:30100/hubOTT/internal/rest/UpdateUserOtt";
        String countryId = "GT";
        String comando = "modificaremail";
        String responseRequest = "Error update";
        
     
        
        
        int type = Integer.parseInt(typeString);
        RequestJson requestJson = new RequestJson();
        
        
        switch(type){
        
            case 1:
                String email = String.valueOf(request.getParameter("email"));
                responseRequest=requestJson.updateOttEmail(url, countryId, email, msisdn, comando);
                break;
            case 2:
                String name = String.valueOf(request.getParameter("name"));
                String lastName = String.valueOf(request.getParameter("lastName"));
                responseRequest=requestJson.updateOttName(url, countryId, name, lastName, msisdn, comando);
                break;
            case 3:
                String password = String.valueOf(request.getParameter("password"));
                responseRequest=requestJson.updateOttPassword(url, countryId, password, msisdn, comando);
                break;
        }
        
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
