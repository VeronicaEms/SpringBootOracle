package br.com.backSpringBoot.awesome.endpoint;

import br.com.backSpringBoot.awesome.error.ResourceNotFoundException;
import br.com.backSpringBoot.awesome.model.Login;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.backSpringBoot.awesome.repository.Repository;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("login")
public class EndpointLogin {
       
    private final Repository loginDAO;

    @Autowired
    public EndpointLogin(Repository loginDAO) {
        this.loginDAO = loginDAO;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> listAllLogin() {
        return new ResponseEntity<>(loginDAO.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getLoginById(@PathVariable("id") Long id) {
        verifyIfLoginExists(id);
        Login login = loginDAO.findById(id).get();
        return new ResponseEntity<>(login, HttpStatus.OK);    
    }   
    
   @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Login login) {
        System.out.println(">>>AQUI"+login.getEmpresa());
        System.out.println(">>>AQUI"+login.getUsuario());
        System.out.println(">>>AQUI"+login.getSenha());
        return new ResponseEntity<>(loginDAO.save(login), HttpStatus.CREATED);
    }
    
    @CrossOrigin
    @DeleteMapping(path ="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println("id" +id);
        verifyIfLoginExists(id);
        loginDAO.deleteById(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @CrossOrigin
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Login login) {
        verifyIfLoginExists(login.getId());
        loginDAO.save(login);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private void verifyIfLoginExists(Long id){
        if (!loginDAO.findById(id).isPresent() || loginDAO.findById(id).get() == null) {
        throw new ResourceNotFoundException("Login não encontado pelo ID:" +id);
        }
    }
}
