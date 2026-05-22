package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.User;

import java.util.Scanner;

public class ShuttleMenuUI extends BaseMenuUI{
    public ShuttleMenuUI(DormitoryFacade facade, Scanner scan, User currentUser) {
        super(facade, scan, currentUser);
    }

    @Override
    protected String getMenuTitle() {
        return "-----SHUTTLE MENU-----";
    }

    @Override
    protected void showOptions() {
        //1. view weekly schedule
        //2. publish shuttle schedule

    }

    @Override
    protected boolean handleChoice(int choice) {
        return false;
    }
}
