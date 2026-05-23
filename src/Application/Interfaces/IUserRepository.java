package Application.Interfaces;

import Domain.Student;
import Domain.User;

import java.util.List;
import java.util.Map;

public interface IUserRepository {

    void save(User user);

    void delete(String username);

    User findByUsername(String username);

    Map<String,User> findAll();

    List<User> getAllUserType(String userType);

    Student findStudentByNameSurname(String firstName, String lastName);

}
