package Application.Interfaces;

import Domain.LeaveRequest;
import Domain.Student;
import java.util.List;

public interface ILeaveRepository {

    void save(LeaveRequest leaveRequest);

    void delete(LeaveRequest leaveRequest);

    List<LeaveRequest> findAll();

    List<LeaveRequest> findAllByStudent(Student student);

    List<LeaveRequest> getUnapprovedRequests();

    LeaveRequest findByStudent(Student student);
}
