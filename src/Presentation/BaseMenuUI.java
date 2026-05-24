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

    protected abstract boolean handleChoice(String choice);

    public final void display(){
        boolean running = true;
        while(running){
            System.out.println(this.getMenuTitle());
            this.showOptions();
            System.out.println("0. Return\n-------------------------");
            String input = scan.nextLine();
            if(input.equals("0"))
                running = false;
            else
                handleChoice(input);
        }
    }

}
