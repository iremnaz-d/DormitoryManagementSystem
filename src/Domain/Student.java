package Domain;

public class Student extends User {

    private String firstName;
    private String lastName;
    private int roomNumber;
    private boolean isFasting;

    public Student(String username, String password, String role, String firstName, String lastName, int roomNumber, boolean isFasting){
        super(username, password, role);
        this.firstName = firstname;

    }



}
