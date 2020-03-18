/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice;

import com.pojo.Response;
import com.pojo.ResultQueryUserResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"customerId\":\""+msisdn+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\"\n"
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
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
            JSONObject subscriptionList = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("subscriptionList"));      
         
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
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryUserOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"customerId\":\""+msisdn+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\"\n"
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
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"customerId\":\""+msisdn+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\"\n"
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
            String resultMessage = (String) ((JSONObject) json.get("queryOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryOttResponse")).get("resultCode"); 
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
            JSONObject subscription = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryOttResponse")).get("deviceList"));      
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            //int size = userData.size();
            int sizeSubscriptionList = subscription.size();
           
            
            //String[] arrayUserData = new String[size];
            //arrayUserData[0]= (String) ((JSONObject) userData.get("item")).get("value");
            //JSONObject listItem =  (JSONObject) subscription.get(0);
      
     
            JSONArray item = (JSONArray) subscription.get("device");
            int sizeItem = item.size();
            
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                    
            for(int y=0;y<sizeItem;y++){
            String[] arraySubsciptionList = new String[sizeItem];
            
            arraySubsciptionList[0] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(1)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(2)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(3)).get("value");
         
            listSubscriptionUser.add(arraySubsciptionList);
            }
            
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);
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
            
            
            GetWebservice getWebservice = new GetWebservice();
            
            String stringToParse = "{\n"
                    + "	\"queryOttRequest\":{\n"
                    + "		\"serviceName\":\""+comando+"\",\n"
                    + "		\"invokeMethod\":\""+comando+"\",\n"
                    + "		\"countryId\":\""+countryId+"\",\n"
                    + "		\"customerId\":\""+msisdn+"\",\n"
                    + "		\"startDate\":\""+dateInit+"\",\n"
                    + "		\"endDate\":\""+dateFinish+"\"\n"
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
            String resultMessage = (String) ((JSONObject) json.get("queryOttResponse")).get("resultMessage");
            String resultCode = (String) ((JSONObject) json.get("queryOttResponse")).get("resultCode"); 
           // JSONObject userData = (JSONObject) ((JSONObject) json.get("queryUserOttResponse")).get("userData");
            JSONObject subscription = (JSONObject) ((JSONObject) ((JSONObject) json.get("queryOttResponse")).get("rentList"));      
                    
            response.setCode(Integer.parseInt(resultCode));
            response.setDescription(resultMessage);
            //int size = userData.size();
            int sizeSubscriptionList = subscription.size();
           
            
            //String[] arrayUserData = new String[size];
            //arrayUserData[0]= (String) ((JSONObject) userData.get("item")).get("value");
            //JSONObject listItem =  (JSONObject) subscription.get(0);
      
     
            JSONArray item = (JSONArray) subscription.get("rent");
            int sizeItem = item.size();
            
            ArrayList<String[]> listSubscriptionUser = new ArrayList<>(); 
                    
            for(int y=0;y<sizeItem;y++){
            String[] arraySubsciptionList = new String[sizeItem];
            
            arraySubsciptionList[0] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(0)).get("value");
            arraySubsciptionList[1] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(1)).get("value");
            arraySubsciptionList[2] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(2)).get("value");
            arraySubsciptionList[3] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(3)).get("value");
            arraySubsciptionList[4] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(4)).get("value");
            arraySubsciptionList[5] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(5)).get("value");
            arraySubsciptionList[6] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(6)).get("value");
            arraySubsciptionList[7] = (String) ((JSONObject)((JSONArray) ((JSONObject) item.get(y)).get("item")).get(7)).get("value");
         
         
            listSubscriptionUser.add(arraySubsciptionList);
            }
            
            
            resultQueryResult.setResponse(response);
            resultQueryResult.setUserResponse(listSubscriptionUser);
            System.out.println(response);
    
        } catch (ParseException ex) {
           System.out.println("Error to Parse Json queryUserOttResponse"+ex);
        }
                 return resultQueryResult;
    }
    
    
}
