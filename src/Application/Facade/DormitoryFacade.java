package Application.Facade;

import Application.*;

public class DormitoryFacade {

    private AnnouncementService announcementService;
    private AuthService authService;
    private DiningService diningService;
    private LaundryService laundryService;
    private LeaveService leaveService;
    private  ShuttleService shuttleService;
    private StaffOperationsService staffOperationsService;

    public DormitoryFacade(){
        this.announcementService = new AnnouncementService();
        this.authService = new AuthService();
        this.diningService = new DiningService();
        this.laundryService = new LaundryService();
        this.shuttleService = new ShuttleService();
        this.leaveService = new LeaveService();
        this.staffOperationsService = new StaffOperationsService();
    }


}
