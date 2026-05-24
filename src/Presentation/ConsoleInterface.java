package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.User;
import Presentation.State.IState;
import Presentation.State.NotLoggedInState;

import java.util.Scanner;

public class ConsoleInterface {

    private DormitoryFacade facade;
    private Scanner scan;
    private User currentUser;
    private IState currentState;

    public ConsoleInterface(){
        this.facade = new DormitoryFacade();
        this.scan = new Scanner(System.in);
        this.currentState = new NotLoggedInState();
        this.currentUser = null;
    }

    public void start(){
        while(true){
            this.currentState.handle(this);
        }
    }



    public DormitoryFacade getFacade() {
        return facade;
    }

    public void setFacade(DormitoryFacade facade) {
        this.facade = facade;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public IState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }
}
