/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;




public class Configuration {

    /**
     * @return the prefixCountry
     */
    public String getPrefixCountry() {
        return prefixCountry;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

  

 
    
    private final String jdbcOffLineTrx;
    private final String userJdbcOffLineTrx;
    private final String passwordJdbcOffLineTrx;
    private final String jdbcCatalog;
    private final String userJdbcCatalog;
    private final String passwordJdbcCatalog;
    private final String jdbcProgram;
    private final String userJdbcProgram;
    private final String passwordJdbcProgram;
    private final String jdbcPos;
    private final String userJdbcPos;
    private final String passwordJdbcPos;
    private final String poolOffLineTrx;
    private final String poolCatalog;
    private final String poolProgram;
    private final String poolPos;
    private final String wsdlLocation;
    private final String urlPos1;
    private final String urlPos2;
    private final String urlHubClaroVideo;
    private final String urlAmcoOperationClaroVideo;
    private final String urlAmcoUserClaroVideo;
    private final String spr;
    private final String prefixCountry;
    private final String country;
    

    
    
    public  Configuration(){
        jdbcOffLineTrx = "";
        userJdbcOffLineTrx="";
        passwordJdbcOffLineTrx="";
        jdbcCatalog="";
        passwordJdbcCatalog="";
        userJdbcCatalog="";
        jdbcProgram="DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = oracleprd06-scan)(PORT = 3872)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = PLEDBGT))";
        userJdbcProgram="sm_program";
        passwordJdbcProgram="C26pr#2019";
        poolOffLineTrx="JDBC/PLEGT_TRX";
        poolCatalog="JDBC/PLEGT";
        poolProgram="";
        poolPos="";
        wsdlLocation="http://172.16.168.143:7003/WS_PLE_BRIDGE_GT/PackageCore?WSDL";
        
        //POS
        urlPos1="http://172.16.168.139:7003/wsValidatorPOS/webresources/validate/loadData";
        urlPos2="http://172.16.168.138:7003/wsValidatorPOS/webresources/validate/loadData";
        jdbcPos="DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = oracleprd04-scan)(PORT = 3872)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = POSDBGT))";
        passwordJdbcPos="D26of#2019";
        userJdbcPos="pos_offlinetrx";
        
        
        //CLARO VIDEO
        urlHubClaroVideo="http://10.218.41.26:6006/WS_MPM_VIDEO_SPR/HubClaroVideo?WSDL";
        urlAmcoOperationClaroVideo="172.16.204.189:30110";
        urlAmcoUserClaroVideo="172.16.204.189:30110";
        spr="172.16.204.215:10001";
        prefixCountry="502";
        country="GT";

        
        
    }
    
     public String getUrlPos2() {
        return urlPos2;
    }
    
    public String getUrlPos1() {
        return urlPos1;
    }
  
    public String getJdbcOffLineTrx() {
        return jdbcOffLineTrx;
    }

   
    public String getUserJdbcOffLineTrx() {
        return userJdbcOffLineTrx;
    }

   
    public String getPasswordJdbcOffLineTrx() {
        return passwordJdbcOffLineTrx;
    }

   
    public String getJdbcCatalog() {
        return jdbcCatalog;
    }

  
    public String getUserJdbcCatalog() {
        return userJdbcCatalog;
    }

   
    public String getPasswordJdbcCatalog() {
        return passwordJdbcCatalog;
    }

    
    public String getJdbcProgram() {
        return jdbcProgram;
    }

   
    public String getUserJdbcProgram() {
        return userJdbcProgram;
    }

  
    public String getPasswordJdbcProgram() {
        return passwordJdbcProgram;
    }

  
    public String getJdbcPos() {
        return jdbcPos;
    }

   
    public String getUserJdbcPos() {
        return userJdbcPos;
    }

 
    public String getPasswordJdbcPos() {
        return passwordJdbcPos;
    }

   
    public String getPoolOffLineTrx() {
        return poolOffLineTrx;
    }

    
    public String getPoolCatalog() {
        return poolCatalog;
    }

   
    public String getPoolProgram() {
        return poolProgram;
    }

    
    public String getPoolPos() {
        return poolPos;
    }

   
    public String getWsdlLocation() {
        return wsdlLocation;
    }
    
   
    public String getUrlHubClaroVideo() {
        return urlHubClaroVideo;
    }

  
    public String getUrlAmcoOperationClaroVideo() {
        return urlAmcoOperationClaroVideo;
    }

  
    public String getUrlAmcoUserClaroVideo() {
        return urlAmcoUserClaroVideo;
    }

  
    public String getSpr() {
        return spr;
    }
    

    
    
    
    
}
