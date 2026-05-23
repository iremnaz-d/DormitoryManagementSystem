package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.AuthorizedPersonnel;
import Domain.Personnel;
import Domain.TaskAssignment;
import Domain.User;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;

public class StaffMenuUI extends  BaseMenuUI{
    public StaffMenuUI(DormitoryFacade facade, Scanner scan, User currentUser) {
        super(facade, scan, currentUser);
    }

    @Override
    protected String getMenuTitle() {
        return "-----STAFF OPERATIONS MENU-----";
    }

    @Override
    protected void showOptions() {
        if(this.currentUser instanceof Personnel || this.currentUser instanceof AuthorizedPersonnel)
        System.out.println("1. View personnel schedules");

        if(this.currentUser instanceof AuthorizedPersonnel)
            System.out.println("2. Assign task for a personnel");

        if(this.currentUser instanceof Personnel)
            System.out.println("2. See your assigned tasks");
    }

    @Override
    protected boolean handleChoice(int choice) {
        switch (choice){
            case 1: // View personnel schedules
                Set<TaskAssignment> allTasks = this.facade.getAllTasks();
                Iterator<TaskAssignment> it = allTasks.iterator();
                System.out.print(it.next().getTaskDetails());
                return true;
            case 2:
                if(this.currentUser instanceof Personnel personnel){ // See your assigned tasks
                    List<TaskAssignment> tasks = this.facade.getTasksForPersonnel(personnel);
                    for (TaskAssignment task: tasks){
                        System.out.print(task.getTaskDetails());
                    }
                    return true;
                }
                else if(this.currentUser instanceof AuthorizedPersonnel){//Assign task for a personnel
                    List<User> personnelList = this.facade.getAllUserType("personnel");
                    Map<String, Personnel> personnelMap = new HashMap<>();
                    System.out.println("PERSONNEL LIST");
                    for (User personnel: personnelList){
                        System.out.println(((Personnel) personnel).getName());
                        personnelMap.put(((Personnel) personnel).getName(),(Personnel) personnel);
                    }
                    System.out.print("Enter a personnel name to assign task: "); String name = this.scan.nextLine();
                    if(!personnelMap.containsKey(name)){
                        System.out.println("Personnel name is invalid."); return true;
                    }

                    System.out.print("\nEnter task date (dd.MM-HH): ");  String s = this.scan.nextLine();
                    LocalDateTime taskDateTime = null;
                    try {
                        // Builder kullanarak formattaki eksik parçaları (Yıl ve Dakika) varsayılan değerlerle dolduruyoruz
                        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                .appendPattern("dd.MM-HH")
                                .parseDefaulting(ChronoField.YEAR, LocalDate.now().getYear()) // Yılı otomatik ekle
                                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)               // Dakikayı 00 kabul et
                                .toFormatter();

                        taskDateTime = LocalDateTime.parse(s, formatter);

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date input. (ex: 23.05-16)"); return true;
                    }

                    System.out.print("\nEnter task name: "); String taskName = this.scan.nextLine();
                    System.out.print("\nEnter task location: "); String taskLocation = this.scan.nextLine();

                    TaskAssignment newTask = this.facade.assignTask(personnelMap.get(name),taskName,taskDateTime,taskLocation);
                    System.out.print("Task is assigned successfully.");

                    while(true){
                        System.out.print("\nDo you want to add description? (y/n)"); String yesno = this.scan.nextLine();
                        if(yesno.equalsIgnoreCase("y")){
                            System.out.print("\nEnter task description: "); String taskDescription = this.scan.nextLine();
                            this.facade.addDescriptionToTask(newTask, taskDescription);
                            System.out.println("Task description added successfully.");
                            break;
                        }
                        else if(yesno.equalsIgnoreCase("n")){
                            return true;
                        }
                        else{
                            System.out.print("\nInvalid input. (y/n)\n");
                        }
                    }
                    return true;
                }
            default:
                System.out.println("Invalid input."); return true;
        }
    }
}
