package br.com.backSpringBoot.awesome.config;

import java.util.concurrent.TimeUnit;


public class SecurityConstants {
    
    static final String SECRET = "***";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/login";
    static final long EXPIRATION_TIME = 86400000L;
    
    public static void main(String[] args) {
        System.out.println(TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
}

