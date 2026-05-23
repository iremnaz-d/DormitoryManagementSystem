package Infrastructure;

import Application.Interfaces.ITaskRepository;
import Domain.Personnel;
import Domain.TaskAssignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskRepository implements ITaskRepository {

    private static TaskRepository instance;
    private Set<TaskAssignment> tasks;

    private TaskRepository(){
        this.tasks = new TreeSet<>(
                Comparator.comparing(TaskAssignment::getDateTime) //dateTime'a göre sıralı tasks
                        .thenComparing(task -> task.getPersonnel().getUsername()));
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
    public Set<TaskAssignment> findAll() {
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

    @Override
    public List<TaskAssignment> getTasksByDate(LocalDate date) {
        List<TaskAssignment> list = new ArrayList<>();
        for (TaskAssignment i: this.tasks){
            if(i.getDate().equals(date))
                list.add(i);
        }
        return list;
    }


}
