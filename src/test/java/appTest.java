
import app.entities.UserEntity;
import app.repositories.UserRepository;
import org.junit.Test;

/**
 *
 * @author Eliezer
 */

//@Ignore
public class appTest {
    @Test
    
    public void saveUser(){
        UserEntity user = new UserEntity("teste appTeste","appteste@teste.com");
        UserRepository repo = new UserRepository();
        
        try{
            repo.save(user);
            System.out.println("salvou com sucesso");
        }catch(Exception e){
            System.out.println("erro ao salvar");
    }
    }
    
}
