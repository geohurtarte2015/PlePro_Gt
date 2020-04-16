/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crud;

import com.pojo.ResultQueryUserResponse;
import com.webservice.RequestJson;
import controller.GetJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class GetListDataUserHubClaro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String dateInitP="";
        String dateFinishP="";
        String dateInit="";
        String dateFinish="";        
        
      
        
       
        dateInitP = String.valueOf(request.getParameter("dateinit"));
        dateFinishP = String.valueOf(request.getParameter("datefinish"));
        String valor = String.valueOf(request.getParameter("valor"));
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
            Logger.getLogger(GetListSubscriberUserHubClaro.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       
        
        
                
      
        
        if (option.contains("0")){
            msisdn=valor;
        }else{
            email=valor;
        }

        
        
    
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
          RequestJson requestJson = new RequestJson();
        ResultQueryUserResponse responseQueryUserResponse = new ResultQueryUserResponse();

        
        responseQueryUserResponse = requestJson.queryOttUser("http://172.16.204.189:30100/hubOTT/internal/rest/QueryUserOtt", "GT", email, msisdn,"consultardatoscliente",dateInit,dateFinish);
        
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
    }// </editor-fold>

}
