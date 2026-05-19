package Domain;

import java.time.LocalDateTime;

public class TaskAssignment {

    private Personnel personnel;
    private String taskName;
    private String taskDescription;
    private LocalDateTime dateTime;
    private String location;

    private TaskAssignment(TaskAssignmentBuilder builder){
        this.taskName = builder.taskName;
        this.personnel = builder.personnel;
        this.dateTime = builder.dateTime;
        this.location = builder.location;
        this.taskDescription = "";
    }

    public String getTaskDetails(){
        return "ğ";
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static class TaskAssignmentBuilder{

        private Personnel personnel;
        private String taskName;
        private LocalDateTime dateTime;
        private String location;

        public TaskAssignment build(){
            return new TaskAssignment(this);
        }

        public TaskAssignmentBuilder withPersonnel(Personnel personnel){
            this.personnel = personnel;
            return this;
        }

        public TaskAssignmentBuilder withTaskName(String taskName){
            this.taskName = taskName;
            return this;
        }

        public TaskAssignmentBuilder withDate(LocalDateTime dateTime){
            this.dateTime = dateTime;
            return this;
        }

        public TaskAssignmentBuilder withLocation(String location){
            this.location = location;
            return this;
        }

    }


}
