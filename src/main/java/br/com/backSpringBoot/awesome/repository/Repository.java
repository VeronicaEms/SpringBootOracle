package br.com.backSpringBoot.awesome.repository;

import br.com.backSpringBoot.awesome.model.Login;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Repository extends PagingAndSortingRepository<Login, Long> {
    List<Login> findByEmpresa(String empresa);
    List<Login> findByUsuario(String usuario);
    List<Login> findBySenha(String senha);
 
}
