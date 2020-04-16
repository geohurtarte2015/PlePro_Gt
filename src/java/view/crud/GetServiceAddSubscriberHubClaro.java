/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crud;

import clientWebservice.AddPackResponse;
import clientWebservice.AddSubscriberHubClaro;
import clientWebservice.TbHUBSUBSCRIBER;
import com.pojo.SprLine;
import com.pojo.SprLineVirtual;
import com.pojo.SprMobile;
import com.pojo.UserClaroVideo;
import com.webservice.RequestJson;
//import clientWebservice.RepuestaInvokeParams;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import pojo.CodeErrorWebservice;

/**
 *
 * @author LENOVO
 */
public class GetServiceAddSubscriberHubClaro extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TbHUBSUBSCRIBER dataUser = null;
        String phone = String.valueOf(request.getParameter("msisdn"));
        String email = String.valueOf(request.getParameter("email"));
        String name = String.valueOf(request.getParameter("name"));
        String lastName = String.valueOf(request.getParameter("lastName"));
        String lastMotherName = String.valueOf(request.getParameter("lastMotherName"));
        String channel = String.valueOf(request.getParameter("OptionChannel"));
        String codeArea = "502";
        String productId = String.valueOf(request.getParameter("OptionProduct"));
        String typeBusiness = String.valueOf(request.getParameter("OptionBusiness"));
        String employeeId = "CVUSER2020";
        String responseMessage="";
        String messageResponse="Error en alta de Usuario";
        String token="";
        String msisdn = codeArea+phone;
        SprLine sprLine = new SprLine();

        SprMobile sprMobile = new SprMobile();
        RequestJson requestJson = new RequestJson();
        
       
          

            UserClaroVideo user = new UserClaroVideo();

    
            if (Integer.parseInt(typeBusiness) == 2) {
                sprLine = requestJson.lineSprResponse("http://172.16.204.215:10001/spr/rest/resource/v1/cache/profile/pisa-" + phone + "/default/default/show",msisdn);
                
       
                user.setMsisdn(sprLine.getMsisdn());                
                user.setCodeResponse(sprLine.getCodeResult());
                user.setDescriptionResponse(sprLine.getDescriptionResult());
                user.setVirtual(sprLine.getVirtual());
                user.setPaymentMethod(sprLine.getPaymentMethodInd());
             
            } else {
                sprMobile = requestJson.mobileSprResponse("http://172.16.204.215:10001/spr/rest/resource/v1/cache/profile/" + msisdn + "/mc/default/show",msisdn);
               
                user.setCodeResponse(sprMobile.getCodeResult());
                user.setDescriptionResponse(sprMobile.getDescriptionResult());
                user.setPaymentMethod(sprMobile.getPaymentMethodInd());
                user.setMsisdn(sprMobile.getMsisdn());
                user.setVirtual("");
            }

            if (Integer.parseInt(user.getCodeResponse()) != 0) {
                responseMessage = "Error en consulta del perfil del numero del usuario";
            }

            if (Integer.parseInt(user.getCodeResponse()) == 0) {
                
                
                AddSubscriberHubClaro addSubscriberHubClaro = new AddSubscriberHubClaro();
                dataUser = addSubscriberHubClaro.listAccountSuscriber("", "", user.getMsisdn());
                
                String state="-1";                
                if(dataUser.getMSISDN()!=null){
                     state = dataUser.getState();
                }               
                
                state="2";
                
                if(Integer.parseInt(state)==-1 || (Integer.parseInt(state)!=1 && Integer.parseInt(state)!=6)){
                
                        user.setChannel(channel);
                        user.setName(name);
                        user.setLastName(lastName);
                        user.setLastMother(lastMotherName);         
                        user.setEmail(email);
                        user.setEmployeeId(employeeId);               
                        user.setTmcode("");
                        user.setCustomerId("");
                        user.setCodId("");      

                       messageResponse = requestJson.AddUser("http://172.16.68.235:8312/hubOTT/internal/rest/createUserOTT", user);

                }else{
                    int val =Integer.parseInt(state);
                    
                    switch  (val){
                    
                        case 1:
                            messageResponse ="Usuario claro video ya estaba en alta";
                            break;   
                        case 6:
                              messageResponse ="Usuario claro video existente pero con error en bundle";
                            break;
                    
                    }
                    
                    
                
                }
                
                
               
                
                
                
                
        
                responseMessage = messageResponse;
            }

       

          
                  
//        clientWebservice.GuiParameter parameters = new clientWebservice.GuiParameter();
//        parameters.setName(name);
//        parameters.setLastName(lastName);
//        parameters.setChannel(Integer.parseInt(channel));
//        parameters.setCodeArea(codeArea);
//        parameters.setEmail(email);
//        parameters.setProductId(productId);


      
    
        
         //responseParams = addSubscriberHubClaro.guiSuscriberVideo(phone, parameters);
        
   
    
        
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
