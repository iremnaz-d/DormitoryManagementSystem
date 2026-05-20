package Infrastructure;

import Application.Interfaces.ILaundryRepository;
import Domain.LaundryReservation;
import Domain.Student;
import java.util.ArrayList;
import java.util.List;

public class LaundryRepository implements ILaundryRepository {

    private static LaundryRepository instance;
    private List<LaundryReservation> reservationList;

    private LaundryRepository(){
        this.reservationList = new ArrayList<>();
    }

    public static LaundryRepository getInstance(){
       if(instance == null){ //yoksa yenisini oluşturur
           instance = new LaundryRepository();
       }
       return instance; //varsa olanı gönderir
    }

    @Override
    public void save(LaundryReservation reservation) {
        this.reservationList.add(reservation);
    }

    @Override
    public void delete(LaundryReservation reservation) {
        this.reservationList.remove(reservation);
    }

    @Override
    public List<LaundryReservation> findAll() {
        return this.reservationList;
    }

    @Override
    public LaundryReservation findByStudent(Student student) {
        for (LaundryReservation i: reservationList){
            if(i.getStudent().getUsername().equals(student.getUsername()))
                return i;
        }
        return null;
    }

    @Override
    public int findTakenMachinesByFloor(int floor) {
        int counter = 0;
        for (LaundryReservation i: reservationList){
            if(i.getFloor() == floor && i.getMachineStatus().equals("Taken")) {
                counter++;
            }
        }
        return counter;
    }
}
