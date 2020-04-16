
package clientWebservice;


public class BundleClaroVideo {

    public RepuestaInvokeParams accountBundleStateUpdate(java.lang.String customer, java.lang.String operation) {
        clientWebservice.HubClaroVideo service = new clientWebservice.HubClaroVideo();
        clientWebservice.SprCore port = service.getSprCorePort();
        return port.accountBundleStateUpdate(customer, operation);
    }
    
    
    
    
    
}
