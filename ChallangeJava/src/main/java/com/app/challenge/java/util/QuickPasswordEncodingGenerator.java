package com.app.challenge.java.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  
public class QuickPasswordEncodingGenerator {
  
    /**
     * @param args
     */
    public static void main(String[] args) {
            String password = "Neeraj@123";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));
    }
  
}