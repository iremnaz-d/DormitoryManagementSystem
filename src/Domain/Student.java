package Domain;

import Application.Interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Student extends User implements IObserver {

    private String firstName;
    private String lastName;
    private int roomNumber;
    private List<Announcement> inbox;

    public Student(String username, String password, String role, String firstName, String lastName, int roomNumber){
        super(username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.inbox = new ArrayList<>();
    }

    public String getStudentDetails(){
        return "Student: " + firstName + " " + lastName + "    Room No: " + roomNumber;
    }

    public boolean isLegalRoomNumber(){
        int n = this.roomNumber;
        return (n>=100 && n<=118) || (n>=200 && n<=218) || (n>=300 && n<=318) || (n>=400 && n<=418) || (n>=500 && n<=518) || (n>=600 && n<=618);
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

    @Override
    public void update(Announcement announcement) {
        this.inbox.add(announcement);
    }
}
