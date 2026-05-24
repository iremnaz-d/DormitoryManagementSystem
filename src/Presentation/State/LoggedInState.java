package Presentation.State;

import Domain.AuthorizedPersonnel;
import Domain.Personnel;
import Domain.Student;
import Presentation.*;

public class LoggedInState implements IState{

    @Override
    public void handle(ConsoleInterface context) {//main menu

       if(context.getCurrentUser() instanceof Student){
           System.out.println("-------STUDENT MENU-------");
           System.out.println("1. Meal Menu");
           System.out.println("2. Meal Evaluation Menu");
           System.out.println("3. Laundry Menu");
           System.out.println("4. Announcement Menu");
           System.out.println("5. Leave Request Menu");
           System.out.println("6. Shuttle Menu");
           System.out.println("0. Logout");
           System.out.println("---------------------------");
       }
       else if(context.getCurrentUser() instanceof Personnel){
           System.out.println("-----PERSONNEL MENU-----");
           System.out.println("1. Meal Menu");
           System.out.println("2. Announcement Menu");
           System.out.println("3. Shuttle Menu");
           System.out.println("4. Personnel Task Menu");
           System.out.println("0. Logout");
           System.out.println("------------------------");

       }
       else if(context.getCurrentUser() instanceof AuthorizedPersonnel){
           System.out.println("-----AUTHORIZED PERSONNEL MENU-----");
           System.out.println("1. Meal Menu");
           System.out.println("2. Meal Evaluation Menu");
           System.out.println("3. Announcement Menu");
           System.out.println("4. Leave Request Menu");
           System.out.println("5. Shuttle Menu");
           System.out.println("6. Personnel Task Menu");
           System.out.println("0. Logout");
           System.out.println("-----------------------------------");
       }

       String choice = context.getScan().nextLine();
       if(choice.equals("0")){ //logout
           context.setCurrentUser(null);
           context.setCurrentState(new NotLoggedInState());
           return;
       }

       if(context.getCurrentUser() instanceof Student){
           switch (choice){
               case "1":
                   DiningMenuUI mealMenu = new DiningMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                   mealMenu.display(); return;
               case "3":
                   LaundryMenuUI laundryMenu = new LaundryMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                   laundryMenu.display(); return;
               case "4":
                   AnnouncementMenuUI announcementMenuUI = new AnnouncementMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                   announcementMenuUI.display(); return;
               case "5":
                   LeaveMenuUI leaveMenu = new LeaveMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                   leaveMenu.display(); return;
               case "6":
                   ShuttleMenuUI shuttleMenu = new ShuttleMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                   shuttleMenu.display(); return;
               default:
                   System.out.println("Invalid input."); return;
           }
       }

        if(context.getCurrentUser() instanceof Personnel){
            switch(choice){
                case "1":
                    DiningMenuUI mealMenu = new DiningMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    mealMenu.display(); return;
                case "2":
                    AnnouncementMenuUI announcementMenuUI = new AnnouncementMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    announcementMenuUI.display(); return;
                case "3":
                    ShuttleMenuUI shuttleMenu = new ShuttleMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    shuttleMenu.display(); return;
                case "4":
                    StaffMenuUI staffMenu = new StaffMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    staffMenu.display(); return;
            }
        }

        if(context.getCurrentUser() instanceof AuthorizedPersonnel){
            switch (choice){
                case "1":
                    DiningMenuUI mealMenu = new DiningMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    mealMenu.display(); return;
                case "3":
                    AnnouncementMenuUI announcementMenuUI = new AnnouncementMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    announcementMenuUI.display(); return;
                case "4":
                    LeaveMenuUI leaveMenu = new LeaveMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    leaveMenu.display(); return;
                case "5":
                    ShuttleMenuUI shuttleMenu = new ShuttleMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    shuttleMenu.display(); return;
                case "6":
                    StaffMenuUI staffMenu = new StaffMenuUI(context.getFacade(), context.getScan(), context.getCurrentUser());
                    staffMenu.display(); return;
            }
        }




    }
}
