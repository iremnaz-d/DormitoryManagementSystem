package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.AuthorizedPersonnel;
import Domain.User;

import java.time.DayOfWeek;
import java.time.LocalTime;
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
        System.out.println("1. View weekly shuttle schedule");

        if(this.currentUser instanceof AuthorizedPersonnel){
            System.out.println("2. Generate shuttle schedule");
        }
    }

    @Override
    protected boolean handleChoice(String choice) {
        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek tuesday = DayOfWeek.TUESDAY;
        DayOfWeek wednesday = DayOfWeek.WEDNESDAY;
        DayOfWeek thursday = DayOfWeek.THURSDAY;
        DayOfWeek friday = DayOfWeek.FRIDAY;

        switch (choice){
            case "1":
                System.out.printf("%-10s : %-10s : %-10s : %-10s : %-10s\n",
                        monday.toString(), tuesday.toString(), wednesday.toString(), thursday.toString(), friday.toString());
                for (int i = 1; i <= 5; i++){
                    LocalTime time1 = this.facade.getWantedSessionforWantedDay(monday,i);
                    LocalTime time2 = this.facade.getWantedSessionforWantedDay(tuesday,i);
                    LocalTime time3 = this.facade.getWantedSessionforWantedDay(wednesday,i);
                    LocalTime time4 = this.facade.getWantedSessionforWantedDay(thursday,i);
                    LocalTime time5 = this.facade.getWantedSessionforWantedDay(friday,i);
                    if(time1 == null){
                        System.out.println("There is no published shuttle schedule yet."); return true;
                    }
                    System.out.printf("%-10s : %-10s : %-10s : %-10s : %-10s\n",
                            time1.toString(), time2.toString(), time3.toString(), time4.toString(),time5.toString());
                } return true;

            case "2":
                if(this.currentUser instanceof AuthorizedPersonnel){
                    for (int i = 1; i <= 5; i++){
                        this.facade.generateTimeTable(DayOfWeek.of(i));
                    }
                    System.out.println("Shuttle schedule is successfully generated based on students' school schedules.");
                }else{
                    System.out.println("Invalid input.");
                }return true;

            default:
                System.out.println("Invalid input."); return true;
        }
    }
}
