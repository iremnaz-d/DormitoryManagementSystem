package Domain;
import java.time.LocalDate;

public class LeaveRequest {
    private Student student;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean parentalConsent;
    private boolean isApproved;

    private LeaveRequest(LeaveRequestBuilder builder) { //builderdaki değerler buraya kopyalanır
        this.student = builder.student;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.parentalConsent = builder.parentalConsent;
        this.isApproved = builder.isApproved;
    }

   public String getLeaveRequestDetailsLong(){
        String student = "Student: " + this.student.getFirstName() + " " + this.student.getLastName() + "\n";
        String date = "Start Date: " + this.startDate.toString() + "   End Date: " + this.endDate.toString() + "\n";
        String parentalConsent = "", isApproved = "";
        if(!this.parentalConsent) parentalConsent = "Parent has not approved yet.\n";
        else parentalConsent = "Parent has approved the Leave Request.\n";
        if(this.isApproved) isApproved = "Approved.\n";
        else isApproved = "Pending/Rejected\n\n";

        return student + date + parentalConsent + isApproved;
    }

    public String getLeaveRequestDetailsShort(){
        return String.format("%s %s: %s - %s Approved: %s",
                this.student.getFirstName(),this.student.getLastName(),this.startDate.toString(),this.endDate.toString(),this.isApproved);
    }


    public Student getStudent() {
        return student;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isParentalConsent() {
        return parentalConsent;
    }

    public void setParentalConsent(boolean parentalConsent) {
        this.parentalConsent = parentalConsent;
    }

    public boolean isApproved() {
        return isApproved;
    }

   public void approveRequest(){
        this.isApproved = true;
   }

   public void rejectRequest(){
        this.isApproved = false;
   }



    public static class LeaveRequestBuilder{

        Student student;
        LocalDate startDate;
        LocalDate endDate;
        boolean parentalConsent;
        boolean isApproved;

        public LeaveRequest build(){
            return new LeaveRequest(this);
        }

        public LeaveRequestBuilder withStudent(Student student){
            this.student = student;
            return this;
        }

        public LeaveRequestBuilder withStartDate(LocalDate startDate){
            this.startDate = startDate;
            return this;
        }

        public LeaveRequestBuilder withEndDate(LocalDate EndDate){
            this.endDate = EndDate;
            return this;
        }
        public LeaveRequestBuilder withParentalConsent(boolean parentalConsent){
            this.parentalConsent = parentalConsent;
            return this;
        }

        public LeaveRequestBuilder withIsApproved(boolean isApproved){
            this.isApproved = isApproved;
            return this;
        }

    }

}
