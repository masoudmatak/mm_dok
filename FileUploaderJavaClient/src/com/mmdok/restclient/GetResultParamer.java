/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/
package com.mmdok.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;


public class GetResultParamer {
    public static void main(String[] args) throws Exception {
        try {
            long folderID = 4L;
          //  URL url = new URL("http://13.53.172.37:8080/autorize-1/rest/autorize/195904119999");
           // URL url = new URL("http://127.0.0.1/autorize-1/rest/autorize/190701143208/");
            URL url = new URL("http://127.0.0.1/autorize-1/rest/autorize/195207013060/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("admin", "admin".toCharArray());
                }
            });
            
            if (conn.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output=br.readLine();
                System.out.println("Output from Server ...."+output+" \n");
                
                
                System.out.println(br.readLine());
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            } else {
                System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
            }
            
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}