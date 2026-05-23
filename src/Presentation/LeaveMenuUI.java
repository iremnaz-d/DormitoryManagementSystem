package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.AuthorizedPersonnel;
import Domain.LeaveRequest;
import Domain.Student;
import Domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LeaveMenuUI extends BaseMenuUI{

    public LeaveMenuUI(DormitoryFacade facade, Scanner scan, User currentUser) {
        super(facade, scan, currentUser);
    }

    @Override
    protected String getMenuTitle() {
        return "-----LEAVE REQUEST MENU-----";
    }

    @Override
    protected void showOptions() {
        if(this.currentUser instanceof Student){
            System.out.println("1. Submit a leave request");
            System.out.println("2. View your leave requests");
            System.out.println("3. Postpone end date for your current leave");
        }
        else if(this.currentUser instanceof AuthorizedPersonnel){
            System.out.println("1.Approve a leave request and parental consent");
        }
    }

    @Override
    protected boolean handleChoice(int choice) {
        switch (choice){
            case 1:
                if(this.currentUser instanceof AuthorizedPersonnel){ //Approve a leave request and parental consent
                    System.out.println("UNAPPROVED LEAVE REQUESTS");
                    List<LeaveRequest> unapprovedRequests = this.facade.getUnapprovedRequests();
                    for(LeaveRequest request: unapprovedRequests){
                        System.out.println(request.getLeaveRequestDetailsShort());
                    }

                    System.out.print("Enter student name to approve leave request: "); String namesurname = this.scan.nextLine();
                    String[] str = namesurname.split(" ");
                    Student student = this.facade.findStudentByNameSurname(str[0], str[1]);
                    if(student == null){
                        System.out.println("Invalid student name or surname."); return true;
                    }
                    this.facade.verifyParentalConsentAndApproveRequest(student);
                    System.out.println("Leave request approved.");
                    return true;
                }
                else if(this.currentUser instanceof Student student){// Submit a leave request
                    LocalDate startDate, endDate;
                    while(true) {
                        System.out.print("Enter start date (dd.MM.yyyy): ");
                        String startDateString = this.scan.nextLine();
                        try {
                            startDate = this.facade.parseLocalDate(startDateString);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.toString());
                        }
                    }
                    while(true){
                        System.out.print("Enter end date (dd.MM.yyyy): "); String endDateString = this.scan.nextLine();
                        try{
                            endDate = this.facade.parseLocalDate(endDateString); break;
                        }catch(IllegalArgumentException e){
                            System.out.println(e.toString());
                        }
                    }
                    this.facade.submitLeaveRequest(student, startDate,endDate);
                    System.out.println("Leave request has successfully submitted. Admin will approve your request when your parent forwards approval message");
                    return true;
                }
            case 2: //View your leave requests
                if(this.currentUser instanceof Student student){
                    List<LeaveRequest> requests = this.facade.getRequestsByStudent(student);
                    for (LeaveRequest request: requests){
                        System.out.print(request.getLeaveRequestDetailsLong());
                    }
                }
                else{
                    System.out.println("Invalid input.");
                }
                return true;
            case 3: //Postpone end date for your current leave
                if(this.currentUser instanceof Student student){
                    List<LeaveRequest> requests = this.facade.getRequestsByStudent(student);
                    LeaveRequest requestToPostpone = null;
                    for (LeaveRequest request: requests){
                        if(request.getEndDate().isAfter(LocalDate.now())){
                            requestToPostpone = request;
                        }
                    }
                    if(requestToPostpone == null){
                        System.out.println("You don't have any currently active request to postpone."); return true;
                    }

                    LocalDate endDate;
                    System.out.print("Enter new end date (dd.MM.yyyy): "); String endDateString = this.scan.nextLine();
                    try{
                        endDate = this.facade.parseLocalDate(endDateString);
                    }catch(IllegalArgumentException e){
                        System.out.println(e.toString()); return true;
                    }

                    System.out.print(this.facade.postponeEndDate(student, endDate));
                    return true;
                }
                else{
                    System.out.println("Invalid input."); return true;
                }
            default:
                System.out.println("Invalid input."); return true;
        }
    }
}
