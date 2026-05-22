package Application;

import Application.Interfaces.IUserRepository;
import Domain.AuthorizedPersonnel;
import Domain.Factory.UserFactory;
import Domain.Personnel;
import Domain.Student;
import Domain.User;
import Infrastructure.UserRepository;

public class AuthService {

    private IUserRepository repository;

    public AuthService(){
        this.repository = UserRepository.getInstance();
    }

    public User login(String username, String password){
        User user = this.repository.findByUsername(username);
        if(user == null){
            throw new IllegalArgumentException("Username not found.");
        }

        if(!user.verifyPassword(password)){
            throw new IllegalArgumentException("Password is incorrect.");
        }
        return user;
    }

    public boolean register(String userType, String username, String password, String firstName, String lastName, int roomNumber){
        //Student
       User user = UserFactory.createUser(userType, username,password,firstName,lastName,roomNumber);
       if(!user.isLegalPassword()){
           throw new IllegalArgumentException("Password should include at least 1 uppercase character and at least 1 digit. (7-20)");
       }
       if(!user.isLegalUsername()){
           throw new IllegalArgumentException("Username must be 5-20 character length.");
       }

       if(user instanceof Student){
           Student student = (Student) user; //Type Casting
           if(!student.isLegalRoomNumber()){
               throw new IllegalArgumentException("Room number invalid.");
           }
           this.repository.save(student);
           return true;
       }
       return false;
    }

    public boolean register(String userType, String username, String password, String name, String title0jobType){
        User user = UserFactory.createUser(userType,username,password,name,title0jobType);
        if(!user.isLegalPassword()){
            throw new IllegalArgumentException("Password should include at least 1 uppercase character and at least 1 digit. (7-20)");
        }
        if(!user.isLegalUsername()){
            throw new IllegalArgumentException("Username must be 5-20 character length.");
        }

        if(user instanceof Personnel){
            Personnel personnel = (Personnel) user;
            this.repository.save(personnel);
            return true;
        }
        else if(user instanceof AuthorizedPersonnel){
            AuthorizedPersonnel authorizedPersonnel = (AuthorizedPersonnel) user;
            this.repository.save(authorizedPersonnel);
            return true;
        }
        return false;
    }
}
