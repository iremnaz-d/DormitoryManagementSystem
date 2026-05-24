package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.Student;
import Domain.User;
import java.util.Scanner;

public class LaundryMenuUI extends BaseMenuUI{
    public LaundryMenuUI(DormitoryFacade facade, Scanner scan, User currentUser) {
        super(facade, scan, currentUser);
    }

    @Override
    protected String getMenuTitle() {
        return "------LAUNDRY MENU------";
    }

    @Override
    protected void showOptions() {
        if(this.currentUser instanceof Student)
        System.out.println("1. Book a laundry machine");
    }

    @Override
    protected boolean handleChoice(String choice) {
        switch (choice){
            case "1":
                if(this.currentUser instanceof Student student) {
                    System.out.print("Enter floor number (1-6): "); String floorString = this.scan.nextLine();
                    int floor = Integer.parseInt(floorString);
                    if(floor<1 || floor>6) {
                        System.out.println("\nInvalid floor number. (1-6)");
                        return true;
                    }
                    System.out.println(this.facade.bookMachine(student,floor));
                }return true;
            default:
                System.out.println("Invalid option."); return true;
        }
    }
}
