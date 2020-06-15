
package clientWebservice;


public class ServiceSuscriptions {

    public  RepuestaInvokeParams serviceActive(clientWebservice.ParameterService parameters) {
        clientWebservice.HubClaroVideo service = new clientWebservice.HubClaroVideo();
        clientWebservice.SprCore port = service.getSprCorePort();
        return port.serviceActive(parameters);
    }

    public  RepuestaInvokeParams serviceDesactive(clientWebservice.ParameterService parameters) {
        clientWebservice.HubClaroVideo service = new clientWebservice.HubClaroVideo();
        clientWebservice.SprCore port = service.getSprCorePort();
        return port.serviceDesactive(parameters);
    }

    public RepuestaInvokeParams eligibilityAccount(java.lang.String customerElegibility, java.lang.String keyword, java.lang.String phone, java.lang.String amcoId) {
        clientWebservice.HubClaroVideo service = new clientWebservice.HubClaroVideo();
        clientWebservice.SprCore port = service.getSprCorePort();
        return port.eligibilityAccount(customerElegibility, keyword, phone, amcoId);
    }

  
    
    
}
