
package clientWebservice;


public class AddSubscriberHubClaro {

    //obitene datos del cliente
    public  TbHUBSUBSCRIBER listAccountSuscriber(java.lang.String customerId, java.lang.String token, java.lang.String phone) {
        clientWebservice.HubClaroVideo service = new clientWebservice.HubClaroVideo();
        clientWebservice.SprCore port = service.getSprCorePort();
        return port.listAccountSuscriber(customerId, token, phone);
    }

    
}
