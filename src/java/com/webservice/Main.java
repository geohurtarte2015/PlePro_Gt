
package com.webservice;

import clientWebservice.AddSubscriberHubClaro;
import clientWebservice.TbHUBSUBSCRIBER;
import com.pojo.Response;
import com.pojo.ResultQueryUserResponse;
import java.util.ArrayList;




public class Main {

   
    public static void main(String[] args) {
        
        TbHUBSUBSCRIBER dataUser = null;
        
        RequestJson requestJson = new RequestJson();
        ResultQueryUserResponse responseQueryUserResponse = new ResultQueryUserResponse();
        Response response = new Response();
        
          AddSubscriberHubClaro addSubscriberHubClaro = new AddSubscriberHubClaro();
          dataUser = addSubscriberHubClaro.listAccountSuscriber("", "", "50233445566");
        
       // responseQueryUserResponse = requestJson.mobileResponse("http://172.16.204.215:10001/spr/rest/resource/v1/cache/profile/50256235623/mc/default/show");
//        
//        String description = responseQueryUserResponse.getResponse().getDescription();
//        int code = responseQueryUserResponse.getResponse().getCode();
//        ArrayList<String[]> responseList = responseQueryUserResponse.getUserResponse();
//        
//        

        System.out.println(dataUser);

    }
    
    
}