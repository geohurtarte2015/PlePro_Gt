/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice;

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

    public ResultQueryUserResponse queryOttSubscriptions(String url,String countryId, String email, String msisdn,String comando,String dateInit,String dateFinish ){
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
                    + "	\"queryUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"msisdn\":\""+msisdn.trim()+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\",\n"
                    + "		\"trnId\":\""+trnId+"\"\n" 
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
            
            arraySubsciptionList[0] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(2)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(5)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(6)).get("value");
            arraySubsciptionList[4] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(7)).get("value");
            arraySubsciptionList[5] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(8)).get("value");
            arraySubsciptionList[6] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(9)).get("value");
            arraySubsciptionList[7] = (String) ((JSONObject)((JSONArray) ((JSONObject) subscription.get(y)).get("item")).get(10)).get("value");
            
         
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
            response.setDescription("error");
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
                    + "		\"trnId\":\""+trnId+"\"\n" 
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
                    
       
            String[] arraySubsciptionList = new String[sizeItem];
            
            arraySubsciptionList[0] = (String) ((JSONObject) item.get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject) item.get(1)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject) item.get(2)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject) item.get(3)).get("value");
            arraySubsciptionList[4] = (String) ((JSONObject) item.get(4)).get("value");
            arraySubsciptionList[5] = (String) ((JSONObject) item.get(5)).get("value");
            
           
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
            response.setDescription("error");
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
                    + "		\"trnId\":\""+trnId+"\"\n" 
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
           
           if(Integer.parseInt(resultCode)==0){
               
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
            String[] arraySubsciptionList = new String[sizeItem+1];
            
            arraySubsciptionList[0] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(1)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(2)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(3)).get("value");
            arraySubsciptionList[4] = "";
            
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
            response.setDescription("error");
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
                    + "		\"trnId\":\""+trnId+"\"\n" 
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
           
           
           
           
            if (Integer.parseInt(resultCode) == 0) {

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
                    arraySubsciptionList[1] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(1)).get("value");
                    arraySubsciptionList[2] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(2)).get("value");
                    arraySubsciptionList[3] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(3)).get("value");
                    arraySubsciptionList[4] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(4)).get("value");
                    arraySubsciptionList[5] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(5)).get("value");
                    arraySubsciptionList[6] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(6)).get("value");
                    arraySubsciptionList[7] = (String) ((JSONObject) ((JSONArray) ((JSONObject) item.get(y)).get("item")).get(7)).get("value");

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
                 return  resultQueryResult.getResponse().getDescription();
    }
    
    public String updateOttName(String url,String countryId,String name,String lastName, String msisdn,String comando){
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
    
    public String updateOttPassword(String url,String countryId,String password, String msisdn,String comando){
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
                    + "		\"newCustomerName\":\""+password+"\",\n" 
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
    
    public String AddUser(String url,UserClaroVideo user ){

        
        String result="";
         Response response = new Response();
        
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
                    "		\"TMCODE\": \"\",\n" +
                    "		\"CUSTOMER_ID\": \"\",\n" +
                    "		\"CO_ID\": \"\"\n" +
                    "	}\n" +
                    "}";
            
    
            
            String responseJson = getWebservice.doPostJson(url, stringToParse);
            
            if(responseJson.equals("0")){             
                result="Error en alta de usuario";                
                return result;

            
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(responseJson);
            String resultMessage = (String) ((JSONObject) json.get("createUserOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("createUserOttResponse")).get("resultCode"); 
          
                    
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
            
            if(code==10){
                dataSprMobile.setCodeResult(String.valueOf(code));
                dataSprMobile.setDescriptionResult(description);
                return dataSprMobile;
            }
            
            
            
            String payment = (String) (json.get("paymentMethodInd"));
            String iso3166 = (String) (json.get("iso3166"));
            String imsi = (String) (json.get("imsi"));
            
    
            
          
            
            dataSprMobile.setPaymentMethodInd(payment);
            dataSprMobile.setIso3166(iso3166);
            dataSprMobile.setImsi(imsi);
            dataSprMobile.setCodeResult(String.valueOf(code));
            dataSprMobile.setDescriptionResult(description);
            dataSprMobile.setMsisdn(phone);
            
            
           
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
            
            if(code==10){
                dataSprLine.setCodeResult(String.valueOf(code));
                dataSprLine.setDescriptionResult(description);
                return dataSprLine;
            }

            String msisdnVla = "";
            
            
            
            String payment = (String) (json.get("paymentMethodInd"));
            String iso3166 = (String) (json.get("iso3166"));
            
            JSONArray paramList = (JSONArray) json.get("paramList");
            int sizeArray = paramList.size();
            HashMap<String, String> hashMapParamList = new HashMap<>();
            for (int x=0;x<sizeArray;x++){                
               JSONObject val =  (JSONObject) paramList.get(x);
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
            
            if(sizeFaccon!=8){
           
            for (int x=0;x<(8-sizeFaccon);x++){             
                msisdnVla=msisdnVla+"0";        
            }
            }
            
            
          
            if(iso3166.equals("GT")){                
               String msisdn = "502"+msisdnVla+faccon;
                dataSprLine.setVirtual(virtual);
                dataSprLine.setMsisdn(msisdn);
              
                
            }else{
                dataSprLine.setVirtual(faccon);     
                dataSprLine.setMsisdn(phone);
            }
            
            dataSprLine.setLastName(lastName);
            dataSprLine.setName(name);
            dataSprLine.setPaymentMethodInd("F");
            dataSprLine.setIso3166(iso3166);        
            dataSprLine.setCodeResult(String.valueOf(code));
            dataSprLine.setDescriptionResult(description);
            
            
         
            
            
            //dataSprLine.setNameUser(fullName);
            
           
            System.out.println(dataSprLine.getDescriptionResult());
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json mobileSpr"+ex);
        }
                 return dataSprLine;
    
    }
    
}
