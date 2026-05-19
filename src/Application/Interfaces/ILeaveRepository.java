package Application.Interfaces;

import Domain.LeaveRequest;
import Domain.Student;
import java.util.List;

public interface ILeaveRepository {

    void save(LeaveRequest leaveRequest);

    void delete(LeaveRequest leaveRequest);

    List<LeaveRequest> findAll();

    LeaveRequest findByStudent(Student student);
}
