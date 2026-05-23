package Infrastructure;

import Application.Interfaces.IUserRepository;
import Domain.AuthorizedPersonnel;
import Domain.Personnel;
import Domain.Student;
import Domain.User;

import java.util.*;

public class UserRepository implements IUserRepository {

    private static UserRepository instance;
    private Map<String, User> userMap; //username, User

    private UserRepository(){
        this.userMap = new HashMap<>();
    }

    public static UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }


    @Override
    public void save(User user) {
        this.userMap.put(user.getUsername(), user);
    }

    @Override
    public void delete(String username) {
        this.userMap.remove(username);
    }

    @Override
    public User findByUsername(String username) {
        return this.userMap.get(username);
    }

    @Override
    public Map<String, User> findAll() {
        return this.userMap;
    }

    @Override
    public List<User> getAllUserType(String userType) {
        List<User> list = new ArrayList<>();
        Iterator<User> it = this.userMap.values().iterator();
        User user;
        switch (userType.toLowerCase()){
            case "personnel":
                while(it.hasNext()){
                    user = it.next();
                    if(user instanceof Personnel personnel)
                        list.add(personnel);
                }return list;
            case "student":
                while(it.hasNext()){
                    user = it.next();
                    if(user instanceof Student student)
                        list.add(student);
                }return list;
            case "authorized personnel":
                while(it.hasNext()){
                    user = it.next();
                    if(user instanceof AuthorizedPersonnel authorizedPersonnel)
                        list.add(authorizedPersonnel);
                }return list;
            default:
                return null;
        }
    }

    @Override
    public Student findStudentByNameSurname(String firstName, String lastName) {
        List<User> students = this.getAllUserType("student");
        for (User student: students){
            if(((Student)student).getFirstName().equalsIgnoreCase(firstName) && ((Student)student).getLastName().equalsIgnoreCase(lastName)){
                return (Student) student;
            }
        }
        return null;
    }


}
