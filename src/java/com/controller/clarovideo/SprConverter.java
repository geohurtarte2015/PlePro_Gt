
package com.controller.clarovideo;

import com.pojo.SprLine;
import com.pojo.SprMobile;
import com.pojo.UserClaroVideo;
import com.webservice.RequestJson;


public class SprConverter {
    
    public SprConverter(){}
    
    //valida typo 
    public UserClaroVideo sprValidateType(String typeBusiness,String spr, String phone,String msisdn){
            SprLine sprLine = new SprLine();
   
            UserClaroVideo user = new UserClaroVideo();
            RequestJson requestJson = new RequestJson();
            SprMobile sprMobile = new SprMobile();
           
    
            if (Integer.parseInt(typeBusiness) == 2) {
                sprLine = requestJson.lineSprResponse("http://"+spr+"/spr/rest/resource/v1/cache/profile/pisa-" + phone + "/default/default/show",msisdn);
                
       
                user.setMsisdn(sprLine.getMsisdn());                
                user.setCodeResponse(sprLine.getCodeResult());
                user.setDescriptionResponse(sprLine.getDescriptionResult());
                user.setVirtual(sprLine.getVirtual());
                user.setPaymentMethod(sprLine.getPaymentMethodInd());
             
            } else {
                sprMobile = requestJson.mobileSprResponse("http://"+spr+"/spr/rest/resource/v1/cache/profile/" + msisdn + "/mc/default/show",msisdn);
               
                user.setCodeResponse(sprMobile.getCodeResult());
                user.setDescriptionResponse(sprMobile.getDescriptionResult());
                user.setPaymentMethod(sprMobile.getPaymentMethodInd());
                user.setMsisdn(sprMobile.getMsisdn());
                user.setVirtual("");
            }
            return user;
    }
    
        
    public UserClaroVideo sprLineConverterLine(String spr, String phone,String msisdn){
            SprLine sprLine = new SprLine();
   
            UserClaroVideo user = new UserClaroVideo();
            RequestJson requestJson = new RequestJson();
   
           
                sprLine = requestJson.lineSprResponse("http://"+spr+"/spr/rest/resource/v1/cache/profile/pisa-" + phone + "/default/default/show",msisdn);
                
       
                user.setMsisdn(sprLine.getMsisdn());                
                user.setCodeResponse(sprLine.getCodeResult());
                user.setDescriptionResponse(sprLine.getDescriptionResult());
                user.setVirtual(sprLine.getVirtual());
                user.setPaymentMethod(sprLine.getPaymentMethodInd());
             
        
            return user;
    }
            
            
    
  
            
    
  
    
}
