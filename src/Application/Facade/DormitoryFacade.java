package Application.Facade;

import Application.*;
import Domain.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

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
        if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("personnel") || userType.equalsIgnoreCase("authorized personnel") )
        return this.authService.register(userType,username,password,firstName,lastName,roomNumber);
        else{
            throw new IllegalArgumentException("User type is invalid. (Student / Personnel / Authorized Personnel)");
        }
    }

    public boolean register(String userType, String username, String password, String name, String title0jobType){
        if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("personnel") || userType.equalsIgnoreCase("authorized personnel") )
            return this.authService.register(userType,username,password,name, title0jobType);
        else{
            throw new IllegalArgumentException("User type is invalid. (Student / Personnel / Authorized Personnel)");
        }
    }

    public Student findStudentByNameSurname(String firstName, String lastName){
        return this.authService.findStudentByNameSurname(firstName,lastName);
    }

    public List<User> getAllUserType(String userType){
        return this.authService.getAllUserType(userType);
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

    public List<LeaveRequest> getUnapprovedRequests(){
        return this.leaveService.getUnapprovedRequests();
    }

    public List<LeaveRequest> getRequestsByStudent(Student student){
        return this.leaveService.getRequestsByStudent(student);
    }

    public List<LeaveRequest> getAllRequests(){
        return this.leaveService.getAllRequests();
    }

    public boolean generateTimeTable(DayOfWeek day){
        return this.shuttleService.generateTimeTable(day);
    }

    public LocalTime getWantedSessionforWantedDay(DayOfWeek day, int session){
        return this.shuttleService.getWantedSessionforWantedDay(day, session);
    }

    public TaskAssignment assignTask(Personnel personnel, String taskName, LocalDateTime dateTime, String location){
        return this.staffOperationsService.assignTask(personnel,taskName,dateTime,location);
    }

    public boolean addDescriptionToTask(TaskAssignment task, String description){
        return this.staffOperationsService.addDescriptionToTask(task,description);
    }

    public List<TaskAssignment> getTasksForPersonnel(Personnel personnel){
        return this.staffOperationsService.getTasksForPersonnel(personnel);
    }

    public Set<TaskAssignment> getAllTasks(){
        return this.staffOperationsService.getAllTasks();
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

    //Besides Services

    public LocalDate parseLocalDate(String localDateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(localDateString, formatter);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal date format. (dd.MM.yyyy)");
        }
    }
}
