package Application.Interfaces;

import Domain.LaundryReservation;
import Domain.Student;
import java.util.List;

public interface ILaundryRepository {

    void save(LaundryReservation reservation);

    void delete(LaundryReservation reservation);

    List<LaundryReservation> findAll();

    LaundryReservation findByStudent(Student student);

    int findTakenMachinesByFloor(int floor);
}
