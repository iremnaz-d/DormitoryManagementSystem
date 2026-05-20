package Application.Interfaces;

import Domain.User;
import java.util.Map;

public interface IUserRepository {

    void save(User user);

    void delete(String username);

    User findByUsername(String username);

    Map<String,User> findAll();

}
