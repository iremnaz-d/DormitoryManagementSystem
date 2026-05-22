package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.User;
import java.util.Scanner;

public abstract class BaseMenuUI {

    protected Scanner scan;
    protected DormitoryFacade facade;
    protected User currentUser;

    public BaseMenuUI(DormitoryFacade facade, Scanner scan, User currentUser){
        this.scan = new Scanner(System.in);
        this.facade = new DormitoryFacade();
        this.currentUser = currentUser;
    }

    protected abstract String getMenuTitle();

    protected abstract void showOptions();

    protected abstract boolean handleChoice(int choice);

    public final void display(){
        boolean running = true;
        while(running){
            this.getMenuTitle();
            this.showOptions();
            System.out.println("0. Return\n-------------------------");
            int input = scan.nextInt();
            if(input == 0)
                running = false;
            else
                handleChoice(input);
        }
    }

}
