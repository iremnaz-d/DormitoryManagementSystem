package Application;


import Application.Interfaces.ILeaveRepository;
import Domain.LeaveRequest;
import Domain.Student;
import Infrastructure.LeaveRepository;

import java.time.LocalDate;

public class LeaveService {

    private ILeaveRepository repository;

    public LeaveService(){
        this.repository = LeaveRepository.getInstance();
    }

    public boolean submitRequest(Student student, LocalDate startDate, LocalDate endDate){
        if(endDate.isBefore(startDate))
            return false;

        LeaveRequest request = new LeaveRequest.LeaveRequestBuilder()
                .withStudent(student)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withParentalConsent(false)
                .withIsApproved(false)
                .build();

        this.repository.save(request);
        return true;
    }

    public boolean verifyParentalConsentAndApproveRequest(Student student){
        LeaveRequest requestToApprove = this.repository.findByStudent(student);

        if(requestToApprove == null)
            return false;

        requestToApprove.setParentalConsent(true);
        requestToApprove.approveRequest();
        return true;
    }

    public String postponeEndDate(Student student, LocalDate date){
        LeaveRequest request = this.repository.findByStudent(student);
        if(request == null)
            return "Request not found.";
        request.setEndDate(date);
        request.rejectRequest();
        return "Your request is postponed to " + date.toString()
         + "/nParental consent for this delay is mandatory";
    }

}
