package Application;

import Application.Interfaces.ITaskRepository;
import Domain.Personnel;
import Domain.TaskAssignment;
import Infrastructure.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

public class StaffOperationsService {

    private ITaskRepository repository;

    public StaffOperationsService(){
        this.repository = TaskRepository.getInstance();
    }

    public boolean assignTask(Personnel personnel, String taskName, LocalDateTime dateTime, String location){

        TaskAssignment task = new TaskAssignment.TaskAssignmentBuilder()
                .withTaskName(taskName)
                .withPersonnel(personnel)
                .withDate(dateTime)
                .withLocation(location)
                .build();

        this.repository.save(task);
        return true;
    }

    public boolean addDescriptionToTask(TaskAssignment task, String description){
        if(!this.repository.contains(task))
            return false;
        task.setTaskDescription(description);
        return true;
    }

    public List<TaskAssignment> getTasksForPersonnel(Personnel personnel){
        return this.repository.getTasksForPersonnel(personnel);
    }
}
