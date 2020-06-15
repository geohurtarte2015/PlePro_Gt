package view.crud;

import configuration.Configuration;
import controller.GetJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExecuteSql;
import org.json.JSONObject;




public class GetMsisdnHubClaro
  extends HttpServlet
{
 private Configuration configuration = null;
  public GetMsisdnHubClaro() {}
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html;charset=UTF-8");
  }
  

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    processRequest(request, response);
  }
  

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    processRequest(request, response);
    
    configuration = new Configuration();
    
   
    String sentence = String.valueOf(request.getParameter("tableParameter"));
     
    String msisdnString="0";
    
    
     processRequest(request, response);
    
    String poolOffLineTrx = configuration.getPoolOffLineTrx();
    
    
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    
    ExecuteSql executeSql = new ExecuteSql(poolOffLineTrx);
    
    List<String[]> listPacksMain = executeSql.selectSql(sentence);
    msisdnString = listPacksMain.get(0)[0];
    
    String msisdn="";
    
    if(msisdnString.length()<9){
    msisdn=msisdnString;
    }else{
    msisdn = msisdnString.substring(3);
    }
    
    
    
    
        JSONObject json = new JSONObject();
        json.put("msisdn", msisdn);    
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
  }
  

  public String getServletInfo()
  {
    return "Short description";
  }
}