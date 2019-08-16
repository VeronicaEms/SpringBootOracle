package br.com.backSpringBoot.awesome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.backSpringBoot.awesome.repository.Repository;


/*
*Classe responsável por startar nosso Spring boot
*O Spriig boot será encarregado de startar o tomCat
*/

@SpringBootApplication
public class ApplicationStart {
    @Autowired
    Repository repository;
    public static void main(String[] args){
        SpringApplication.run(ApplicationStart.class, args);
    }
}
