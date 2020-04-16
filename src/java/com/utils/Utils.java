/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.io.InputStream;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author francisco_rg
 */
public class Utils {
    private static String emailRegex = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";
    private static Pattern pattern = Pattern.compile(emailRegex);
    
    /**
     * Retorna el codigo Iso2 del pais en base al numero de telefono
     * 
     * @param phonenumber telefono
     * @return codigo iso3 de pais
     */
    public static String getFromPhoneCountryISO3(String phonenumber) {
        String countryId = getFromPhoneCountryISO2(phonenumber);
        return countryId != null && !countryId.isEmpty() ? countryFromISO2ToISO3(countryId) : "";
    }

    /**
     * Convierte codigo de pais de iso2 a iso3
     * @param iso2 codigo de pais iso2
     * @return codigo de pais iso3
     */
    public static String countryFromISO2ToISO3(String iso2) {
        String countryId = "";
        if (iso2 == null || iso2.isEmpty() || iso2.length() < 2) {
            return "";
        } else {
            switch (iso2.toUpperCase()) {
                case "GT" : countryId = "GTM";
                    break;
                case "SV" : countryId = "SLV";
                    break;
                case "HN" : countryId = "HND";
                    break;
                case "NI" : countryId = "NIC";
                    break;
                case "CR" : countryId = "CRI";
                    break;
                case "PA" : countryId = "PAN";
                    break;
                case "DO" : countryId = "DOM";
                    break;
                case "CO" : countryId = "COL";
                    break;
                default :
                    countryId = "";
            }
        }
        return countryId;
    }
    
    /**
     * Convierte codigo de pais de iso3 a iso2
     * @param iso3 codigo de pais iso3
     * @return codigo de pais iso2
     */
    public static String countryFromISO3ToISO2(String iso3) {
        String countryId = "";
        if (iso3 == null || iso3.isEmpty() || iso3.length() < 3) {
            return "";
        } else {
            switch (iso3.toUpperCase()) {
                case "GTM" : countryId = "GT";
                    break;
                case "SLV" : countryId = "SV";
                    break;
                case "HND" : countryId = "HN";
                    break;
                case "NIC" : countryId = "NI";
                    break;
                case "CRI" : countryId = "CR";
                    break;
                case "PAN" : countryId = "PA";
                    break;
                case "DOM" : countryId = "DO";
                    break;
                case "COL" : countryId = "CO";
                    break;
                default :
                    countryId = "";
            }
        }
        return countryId;
    }
    
    /**
     * Retorna el codigo Iso2 del pais en base al numero de telefono
     * 
     * @param phonenumber telefono
     * @return codigo iso2 de pais
     */
    public static String getFromPhoneCountryISO2(String phonenumber) {
        String countryId = "";
        if (phonenumber == null || phonenumber.isEmpty() || phonenumber.length() < 11) {
            return "";
        } else {
            switch (phonenumber.substring(0, 3)) {
                case "502" : countryId = "GT";
                    break;
                case "503" : countryId = "SV";
                    break;
                case "504" : countryId = "HN";
                    break;
                case "505" : countryId = "NI";
                    break;
                case "506" : countryId = "CR";
                    break;
                case "507" : countryId = "PA";
                    break;
                case "809" : countryId = "DO";
                    break;
                case "829" : countryId = "DO";
                    break;
                case "057" : countryId = "CO";
                    break;
            }
        }
        return countryId;
    }
    
    /**
     * Retorna el codigo Iso2 del pais en base al id
     * 
     * @param customerId id de cliente
     * @return codigo iso2 de pais en mayuscula
     */
    public static String getFromCustomerIdCountryISO2Upper(String customerId) {
        String countryId = getFromCustomerIdCountryISO2(customerId);
        return countryId != null && !countryId.isEmpty() ? countryId.toUpperCase() : "";
    }
    
    /**
     * Retorna el codigo Iso2 del pais en base al id
     * 
     * @param customerId id de cliente
     * @return codigo iso2 de pais
     */
    public static String getFromCustomerIdCountryISO2(String customerId) {
        String countryId = "";
        if (customerId == null || customerId.isEmpty() || customerId.length() <= 2) {
            return "";
        } else {
            switch (customerId.substring(0, 2).toUpperCase()) {
                case "GT" : countryId = "GT";
                    break;
                case "SV" : countryId = "SV";
                    break;
                case "HN" : countryId = "HN";
                    break;
                case "NI" : countryId = "NI";
                    break;
                case "CR" : countryId = "CR";
                    break;
                case "PA" : countryId = "PA";
                    break;
                case "DO" : countryId = "DO";
                    break;
                case "CO" : countryId = "CO";
                    break;
                default :
                    countryId = "";
            }
        }
        return countryId;
    }
    
    
    /**
     * Retorna id universal unico
     * 
     * @return id generado
     */
    public static String getUUI() {
        UUID uuid = null;
        String randomUUIDString = "";
                
        // Creating a random UUID (Universally unique identifier).
        //UUID Tipo 4
        uuid = UUID.randomUUID();
        //UUID tipo 5
        //uuid = UUID5.fromUTF8("fbaf4649-a3c4-49dd-98bd-58e76680c42c");
        uuid = UUID5.fromUTF8(uuid.toString());
        
        randomUUIDString = uuid.toString();
        return randomUUIDString;
    } 
    
    
    public static String buildErrorMessage(HttpServletRequest req, Throwable e) {
        StringBuilder message = new StringBuilder();
        String entity = "(empty)";

        try {
            // How to cache getInputStream: http://stackoverflow.com/a/17129256/356408
            InputStream is = req.getInputStream();
            // Read an InputStream elegantly: http://stackoverflow.com/a/5445161/356408
            Scanner s = new Scanner(is, "UTF-8").useDelimiter("\\A");
            entity = s.hasNext() ? s.next() : entity;
        } catch (Exception ex) {
            // Ignore exceptions around getting the entity
        } finally {
        }

        message.append("Uncaught REST API exception:\n");
        message.append("Message: ").append(e != null ? e.getMessage() : "").append("\n");
        message.append("URL: ").append(getOriginalURL(req)).append("\n");
        message.append("Method: ").append(req.getMethod()).append("\n");
        message.append("Entity: ").append(entity).append("\n");

        return message.toString();
    }

    public static String getOriginalURL(HttpServletRequest req) {
        // Rebuild the original request URL: http://stackoverflow.com/a/5212336/356408
        
        if (req == null)
            return "No se puede obtener URL";
        
        String scheme = req.getScheme();             // http
        String serverName = req.getServerName();     // hostname.com
        int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
        String servletPath = req.getServletPath();   // /servlet/MyServlet
        String pathInfo = req.getPathInfo();         // /a/b;c=123
        String queryString = req.getQueryString();   // d=789
        
        // Reconstruct original requesting URL
        StringBuilder url = new StringBuilder();
        url.append(scheme).append("://").append(serverName);

        if (serverPort != 80 && serverPort != 443) {
            url.append(":").append(serverPort);
        }

        url.append(contextPath).append(servletPath);

        if (pathInfo != null) {
            url.append(pathInfo);
        }

        if (queryString != null) {
            url.append("?").append(queryString);
        }

        return url.toString();
    }

    /**
     * Valida correo electronico
     * 
     * @param email correo electronico
     * @return true si es valido
     */
    public static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty())
            return false;
        
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
