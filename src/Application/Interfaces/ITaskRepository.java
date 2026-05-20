package Application.Interfaces;

import Domain.Personnel;
import Domain.TaskAssignment;
import java.util.List;

public interface ITaskRepository {

    void save(TaskAssignment task);

    void delete(TaskAssignment task);

    List<TaskAssignment> findAll();

    TaskAssignment findByPersonnel(Personnel personnel);

    boolean contains(TaskAssignment task);

    List<TaskAssignment> getTasksForPersonnel(Personnel personnel);

}
