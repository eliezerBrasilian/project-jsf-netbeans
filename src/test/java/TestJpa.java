
import app.entities.UserEntity;
import app.repositories.UserRepository;
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

    //@Ignore
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

    @Ignore
    @Test
    public void updateUser() {
        UserRepository userRepository = new UserRepository();
        UserEntity user = userRepository.findById(16);
        user.setName("Marc");

        userRepository.update(user);
    }
}
