package Presentation.State;

import Domain.User;
import Presentation.ConsoleInterface;

public class NotLoggedInState implements IState{

    @Override
    public void handle(ConsoleInterface context) { //1.login 2.register
        System.out.println("\n----START MENU----");
        System.out.println("1. Login\n2. Register\n0. Quit");
        System.out.println("--------------------");
        String input = context.getScan().nextLine();

        switch (input){
            case "0":
                System.exit(0);

            case "1": //login
                System.out.print("Username: "); String username = context.getScan().nextLine();
                System.out.print("Password: "); String password = context.getScan().nextLine();

               try{
                   User user =  context.getFacade().login(username,password);
                   context.setCurrentUser(user);
                   context.setCurrentState(new LoggedInState());
                   return;
               }catch(IllegalArgumentException e){
                   System.out.println(e.toString()); return;
               }

            case "2": //register
                String firstName = "", lastName = "", roomNumberString = ""; int roomNumber = 0;
                System.out.print("Register as (Student/Personnel/Authorized Personnel): "); String userType = context.getScan().nextLine();
                System.out.print("Username: "); String usernameR = context.getScan().nextLine();
                System.out.print("Password: "); String passwordR = context.getScan().nextLine();
                if(userType.equalsIgnoreCase("student")){
                    System.out.print("First Name: "); firstName = context.getScan().nextLine();
                    System.out.print("Last Name: ");  lastName = context.getScan().nextLine();
                    System.out.print("Room Number: " ); roomNumberString = context.getScan().nextLine();
                    roomNumber = Integer.parseInt(roomNumberString);
                }
                String name = "", title0jobType = "";
                if(userType.equalsIgnoreCase("personnel")){
                    System.out.print("Name: "); name = context.getScan().nextLine();
                    System.out.print("Job Type: "); title0jobType = context.getScan().nextLine();
                }
                if(userType.equalsIgnoreCase("authorized personnel")){
                    System.out.print("Name: "); name = context.getScan().nextLine();
                    System.out.print("Title: "); title0jobType = context.getScan().nextLine();
                }

                if(userType.equalsIgnoreCase("student")){
                    try{
                        context.getFacade().register(userType, usernameR,passwordR,firstName,lastName,roomNumber);
                        System.out.println("Congratulations! You are registered."); return;
                    }catch(IllegalArgumentException e){
                        System.out.println(e.toString()); return;
                    }
                }
                else{
                    try{
                        context.getFacade().register(userType, usernameR,passwordR,name,title0jobType);
                        System.out.println("Congratulations! You are registered."); return;
                    }catch(IllegalArgumentException e){
                        System.out.println(e.toString()); return;
                    }
                }
            default:
                System.out.println("Invalid input."); return;
        }

    }
}
