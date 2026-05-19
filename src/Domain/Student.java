package Domain;

public class Student extends User {

    private String firstName;
    private String lastName;
    private int roomNumber;

    public Student(String username, String password, String role, String firstName, String lastName, int roomNumber){
        super(username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
    }

    public String getStudentDetails(){
        return "Student: " + firstName + " " + lastName + "    Room No: " + roomNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
