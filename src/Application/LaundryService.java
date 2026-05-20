package Application;

import Application.Interfaces.ILaundryRepository;
import Domain.LaundryReservation;
import Domain.Student;
import Infrastructure.LaundryRepository;
import Infrastructure.UserRepository;

public class LaundryService {

    private ILaundryRepository repository;

    public LaundryService(){
        this.repository = LaundryRepository.getInstance();
    }

    public String bookMachine(Student student, int floor){

        if(checkAvailability(floor) <= 0){
            return "There is not any available machine in " + floor + "th floor.";
        }

        LaundryReservation reservation = new LaundryReservation.LaundryReservationBuilder()
                .withFloor(floor)
                .withIsKeyReturned(false)
                .withIsPaid(false)
                .withStudent(student)
                .withMachineStatus("Taken")
                .build();

        this.repository.save(reservation);
        return "Machine reservation is completed successfully.";
    }

    public int checkAvailability(int floor){ //aratılan katta kaç makinenin müsait olduğu bilgisi gider
        int count = this.repository.findTakenMachinesByFloor(floor);
        return 2-count;
    }

}
