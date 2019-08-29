package br.com.backSpringBoot.awesome.repository;

import br.com.backSpringBoot.awesome.model.User_Token;



public interface UserRepository {
    
    User_Token findByUsername(String username);
}
