/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice;

import clientWebservice.AddSubscriberHubClaro;
import clientWebservice.TbHUBSUBSCRIBER;
import com.pojo.Response;
import com.pojo.ResultQueryUserResponse;
import com.pojo.SprLine;
import com.pojo.SprMobile;
import com.pojo.UserClaroVideo;
import com.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.ExecuteSql;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author LENOVO
 */
public class RequestJson {
    
    public Response createUser(String url, String msisdn,String countryId,String origin,String name,String lastName, String email, String motherLastName){
        Response response = new Response();
        response.setCode(-1);
        response.setDescription("Error");    
        try {
            GetWebservice getWebservice = new GetWebservice();
            String stringToParse = getWebservice.doPostJson(url, "{\n" +
                    "  \"createUserOttRequest\": { \n" +
                    "    \"msisdn\": \""+msisdn+"\",\n" +
                    "    \"countryId\": \""+countryId+"\",\n" +
                    "    \"origin\": \""+origin+"\",\n" +
                    "    \"name\": \""+name+"\",\n" +
                    "    \"lastName\": \""+lastName+"\",\n" +
                    "    \"email\": \""+email+"\",\n" +
                    "    \"motherLastName\": \""+motherLastName+"\",  \n" +
                    "    }\n" +
                    "}");
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(stringToParse);
            String resultMessage = (String) ((JSONObject) json.get("createUserResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("createUserResponse")).get("resultCode");
            
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            System.out.println(response);

        } catch (ParseException ex) {
            System.out.println("Error response json "+ex);
            return response;
        }
        return response;
        
    }
    
    public Response desactiveUser(String url, String msisdn,String countryId,String origin,String name,String lastName, String email, String motherLastName){
        Response response = new Response();
        response.setCode(-1);
        response.setDescription("Error");    
        TbHUBSUBSCRIBER dataUser = null;
        AddSubscriberHubClaro addSubscriberHubClaro = new AddSubscriberHubClaro();
        dataUser = addSubscriberHubClaro.listAccountSuscriber("", "", msisdn);
        try {
            GetWebservice getWebservice = new GetWebservice();
            String stringToParse = getWebservice.doPostJson(url, "{\n" +
                    "  \"createUserOttRequest\": { \n" +
                    "    \"msisdn\": \""+msisdn+"\",\n" +
                    "    \"countryId\": \""+countryId+"\",\n" +
                    "    \"origin\": \""+origin+"\",\n" +
                    "    \"name\": \""+name+"\",\n" +
                    "    \"lastName\": \""+lastName+"\",\n" +
                    "    \"email\": \""+email+"\",\n" +
                    "    \"motherLastName\": \""+motherLastName+"\",  \n" +
                    "    }\n" +
                    "}");
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(stringToParse);
            String resultMessage = (String) ((JSONObject) json.get("createUserResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("createUserResponse")).get("resultCode");
            
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            System.out.println(response);

        } catch (ParseException ex) {
            System.out.println("Error response json "+ex);
            return response;
        }
        return response;
        
    }
    
    public ResultQueryUserResponse queryOttSubscriptions(String url,String countryId, String email, String msisdn,String comando,String dateInit,String dateFinish ){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
        
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);
               String trnId = Utils.getUUI();
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\",\n"
                    + "		\"trnId\":\""+trnId+"\",\n" 
                    + "		\"email\":\""+email+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){  
                return resultQueryResult;
            }
            
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("queryUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryUserOttResponse")).get("resultCode"); 
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
            JSONObject subscriptionList = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("subscriptionList"));      
         
            if(!subscriptionList.isEmpty()){
            JSONArray subscription = (JSONArray) subscriptionList.get("subscription");
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            //int size = userData.size();
            int sizeSubscriptionList = subscription.size();
           
            
            //String[] arrayUserData = new String[size];
            //arrayUserData[0]= (String) ((JSONObject) userData.get("item")).get("value");
            JSONObject listItem =  (JSONObject) subscription.get(0);
            JSONArray item = (JSONArray) listItem.get("item");
            int sizeItem = item.size();
            
            
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                    
            for(int y=0;y<sizeSubscriptionList;y++){
            String[] arraySubsciptionList = new String[sizeItem];
            
            arraySubsciptionList[0] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(0)).get("value");//descripcion
            arraySubsciptionList[1] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(2)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(5)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(6)).get("value");
            arraySubsciptionList[4] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(7)).get("value");
            arraySubsciptionList[5] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(8)).get("value"); //precio
            arraySubsciptionList[6] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(9)).get("value");
            arraySubsciptionList[7] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(10)).get("value");
            arraySubsciptionList[8] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(11)).get("value");//id product
            
            
            ExecuteSql executeSql = new ExecuteSql();
            
            List<String[]> list = executeSql.selectSql("select distinct cp.description,spr.value/100000 Q from mpm_config_pack cp \n" +
            "inner join mpm_service_pack_rate spr on(cp.id_pack=spr.pack)\n" +
            "where id_tecnomen="+arraySubsciptionList[8]+" and recharge_policy=1");
            
            //cambia la descripcion del paquete de anmco al de Guatemala
            arraySubsciptionList[0]=list.get(0)[0];
            
            
            
            int state = Integer.parseInt(arraySubsciptionList[6].trim());
            
             switch (state) {
                 case 0:
                     arraySubsciptionList[6]="CANCELADO";
                     break;
                 case 1:
                     arraySubsciptionList[6]="ACTIVO";
                     break;
             
             }
            
            listSubscriptionUser.add(arraySubsciptionList);
            }
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);
         
            }
            
               System.out.println(response);
            
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return resultQueryResult;
    }
   
    public ResultQueryUserResponse queryOttUser(String url,String countryId, String email, String msisdn,String comando,String dateInit,String dateFinish ){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
               String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\",\n"
                    + "		\"trnId\":\""+trnId+"\",\n" 
                    + "		\"email\":\""+email+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){
                ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                String[] arraySubsciptionList = new String[1];
                listSubscriptionUser.add(arraySubsciptionList);       
                resultQueryResult.setResponse(response);
                resultQueryResult.setUserResponse(listSubscriptionUser);
                
                
                return resultQueryResult;

            
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("queryUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryUserOttResponse")).get("resultCode"); 
            
            if(resultCode.equals("0")){
            
                 // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
            JSONObject subscription = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData"));      
            
            String status = (String) ((JSONObject) json.get("queryUserOttResponse")).get("statusClient"); 
            String typeClient = (String) ((JSONObject) json.get("queryUserOttResponse")).get("typeClient");
            String customerId = (String) ((JSONObject) json.get("queryUserOttResponse")).get("customerID");
            
            String descriptionStatus = "No definido";
            switch(Integer.parseInt(status)){
                case 1:
                    descriptionStatus="ACTIVO";
                    break;
                case 2:
                    descriptionStatus="BAJA";
                    break;
                case 3:
                    descriptionStatus="SUSPENDIDO";
                    break;
                case 4:
                    descriptionStatus="CANCELADO";
                    break;
                case 5:
                    descriptionStatus="PENDIENTE";
                    break;
                case 6:
                    descriptionStatus="ERROR";
                    break;
           
            }
            
     
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            //int size = userData.size();
            int sizeSubscriptionList = subscription.size();
           
            
            //String[] arrayUserData = new String[size];
            //arrayUserData[0]= (String) ((JSONObject) userData.get("item")).get("value");
            //JSONObject listItem =  (JSONObject) subscription.get(0);
            JSONArray item = (JSONArray) subscription.get("item");
            int sizeItem = item.size();
            
            
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                    
       
            String[] arraySubsciptionList = new String[sizeItem+3];
            
            arraySubsciptionList[0] = (String) ((JSONObject) item.get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject) item.get(1)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject) item.get(2)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject) item.get(3)).get("value");
            arraySubsciptionList[4] = customerId;
            arraySubsciptionList[5] = (String) ((JSONObject) item.get(4)).get("value");
            arraySubsciptionList[6] = (String) ((JSONObject) item.get(5)).get("value");
       
            arraySubsciptionList[7] = descriptionStatus;
            arraySubsciptionList[8] = typeClient;
            
           
            listSubscriptionUser.add(arraySubsciptionList);
            
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);
            
            
            }else{
                
                ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                String[] arraySubsciptionList = new String[1];
                listSubscriptionUser.add(arraySubsciptionList);       
                resultQueryResult.setResponse(response);
                resultQueryResult.setUserResponse(listSubscriptionUser);
                
                return resultQueryResult;
            
            
            }
            
          
            System.out.println(response);
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return resultQueryResult;
    }
    
    public ResultQueryUserResponse queryOttDevice(String url,String countryId, String email, String msisdn,String comando,String dateInit,String dateFinish ){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);
            String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\",\n"
                    + "		\"trnId\":\""+trnId+"\",\n" 
                    + "		\"email\":\""+email+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
       
            if(responseJson.equals("0")){
                return resultQueryResult;
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("queryOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryOttResponse")).get("resultCode"); 
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
           
           if(resultCode.equals("0")){
                 
               JSONObject subscription = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryOttResponse")).get("deviceList"));      
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            //int size = userData.size();
            int sizeSubscriptionList = subscription.size();
           
            
            //String[] arrayUserData = new String[size];
            //arrayUserData[0]= (String) ((JSONObject) userData.get("item")).get("value");
            //JSONObject listItem =  (JSONObject) subscription.get(0);
      
     
            JSONArray item = (JSONArray) subscription.get("device");
            int sizeDevices = item.size();
            
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                    
            for(int y=0;y<sizeDevices;y++){
            JSONArray arrayItem = (JSONArray) ((JSONObject) item.get(y)).get("item");
            int sizeItem = arrayItem.size();                
            String[] arraySubsciptionList = new String[sizeItem];
            
            arraySubsciptionList[0] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(3)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(1)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(2)).get("value");
           
            
            listSubscriptionUser.add(arraySubsciptionList);
            }
            
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);
               
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return resultQueryResult;
    }
    
    public ResultQueryUserResponse queryOttPaymentMethod(String url,String countryId, String email, String msisdn,String comando,String dateInit,String dateFinish ){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);
            String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\",\n"
                    + "		\"trnId\":\""+trnId+"\",\n" 
                    + "		\"email\":\""+email+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
//            responseJson = "{\n" +
//"  \"queryOttResponse\": {\n" +
//"    \"resultCode\": \"0\",\n" +
//"    \"resultMessage\": \"success\",\n" +
//"    \"correlatorId\": \"00000232550e8400e29b41d4a716446655440000\",\n" +
//"    \"paymentMethodList\": {\n" +
//"      \"paymentMethod\": [\n" +
//"        {\n" +
//"          \"id\": \"456654456\",\n" +
//"          \"description\": \"Tarjeta de Credito\"\n" +
//"        }\n" +
//"      ]\n" +
//"    },\n" +
//"    \"countryId\": \"MX\",\n" +
//"    \"serviceName\": \"listarmediosdepago\",\n" +
//"    \"providerId\": \"PA000002325\",\n" +
//"    \"extensionInfo\": [\n" +
//"       {\n" +
//"        \"key\": \"CUSTOMERID\",\n" +
//"        \"value\": \"value1\"\n" +
//"      }\n" +
//"    ]\n" +
//"  }\n" +
//"}";
            
            if(responseJson.equals("0")){
                return resultQueryResult;
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("queryOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryOttResponse")).get("resultCode"); 
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
           
             if(resultCode.equals("0")){
               
               JSONObject subscription = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryOttResponse")).get("paymentMethodList"));      
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            //int size = userData.size();
            int sizeSubscriptionList = subscription.size();
           
            
            //String[] arrayUserData = new String[size];
            //arrayUserData[0]= (String) ((JSONObject) userData.get("item")).get("value");
            //JSONObject listItem =  (JSONObject) subscription.get(0);
      
     
            JSONArray item = (JSONArray) subscription.get("paymentMethod");
            int sizeDevices = item.size();
            
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                    
            for(int y=0;y<sizeDevices;y++){
                
              int valObject =  ((JSONObject) item.get(y)).size();
                
            String[] arraySubsciptionList = new String[valObject];
            
            arraySubsciptionList[0] = (String) ((JSONObject) item.get(0)).get("id").toString();
            arraySubsciptionList[1] = (String) ((JSONObject) item.get(0)).get("description").toString();
           
            
            listSubscriptionUser.add(arraySubsciptionList);
            }
            
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);
            
           
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return resultQueryResult;
    }
    
    public ResultQueryUserResponse queryOttRent(String url,String countryId, String email, String msisdn,String comando,String dateInit,String dateFinish ){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);
           String trnId = Utils.getUUI();
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\",\n"
                    + "		\"trnId\":\""+trnId+"\",\n" 
                    + "		\"email\":\""+email+"\"\n" 
                    + "		}\n"
                    + "}";
            
            
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
//            responseJson = "{\n" +
//"	\"queryOttResponse\": {\n" +
//"		\"resultCode\": \"0\",\n" +
//"		\"resultMessage\": \"success\",\n" +
//"		\"correlatorId\": \"00000232550e8400e29b41d4a716446655440000\",\n" +
//"		\"rentList\": {\n" +
//"			\"rent\": [\n" +
//"				{\n" +
//"					\"item\": [\n" +
//"						{\n" +
//"							\"key\": \"descripcion\",\n" +
//"							\"value\": \"Descripcion\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"ipUsuario\",\n" +
//"							\"value\": \"192.168.0.27\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"ultimaVisualizacion\",\n" +
//"							\"value\": \"2007-11-03T16:18:05Z\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"tiempoMaximoVisualizacion\",\n" +
//"							\"value\": \"16:18:05Z\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"fechaAlta\",\n" +
//"							\"value\": \"2007-11-03T16:18:05Z\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"fechaExpiracion\",\n" +
//"							\"value\": \"2015-11-03T16:18:05Z\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"precio\",\n" +
//"							\"value\": \"450\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"medioPago\",\n" +
//"							\"value\": \"Efectivo\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"idRenta\",\n" +
//"							\"value\": \"24Rent134\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"idRefRenta\",\n" +
//"							\"value\": \"t32er2332\"\n" +
//"						},\n" +
//"						{\n" +
//"							\"key\": \"moneda\",\n" +
//"							\"value\": \"MXN\"\n" +
//"						}\n" +
//"					]\n" +
//"				}\n" +
//"			]\n" +
//"		},\n" +
//"		\"countryId\": \"MX\",\n" +
//"		\"serviceName\": \"consultarrentascliente\",\n" +
//"		\"providerId\": \"PA000002325\",\n" +
//"		\"extensionInfo\": [\n" +
//"			{\n" +
//"				\"key\": \"CUSTOMERID\",\n" +
//"				\"value\": \"exParam255\"\n" +
//"			}\n" +
//"		]\n" +
//"	}\n" +
//"}";
//            
            
            
            
            if(responseJson.equals("0")){ 
                return resultQueryResult;
            }
            
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("queryOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryOttResponse")).get("resultCode"); 
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
           
           
             if(resultCode.equals("0")){

                JSONObject subscription = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryOttResponse")).get("rentList"));

                response.setCode(Integer.parseInt(resultCode));
                response.setDescription(resultMessage);

                JSONArray item = (JSONArray) subscription.get("rent");
                int sizeRents = item.size();

                ArrayList<String[]> listSubscriptionUser = new ArrayList<>();

                for (int y = 0; y < sizeRents; y++) {

                    JSONArray arrayItem = (JSONArray) ((JSONObject) item.get(y)).get("item");
                    int sizeItem = arrayItem.size();
                    String[] arraySubsciptionList = new String[sizeItem];


                    arraySubsciptionList[0] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(0)).get("value");
                    arraySubsciptionList[1] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(2)).get("value");
                    arraySubsciptionList[2] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(3)).get("value");
                    arraySubsciptionList[3] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(4)).get("value");
                    arraySubsciptionList[4] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(5)).get("value");
                    arraySubsciptionList[5] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(6)).get("value");
                    arraySubsciptionList[6] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(7)).get("value");
                    arraySubsciptionList[7] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(8)).get("value");
                    arraySubsciptionList[8] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(10)).get("value");

                    listSubscriptionUser.add(arraySubsciptionList);
                }

                resultQueryResult.setResponse(response);
                resultQueryResult.setUserResponse(listSubscriptionUser);
           
            }
                     System.out.println(response);
            
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return resultQueryResult;
    }
    
    public String updateOttEmail(String url,String countryId,String email, String msisdn,String comando){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);
              String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"updateUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"newEmail\":\""+email+"\",\n"  
                    + "		\"trnId\":\""+trnId+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){
                return resultQueryResult.getResponse().getDescription();
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultCode"); 
           
            if(resultCode.equals("0")){
              
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
       
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>();         
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);            
           
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json "+ex);
        }
                 return  resultQueryResult.getResponse().getDescription();
    }
    
    public String updateOttName(String url,String countryId,String name,String lastName, String msisdn,String comando){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);
            String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"updateUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"newCustomerName\":\""+name+"\",\n"     
                    + "		\"newCustomerLastName\":\""+lastName+"\",\n"   
                    + "		\"trnId\":\""+trnId+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){
                return resultQueryResult.getResponse().getDescription();
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultCode"); 
           
            if(resultCode.equals("0")){
              
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
       
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>();         
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);            
           
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json "+ex);
        }
                 return resultQueryResult.getResponse().getDescription();
    }
    
    public String updateOttPassword(String url,String countryId,String password, String msisdn,String comando){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);           
            String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"updateUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"recoverypassword\":\"true\",\n" 
                    + "		\"trnId\":\""+trnId+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){
                return resultQueryResult.getResponse().getDescription();
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultCode"); 
           
            if(resultCode.equals("0")){
              
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
       
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>();         
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);            
           
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json "+ex);
        }
                 return resultQueryResult.getResponse().getDescription();
    }
    
    public String cancelOttDevice(String url,String countryId,String device, String msisdn,String comando){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("Error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);           
            String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"updateUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"deviceId\":\""+device.trim()+"\",\n"
                    + "		\"trnId\":\""+trnId+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){
                return resultQueryResult.getResponse().getDescription();
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultCode"); 
           
           if(Integer.parseInt(resultCode)==0){
              
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
       
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>();         
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);            
           
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json "+ex);
        }
                 return resultQueryResult.getResponse().getDescription();
    }
    
    public String cancelOttPaymentMethod(String url,String countryId,String paymentMethod, String msisdn,String comando){
        ResultQueryUserResponse resultQueryResult = new ResultQueryUserResponse();
       
        try {
            Response response = new Response();
            response.setCode(-1);
            response.setDescription("error");
            ArrayList<String[]> listError = new ArrayList<>(); 
            String[] arrayErrorList = new String[1];
            listError.add(arrayErrorList);       
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listError);           
            String trnId = Utils.getUUI();
            
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"updateUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"paymentMethod\":\""+paymentMethod.trim()+"\",\n"
                    + "		\"trnId\":\""+trnId+"\"\n" 
                    + "		}\n"
                    + "}";
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){
                return resultQueryResult.getResponse().getDescription();
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("updateUserOttResponse")).get("resultCode"); 
           
           if(Integer.parseInt(resultCode)==0){
              
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
       
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>();         
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);            
           
           }
           
           System.out.println(response);
            
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json "+ex);
        }
                 return resultQueryResult.getResponse().getDescription();
    }
    
    
    public String addUserClaroVideo(String url,UserClaroVideo user ){

        
        String result="";
         Response response = new Response();
         String responseJson="Error al crear usuario";
        
        try {
           
            response.setCode(-1);
            response.setDescription("error");
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse ="{\n" +
                    "	\"createUserOttRequest\": \n" +
                    "	{\n" +
                    "		\"channel\": \"GUIWEB\",\n" +
                    "		\"name\": \""+user.getName()+"\",\n" +
                    "		\"lastName\": \""+user.getLastName()+"\",\n" +
                    "		\"motherLastName\": \""+user.getLastMother()+"\",\n" +
                    "		\"email\": \""+user.getEmail()+"\",\n" +
                    "		\"employeeId\": \"CVUSER2020\",\n" +
                    "		\"paymentMethod\": \""+user.getPaymentMethod()+"\",\n" +
                    "		\"MSISDN\": \""+user.getMsisdn()+"\",\n" +
                    "		\"Virtual\": \""+user.getVirtual()+"\",\n" +
                    "		\"TMCODE\": \"1000003\",\n" +
                    "		\"CUSTOMER_ID\": \"\",\n" +
                    "		\"CO_ID\": \"\"\n" +
                    "	}\n" +
                    "}";
            
    
            
            responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){             
                result="Error en alta de usuario";                
                return result;

            
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("createUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("createUserOttResponse")).get("resultCode"); 
          
            if(resultCode.equals("0")){
             response.setCode(Integer.parseInt(resultCode));
             response.setDescription(resultMessage);
            }else{
                response.setDescription(resultMessage);
            }
                    
          
          
     
            System.out.println(response.getDescription());
    
        } catch (ParseException ex) {
           responseJson = "Error to Parse Json queryUserOttResponse"+ex;
        } catch (NullPointerException ex) {
           return responseJson;
        }
                 return response.getDescription();
    }    
    
    public String cancelUserClaroVideo(String url,UserClaroVideo user ){

        
        String result="";
         Response response = new Response();
        
        try {
           
            response.setCode(-1);
            response.setDescription("error");
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse ="{\n" +
                    "	\"deleteUserOttRequest\": \n" +
                    "	{\n" +
                    "		\"paymentMethod\": \""+user.getPaymentMethod()+"\",\n" +
                    "		\"employeeId\": \"CVUSER2020\",\n" +
                    "		\"account\": \""+user.getMsisdn()+"\",\n" +
                    "		\"msisdn\": \""+user.getMsisdn()+"\"\n" +
                    "	}\n" +
                    "}";
            
    
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){             
                result="Error en baja de usuario";                
                return result;

            
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("deleteUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("deleteUserOttResponse")).get("resultCode"); 
          
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
          
     
            System.out.println(response.getDescription());
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return response.getDescription();
    }   
    
    
    
    public SprMobile mobileSprResponse(String url, String phone ){
  
        SprMobile dataSprMobile = new SprMobile();
       
        try {
        
            GetWebservice getWebservice = new GetWebservice();
            
            
            String responseJson = getWebservice.doGetJson(url);
            
            if(responseJson.equals("0")){
                dataSprMobile.setCodeResult("-1");
                dataSprMobile.setDescriptionResult("error");
                return dataSprMobile;
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            
            JSONObject statusTransaction = ((JSONObject) json.get("exitStatus"));
            
            Long code = (Long) statusTransaction.get("code");
            String description = (String) statusTransaction.get("description");
            
     
            
            if(code==0){
            
            String payment = (String) (json.get("paymentMethodInd"));
            String iso3166 = (String) (json.get("iso3166"));
            String imsi = (String) (json.get("imsi"));
            
    
            
          
            
            dataSprMobile.setPaymentMethodInd(payment);
            dataSprMobile.setIso3166(iso3166);
            dataSprMobile.setImsi(imsi);
            dataSprMobile.setCodeResult(String.valueOf(code));
            dataSprMobile.setDescriptionResult(description);
            dataSprMobile.setMsisdn(phone);
            
            
            
            
            }else{
                dataSprMobile.setCodeResult(String.valueOf(code));
                dataSprMobile.setDescriptionResult(description);
                return dataSprMobile;
            
            }
            
          
            
           
            System.out.println(dataSprMobile.getDescriptionResult());
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json mobileSpr"+ex);
        }
                 return dataSprMobile;
    }
    
    public SprLine lineSprResponse(String url,String phone){
    
    SprLine dataSprLine = new SprLine();
       
        try {
        
            GetWebservice getWebservice = new GetWebservice();
            
            
            String responseJson = getWebservice.doGetJson(url);
            
            if(responseJson.equals("0")){
                dataSprLine.setCodeResult("-1");
                dataSprLine.setDescriptionResult("error");
                return dataSprLine;
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            
            JSONObject statusTransaction = ((JSONObject) json.get("exitStatus"));
            Long code = (Long) statusTransaction.get("code");
            String description = (String) statusTransaction.get("description");            
        

            if(code==0){
                
                String msisdnVla = "";

                String payment = (String) (json.get("paymentMethodInd"));
                String iso3166 = (String) (json.get("iso3166"));

                JSONArray paramList = (JSONArray) json.get("paramList");
                int sizeArray = paramList.size();
                HashMap<String, String> hashMapParamList = new HashMap<>();
                for (int x = 0; x < sizeArray; x++) {
                    JSONObject val = (JSONObject) paramList.get(x);
                    String name = (String) val.get("name");
                    String value = (String) val.get("value");
                    hashMapParamList.put(name, value);
                }

                String fullName = (String) hashMapParamList.get("subad1");
                String lastName = (String) hashMapParamList.get("subfln");
                String name = (String) hashMapParamList.get("sebe01");
                String virtual = (String) hashMapParamList.get("virtual");
                String faccon = (String) hashMapParamList.get("faccon");

                int sizeFaccon = faccon.length();

                if (sizeFaccon != 8) {

                    for (int x = 0; x < (8 - sizeFaccon); x++) {
                        msisdnVla = msisdnVla + "0";
                    }
                }

                if (iso3166.equals("GT")) {
                    String msisdn = "502" + msisdnVla + faccon;
                    dataSprLine.setVirtual(virtual);
                    dataSprLine.setMsisdn(msisdn);

                } else {
                    dataSprLine.setVirtual(faccon);
                    dataSprLine.setMsisdn(phone);
                }

                dataSprLine.setLastName(lastName);
                dataSprLine.setName(name);
                dataSprLine.setPaymentMethodInd("F");
                dataSprLine.setIso3166(iso3166);
                dataSprLine.setCodeResult(String.valueOf(code));
                dataSprLine.setDescriptionResult(description);


                       
            }else{
            
                dataSprLine.setCodeResult(String.valueOf(code));
                dataSprLine.setDescriptionResult(description);
                return dataSprLine;
            
            
            }
            
            
            
         
            
            
            //dataSprLine.setNameUser(fullName);
            
           
            System.out.println(dataSprLine.getDescriptionResult());
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json mobileSpr"+ex);
        }
                 return dataSprLine;
    
    }
    
}
