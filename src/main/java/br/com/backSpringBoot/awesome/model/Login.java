package br.com.backSpringBoot.awesome.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Login implements Serializable {
    
    @Id 
    @GeneratedValue(generator = "slogin",strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message = "O campo empresa é obrigatório")
    private String empresa;
//    @NotEmpty(message = "O campo usuário é obrigatório")
    private String usuario;
//    @NotEmpty(message = "O campo senha é obrigatório")
    private String senha;   
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
