package Application;

import Application.Interfaces.IUserRepository;
import Infrastructure.UserRepository;

public class AuthService {

    private IUserRepository repository;

    public AuthService(){
        this.repository = UserRepository.getInstance();
    }

   /* public boolean login(String username, String password){

    }

    public boolean register(String use)*/
}
