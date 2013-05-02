package com.bancomer.gis.monitorwebswift.util;

import java.security.MessageDigest;

public class Cryptography{
    private String hash(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int u = b[i]&255;	// unsigned conversion
            if (u<16) {
                h.append("0"+Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }

    public String encrypt(String palabra)throws Exception {
        String pe = "";
        try {
            pe = hash(palabra);
        } catch (Exception e) {
            throw new Error("Error: Al encriptar el password");    
        }
        return pe;
    }
    
   public static void main(String[] args) throws Exception{
	   
	   Cryptography c = new Cryptography();
	   System.out.println(c.encrypt("123"));
	   
   }
        
}