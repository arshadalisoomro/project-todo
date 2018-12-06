package pk.edu.project.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.edu.project.todo.model.Task;

import java.util.List;

/**
 * Created by ADMIN on 12/6/2018.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
    public List<Task> findAllByOrderByTaskIdDesc();
}
