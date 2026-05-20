package Infrastructure;

import Application.Interfaces.ITaskRepository;
import Domain.Personnel;
import Domain.TaskAssignment;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements ITaskRepository {

    private static TaskRepository instance;
    private List<TaskAssignment> tasks;

    private TaskRepository(){
        this.tasks = new ArrayList<>();
    }

    public static TaskRepository getInstance(){
        if(instance == null){
            instance =  new TaskRepository();
        }
        return instance;
    }


    @Override
    public void save(TaskAssignment task) {
        tasks.add(task);
    }

    @Override
    public void delete(TaskAssignment task) {
        this.tasks.remove(task);
    }

    @Override
    public List<TaskAssignment> findAll() {
        return tasks;
    }

    @Override
    public TaskAssignment findByPersonnel(Personnel personnel) {
        for (TaskAssignment i: tasks){
            if(i.getPersonnel().getUsername().equals(personnel.getUsername())){
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean contains(TaskAssignment task) {
        return this.tasks.contains(task);
    }

    @Override
    public List<TaskAssignment> getTasksForPersonnel(Personnel personnel) {
        List<TaskAssignment> list = new ArrayList<>();
        for (TaskAssignment i: this.tasks){
            if(i.getPersonnel().getUsername().equals(personnel.getUsername()))
                list.add(i);
        }
        return list;
    }


}
