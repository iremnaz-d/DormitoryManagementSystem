package Application.Interfaces;

import Domain.Personnel;
import Domain.TaskAssignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ITaskRepository {

    void save(TaskAssignment task);

    void delete(TaskAssignment task);

    Set<TaskAssignment> findAll();

    TaskAssignment findByPersonnel(Personnel personnel);

    boolean contains(TaskAssignment task);

    List<TaskAssignment> getTasksForPersonnel(Personnel personnel);

    List<TaskAssignment> getTasksByDate(LocalDate date);

}
