package br.com.backSpringBoot.awesome;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Um algoritmo que vai criptografar a senha
public class PasswordEncoder {
    public static void main(String[] args){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("***"));
    }




}


