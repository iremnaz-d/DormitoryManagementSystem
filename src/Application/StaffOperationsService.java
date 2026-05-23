package Application;

import Application.Interfaces.ITaskRepository;
import Domain.Personnel;
import Domain.TaskAssignment;
import Infrastructure.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class StaffOperationsService {

    private ITaskRepository repository;

    public StaffOperationsService(){
        this.repository = TaskRepository.getInstance();
    }

    public TaskAssignment assignTask(Personnel personnel, String taskName, LocalDateTime dateTime, String location){

        TaskAssignment task = new TaskAssignment.TaskAssignmentBuilder()
                .withTaskName(taskName)
                .withPersonnel(personnel)
                .withDate(dateTime)
                .withLocation(location)
                .build();

        this.repository.save(task);
        return task;
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

    public Set<TaskAssignment> getAllTasks(){
       return this.repository.findAll();
    }
}
