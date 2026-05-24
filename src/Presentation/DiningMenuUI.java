package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.AuthorizedPersonnel;
import Domain.MealMenu;
import Domain.User;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DiningMenuUI extends BaseMenuUI{


    public DiningMenuUI(DormitoryFacade facade, Scanner scan, User currentUser) {
        super(facade, scan, currentUser);
    }

    @Override
    protected String getMenuTitle() {
        return "-------DINING MENU-------";
    }

    @Override
    protected void showOptions() {
        System.out.println("1. See meal menu");

        if(this.currentUser instanceof AuthorizedPersonnel)
            System.out.println("2. Publish meal menu");
    }

    @Override
    protected boolean handleChoice(String choice) {
        LocalDate menuDate = null;
        switch (choice){
            case "1": //see meal menu
                System.out.print("Enter menu date (DD.MM) "); String s1 = this.scan.nextLine();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
                    MonthDay parsedMonthDay = MonthDay.parse(s1, formatter);
                    int currentYear = LocalDate.now().getYear();
                    menuDate = parsedMonthDay.atYear(currentYear);

                    MealMenu menu = this.facade.getMenuByDate(menuDate);
                    if(menu == null){
                        System.out.println("There is not any published meal menu in this date.");
                        return true;
                    }
                    System.out.println(menu.getMenuDetails());
                    return true;
                } catch (DateTimeParseException e) {
                    System.out.println("Incorrect date input. (DD.MM)"); return true;
                }
            case "2": //publish meal menu
                if(this.currentUser instanceof AuthorizedPersonnel){
                    System.out.print("Enter menu date (DD.MM) "); String s2 = this.scan.nextLine();
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
                        MonthDay parsedMonthDay = MonthDay.parse(s2, formatter);
                        int currentYear = LocalDate.now().getYear();
                        menuDate = parsedMonthDay.atYear(currentYear);
                    } catch (DateTimeParseException e) {
                        System.out.println("Incorrect date input. (DD.MM)"); return true;
                    }
                    System.out.print("Enter items (tantuni,ayran...)"); String s3 = this.scan.nextLine();
                    if (s3 == null || s3.trim().isEmpty()) {
                        System.out.println("Menu can not be empty."); return true;
                    }

                    String[] rawItems = s3.split(",");
                    String[] cleanItems = new String[rawItems.length];
                    for (int i = 0; i < rawItems.length; i++) {
                        cleanItems[i] = rawItems[i].trim();
                    }

                    this.facade.publishMenu(menuDate,cleanItems);
                    System.out.println("Menu is created successfully.");
                }else {
                    System.out.println("Option '2' is invalid.");
                } return true;
            default:
                System.out.println("Invalid option."); return true;
        }

    }
}
