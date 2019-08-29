package br.com.backSpringBoot.awesome.endpoint;

import br.com.backSpringBoot.awesome.model.GcMaterial;
import br.com.jdbcpersistence.connection.ConnectionFactory;
import br.com.jdbcpersistence.dao.GenericJDBCDAO;
import br.com.jdbcpersistence.util.Operation;
import java.sql.Connection;
import java.sql.SQLException;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author people
 */
@RestController
//@Controller
//@ResponseBody
@CrossOrigin(origins = "*")
@RequestMapping("Material")
public class GcMaterialPoint {

    private final GenericJDBCDAO dao = new GenericJDBCDAO();


    @GetMapping(path = "/material/all")
    public ResponseEntity<?> listAll(String empresa, String user, String senha, Integer pagina) {
        try {
            dao.setShowSQL(true);

            ConnectionFactory connectionFactory = new ConnectionFactory(empresa + ".properties");
            Connection conn = connectionFactory.newConnection("finpac", "naoseid", ConnectionFactory.SetConnect.WITH_SCHEMA);

            if (pagina == null || pagina == 0) {
                pagina = 1;
            }

            String where = " where cod_material in (select cod_material from ( "
                    + "select  cod_material, ROWNUM rnum "
                    + "      from ("
                    + "      select  cod_material   from gc_material "
                    + "             order by cod_material "
                    + ") topn "
                    + "where ROWNUM  <= " + (pagina * 20) + ") "
                    + "where rnum  > " + ((pagina * 20) - 20) + " ) order by cod_material";

            return new ResponseEntity<>(dao.listByCriteria(conn, new br.com.backSpringBoot.awesome.model.GcMaterial(), where, true), HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    

    @GetMapping(path = "/material/{codMaterial}")
    public ResponseEntity<?> getGcMaterial(String empresa,
            String user,
            String senha,
            @PathVariable("codMaterial") String codMaterial) {
        try {
            dao.setShowSQL(true);

            ConnectionFactory connectionFactory = new ConnectionFactory(empresa + ".properties");
            Connection conn = connectionFactory.newConnection("finpac", "naoseid", ConnectionFactory.SetConnect.WITH_SCHEMA);

            if (dao.exist(conn, new br.com.backSpringBoot.awesome.model.GcMaterial(), "cod_material", codMaterial)) {
                return new ResponseEntity<>(dao.listByCriteria(conn, new br.com.backSpringBoot.awesome.model.GcMaterial(), "cod_material", codMaterial), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Material não encontrado", HttpStatus.OK);
            }
        } catch (SQLException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
  
    @PostMapping(path = "material")
    public ResponseEntity<?> save(String empresa,
            String user,
            String senha,
            @RequestBody br.com.backSpringBoot.awesome.model.GcMaterial gcMaterial) {
        try {
            dao.setShowSQL(true);
            System.out.println("valor situação"+gcMaterial.getCodSitMaterial());

            ConnectionFactory connectionFactory = new ConnectionFactory(empresa + ".properties");
            Connection conn = connectionFactory.newConnection("finpac", "naoseid", ConnectionFactory.SetConnect.WITH_SCHEMA);
            if (!dao.exist(conn, new br.com.backSpringBoot.awesome.model.GcMaterial(), "cod_material", gcMaterial.getCodMaterial())) {
              (gcMaterial.getCodSitMaterial().equals("true")) ? gcMaterial.setCodSitMaterial("S") : gcMaterial.setCodSitMaterial("N");
                
                dao.save(conn, gcMaterial, Operation.INSERT);
                return new ResponseEntity<>("Material cadastrado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Material ja esta cadastrado", HttpStatus.OK);
            }

        } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(path = "")//esse metodo pode ser utilizado com o POST, pois se mandar o ID ele verifica antes se existe, se não exixtit ele cria se não faz um update
    public ResponseEntity<?> update(String empresa,
            String user,
            String senha,
            @Valid @RequestBody br.com.backSpringBoot.awesome.model.GcMaterial gcMaterial) {
        try {
            dao.setShowSQL(false);

            ConnectionFactory connectionFactory = new ConnectionFactory(empresa + ".properties");
            Connection conn = connectionFactory.newConnection("finpac", "naoseid", ConnectionFactory.SetConnect.WITH_SCHEMA);

            if (dao.exist(conn, new br.com.backSpringBoot.awesome.model.GcMaterial(), "cod_material", gcMaterial.getCodMaterial())) {
                dao.save(conn, gcMaterial, Operation.UPDATE);
                return new ResponseEntity<>("Material atualizado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Material não existe", HttpStatus.OK);
            }
        } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
   
    @DeleteMapping(path = "material/{codMaterial}")
    public ResponseEntity<?> delete(String empresa,
            String user,
            String senha,
            @PathVariable("codMaterial") String codMaterial) {
        try {
            dao.setShowSQL(false);

            ConnectionFactory connectionFactory = new ConnectionFactory(empresa + ".properties");
            Connection conn = connectionFactory.newConnection("finpac", "naoseid", ConnectionFactory.SetConnect.WITH_SCHEMA);
            System.out.println("AQUI DELETADO"+codMaterial);
            System.out.println(dao.exist(conn, new GcMaterial(), "cod_material", codMaterial));
            if (dao.exist(conn, new GcMaterial(), "cod_material", codMaterial)) {
                GcMaterial gcMaterial = new GcMaterial();
                gcMaterial.setCodMaterial(codMaterial);
                System.out.println("AQUI2222222");
                dao.save(conn, gcMaterial, Operation.DELETE);
                System.out.println("AQUI3333333333333");
                return new ResponseEntity<>("Material excluido com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Material não existe", HttpStatus.OK);
            }

        } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
