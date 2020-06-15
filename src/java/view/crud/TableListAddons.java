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




public class TableListAddons
  extends HttpServlet
{
 private Configuration configuration = null;
  public TableListAddons() {}
  
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
    
    String phone = String.valueOf(request.getParameter("msisdn"));
    String sentence1 = String.valueOf(request.getParameter("tableParameter1"));
    String sentence2 = String.valueOf(request.getParameter("tableParameter2"));
    configuration = new Configuration();
    
    String msisdn = configuration.getPrefixCountry()+phone;
    String sentence = sentence1+msisdn+sentence2;
     
    
     processRequest(request, response);
    
    String poolOffLineTrx = configuration.getPoolOffLineTrx();
    
    
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    
    ExecuteSql executeSql = new ExecuteSql(poolOffLineTrx);
    
    List<String[]> listPacksMain = executeSql.selectSql(sentence);

    
    GetJson getJson = new GetJson();
    
    String json = getJson.getJsonDataTable(listPacksMain);
    out.print(json);
  }
  

  public String getServletInfo()
  {
    return "Short description";
  }
}