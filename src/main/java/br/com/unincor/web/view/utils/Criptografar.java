
package br.com.unincor.web.view.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Criptografar {
    public static String encryp( String valor){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(valor.getBytes());
            byte[] bytes = digest.digest();
            StringBuilder sb = new StringBuilder();
            for( byte b: bytes){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
           
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    public static void main(String[] args) {
        System.out.println(encryp("123456"));
    }
}
