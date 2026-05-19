package Domain;

public class Personnel extends User {

    private String name;
    private String jobType;
    private String currentShift;

    public Personnel (String username, String password, String role, String name, String jobType){
        super(username, password, role);
        this.name = name;
        this.jobType = jobType;
        this.currentShift = "";
    }

    public String getPersonnelDetails(){
        return "Personnel: " + name + "    Duty: " + jobType + "    Shift: " + currentShift;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(String currentShift) {
        this.currentShift = currentShift;
    }



}
