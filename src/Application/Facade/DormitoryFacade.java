package Application.Facade;

import Application.*;
import Domain.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DormitoryFacade {

    private AnnouncementService announcementService;
    private AuthService authService;
    private DiningService diningService;
    private LaundryService laundryService;
    private LeaveService leaveService;
    private  ShuttleService shuttleService;
    private StaffOperationsService staffOperationsService;
    private EvaluationService evaluationService;

    public DormitoryFacade(){ //Bootstrapping (ayağa kaldırma)
        this.announcementService = new AnnouncementService();
        this.authService = new AuthService();
        this.diningService = new DiningService();
        this.laundryService = new LaundryService();
        this.shuttleService = new ShuttleService();
        this.leaveService = new LeaveService();
        this.staffOperationsService = new StaffOperationsService();
        this.evaluationService = new EvaluationService();
    }

    public void publishAnnouncement(String title, String content){
        this.announcementService.publishAnnouncement(title, content);
    }

    public List<Announcement> getAnnouncementList(){
        return this.announcementService.getAnnouncementList();
    }

    public User login(String username, String password){
        return this.authService.login(username,password);
    }

    public boolean register(String userType, String username, String password, String firstName, String lastName, int roomNumber){
        return this.authService.register(userType,username,password,firstName,lastName,roomNumber);
    }

    public boolean register(String userType, String username, String password, String name, String title0jobType){
        return this.authService.register(userType,username,password,name, title0jobType);
    }

    public boolean publishMenu(LocalDate date, String [] items){
        return this.diningService.publishMenu(date,items);
    }

    public MealMenu getMenuByDate(LocalDate date){
        return this.diningService.getMenuByDate(date);
    }

    public boolean submitLeaveRequest(Student student, LocalDate startDate, LocalDate endDate){
        return this.leaveService.submitLeaveRequest(student, startDate,endDate);
    }

    public boolean verifyParentalConsentAndApproveRequest(Student student){
        return this.leaveService.verifyParentalConsentAndApproveRequest(student);
    }

    public String postponeEndDate(Student student, LocalDate date){
        return this.leaveService.postponeEndDate(student,date);
    }

    public boolean generateTimeTable(DayOfWeek day){
        return this.shuttleService.generateTimeTable(day);
    }

    private void publishSchedule(ShuttleSchedule schedule){
        this.shuttleService.publishSchedule(schedule);
    }

    public boolean assignTask(Personnel personnel, String taskName, LocalDateTime dateTime, String location){
        return this.staffOperationsService.assignTask(personnel,taskName,dateTime,location);
    }

    public boolean addDescriptionToTask(TaskAssignment task, String description){
        return this.staffOperationsService.addDescriptionToTask(task,description);
    }

    public List<TaskAssignment> getTasksForPersonnel(Personnel personnel){
        return this.staffOperationsService.getTasksForPersonnel(personnel);
    }

    public boolean submitEvaluation(String day, int score, String comment){
        return this.evaluationService.submitEvaluation(day,score,comment);
    }

    public double calculateAverageRating(LocalDate date){
        return this.evaluationService.calculateAverageRating(date);
    }

    public String bookMachine(Student student, int floor){
        return this.laundryService.bookMachine(student,floor);
    }
}
