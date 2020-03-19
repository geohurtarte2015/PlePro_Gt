/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author LENOVO
 */
public class Spr {
    
    private String paymentMethodInd;
    private String iso3166;
    private String codeResult;
    private String descriptionResult;


 
    public String getCodeResult() {
        return codeResult;
    }

   
    public void setCodeResult(String codeResult) {
        this.codeResult = codeResult;
    }


    public String getDescriptionResult() {
        return descriptionResult;
    }

   
    public void setDescriptionResult(String descriptionResult) {
        this.descriptionResult = descriptionResult;
    }
    
  
    public String getPaymentMethodInd() {
        return paymentMethodInd;
    }


    public void setPaymentMethodInd(String paymentMethodInd) {
        this.paymentMethodInd = paymentMethodInd;
    }

  
    public String getIso3166() {
        return iso3166;
    }

  
    public void setIso3166(String iso3166) {
        this.iso3166 = iso3166;
    }

  
  
    
}
