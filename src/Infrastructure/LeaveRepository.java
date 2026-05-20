package Infrastructure;

import Application.Interfaces.ILeaveRepository;
import Domain.LeaveRequest;
import Domain.Student;

import java.util.ArrayList;
import java.util.List;

public class LeaveRepository implements ILeaveRepository {

    private static LeaveRepository instance;
    private List<LeaveRequest> leaveRequests;

    private LeaveRepository(){
        this.leaveRequests = new ArrayList<>();
    }

    public static LeaveRepository getInstance(){
        if(instance == null){
            instance = new LeaveRepository();
        }
        return instance;
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        this.leaveRequests.add(leaveRequest);
    }

    @Override
    public void delete(LeaveRequest leaveRequest) {
        this.leaveRequests.remove(leaveRequest);
    }

    @Override
    public List<LeaveRequest> findAll() {
        return leaveRequests;
    }

    @Override
    public LeaveRequest findByStudent(Student student) {
        for (LeaveRequest i: leaveRequests){
            if(i.getStudent().getUsername().equals(student.getUsername())){
                return i;
            }
        }
        return null;
    }
}
