package pk.edu.project.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.project.todo.model.Task;
import pk.edu.project.todo.repository.TaskRepository;

import java.util.List;

/**
 * Created by ADMIN on 12/6/2018.
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void save(Task task){
        taskRepository.save(task);
    }

    public Task findByTaskId(Integer taskId){
        return taskRepository.findById(taskId).isPresent() ? taskRepository.findById(taskId).get() : null;
    }

    public List<Task> findAll(){
        return taskRepository.findAllByOrderByTaskIdDesc();
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    public void deleteByTaskId(Integer taskId){
        taskRepository.deleteById(taskId);
    }

}
