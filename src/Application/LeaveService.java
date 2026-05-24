package Application;


import Application.Interfaces.ILeaveRepository;
import Domain.LeaveRequest;
import Domain.Student;
import Infrastructure.LeaveRepository;

import java.time.LocalDate;
import java.util.List;

public class LeaveService {

    private ILeaveRepository repository;

    public LeaveService(){
        this.repository = LeaveRepository.getInstance();
    }

    public boolean submitLeaveRequest(Student student, LocalDate startDate, LocalDate endDate){
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

    public String verifyParentalConsentAndApproveRequest(Student student){
        LeaveRequest requestToApprove = this.repository.findByStudent(student);


        if(requestToApprove == null)
            return "Request not found.";

        if(requestToApprove.isApproved()){
            return "Last active request is already approved.";
        }

        requestToApprove.setParentalConsent(true);
        requestToApprove.approveRequest();
        return "Leave request approved.";
    }

    public String postponeEndDate(Student student, LocalDate date){
        LeaveRequest request = this.repository.findByStudent(student);
        if(request == null)
            return "Request not found.";
        request.setEndDate(date);
        request.rejectRequest();
        return String.format("Your request is postponed to %s but not approved yet.\nParental consent for leave delay is mandatory", date.toString());
    }

    public List<LeaveRequest> getAllRequests(){
        return this.repository.findAll();
    }

    public List<LeaveRequest> getUnapprovedRequests(){
        return this.repository.getUnapprovedRequests();
    }

    public List<LeaveRequest> getRequestsByStudent(Student student){
        return this.repository.findAllByStudent(student);
    }


}
