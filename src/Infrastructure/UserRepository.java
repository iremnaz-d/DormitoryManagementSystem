package Infrastructure;

import Application.Interfaces.IUserRepository;
import Domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository implements IUserRepository {

    private static UserRepository instance;
    private Map<String, User> userMap;

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
}
