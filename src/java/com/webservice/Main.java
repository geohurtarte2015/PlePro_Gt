
package com.webservice;

import clientWebservice.AddSubscriberHubClaro;
import clientWebservice.TbHUBSUBSCRIBER;
import com.pojo.Response;
import com.pojo.ResultQueryUserResponse;
import com.pojo.SprLine;
import com.pojo.SprMobile;
import java.util.ArrayList;




public class Main {

   
    public static void main(String[] args) {
        
        TbHUBSUBSCRIBER dataUser = null;
        
        RequestJson requestJson = new RequestJson();
        ResultQueryUserResponse responseQueryUserResponse = new ResultQueryUserResponse();
        SprMobile sprMobile = new SprMobile();
        SprLine sprLine = new SprLine();
        Response response = new Response();
        //50233445566
         //AddSubscriberHubClaro addSubscriberHubClaro = new AddSubscriberHubClaro();
        // dataUser = addSubscriberHubClaro.listAccountSuscriber("", "", "50244003636");
        
         //sprMobile = requestJson.mobileSprResponse("http://172.16.204.215:10001/spr/rest/resource/v1/cache/profile/50256235623/mc/default/show");

         sprLine = requestJson.lineSprResponse("http://172.16.204.215:10001/spr/rest/resource/v1/cache/profile/pisa-22616256/default/default/show","502"+"22616256");
         
//        String description = responseQueryUserResponse.getResponse().getDescription();
//        int code = responseQueryUserResponse.getResponse().getCode();
//        ArrayList<String[]> responseList = responseQueryUserResponse.getUserResponse();
//        
//        

        System.out.println(sprLine.getPaymentMethodInd());

    }
    
    
}