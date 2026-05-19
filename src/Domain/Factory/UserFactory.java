package Domain.Factory;
import Domain.User;
import Domain.Student;
import Domain.Personnel;
import Domain.AuthorizedPersonnel;

public class UserFactory {

    //nesnesini oluşturmadan kullanabilmek için static
    public static User createUser(String userType, String username, String password, String firstName, String lastName, int roomNumber){

       if(userType.equalsIgnoreCase("student")){
           return new Student(username, password, "Student", firstName, lastName, roomNumber);
       }
       else{
           throw new IllegalArgumentException("Unknown User Type: " + userType);
       }
    }

    public static User createUser(String userType, String username, String password, String name, String title0jobtype){
        switch (userType.toLowerCase()){
            case "personnel":
                return new Personnel(username, password, "Personnel", name, title0jobtype);

            case "admin":
                return new AuthorizedPersonnel(username,password,"Admin", name, title0jobtype);

            default:
                throw new IllegalArgumentException("Unknown User Type: " + userType);
        }
    }
}
