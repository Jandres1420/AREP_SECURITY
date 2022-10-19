/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.securityproperties;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.secure;

/**
 *
 * @author juan.pico-m
 */
public class SecurityProperties {

    public static void main(String[] args) {
        secure("keystores/ecikeystore.p12", "123456", null, null);

        port(getPort());

        get("/hello", (req, res) -> "Hello World");
    }
    
    static int getPort() { 
        if (System.getenv("PORT") != null) { 
            return Integer.parseInt(System.getenv("PORT")); 
        } 
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost) 
    }
}
