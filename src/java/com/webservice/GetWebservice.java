
package com.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GetWebservice {
    
    public  String doPost(String urlHttp){    
        String responseHttp="error";
        String output="";
          try {

		URL url = new URL(urlHttp);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "text/xml");
                
		if (conn.getResponseCode() != 200) {
                    System.out.println("Error call Webservice Url: "+url);
                    return output;                        
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        responseHttp = output;
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
            return responseHttp;
	}
    
    public  String doPostJson(String urlHttp, String jsonInputString){   
                     StringBuilder responseHttp=null;
                     String output="";
                    try{    
                        
                        URL url = new URL(urlHttp);
                        HttpURLConnection.setFollowRedirects(false);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setConnectTimeout(30000);
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setRequestProperty("Accept", "application/json");
                        conn.setDoOutput(true);
                        
                        
                        
                        try(OutputStream os = conn.getOutputStream()){
                            byte[] input = jsonInputString.getBytes("utf-8");
                            os.write(input, 0, input.length);
                        }
                        
                        int code = conn.getResponseCode();
                        String response = conn.getResponseMessage();
                        String message = conn.getHeaderField(7);
                        
                        if(code!=200){
                            System.out.println(code);
                            return "0";
                            
                        }
                        
                        
                        try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))){
                            responseHttp = new StringBuilder();
                            String responseLine = null;
                            while ((responseLine = br.readLine()) != null) {
                                responseHttp.append(responseLine.trim());
                            }
                            System.out.println(responseHttp.toString());
                        }                     
                    
                    } catch (SocketTimeoutException ex) {                  
                        Logger.getLogger(GetWebservice.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Error timeout ...");
                        return "-1";
                    } catch (IOException  ex) {
                        Logger.getLogger(GetWebservice.class.getName()).log(Level.SEVERE, null, ex);
                        return "0";
                    } 
               return responseHttp.toString();
	}
    
    public String  doGetJson(String urlHttp){
        StringBuilder responseHttp=null;
		try{    
             
                    URL url = new URL(urlHttp);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);

                    
                    
                 
                    int code = conn.getResponseCode();
                    String response = conn.getResponseMessage();
                    String message = conn.getHeaderField(7);
                    
                    if(code!=200){
                    System.out.println(code);
                    return "0";
                    
                    }
          
                    
                    try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))){
                        responseHttp = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            responseHttp.append(responseLine.trim());
                        }
                        System.out.println(responseHttp.toString());
                    }
                } catch (MalformedURLException ex) {
            Logger.getLogger(GetWebservice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetWebservice.class.getName()).log(Level.SEVERE, null, ex);
        }
                return responseHttp.toString();
        
    }
  
    
    }

