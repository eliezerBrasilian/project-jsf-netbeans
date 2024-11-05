
import app.entities.UserEntity;
import app.repositories.UserRepository;
import java.util.List;
import org.junit.*;

public class TestJpa {

    @Ignore
    @Test
    public void saveUser() {
        UserEntity user = new UserEntity("teste", "teste@teste.com");
        UserRepository userRepository = new UserRepository();

        try {
            userRepository.save(user);
            System.out.println("TestJpa.saveUser()");
        } catch (Exception e) {
            System.err.println("Erro salvar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void findById() {
        UserRepository userRepository = new UserRepository();

        try{
            UserEntity user = userRepository.findById(2L);
             System.out.println("nome do usuario encontrado: " + user.getName());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //@Ignore
    @Test
    public void findAll() {
        UserRepository userRepository = new UserRepository();

        try{
             List<UserEntity> list = userRepository.findAll();
             list.forEach(i->System.out.println("name: " + i.getName() + ", id: " + i.getId()));
             
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void updateUser() {
        UserRepository userRepository = new UserRepository();
        UserEntity user = userRepository.findById(16);
        user.setName("Marc");

        userRepository.update(user);
    }
    
    //@Ignore
    @Test
    public void deleteById() {
        UserRepository userRepository = new UserRepository();

        try{
             userRepository.deleteById(1L);
             System.out.println("deleted successfully");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //@Ignore
    @Test
    public void deleteAll() {
        UserRepository userRepository = new UserRepository();

        try{
            userRepository.deleteAll();
            System.out.println("deleted all rows successfully");
             
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
