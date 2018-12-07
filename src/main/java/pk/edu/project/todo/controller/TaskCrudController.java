package pk.edu.project.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pk.edu.project.todo.model.Task;
import pk.edu.project.todo.service.TaskService;

/**
 * Created by ADMIN on 12/6/2018.
 */

@Controller
public class TaskCrudController {

    @Autowired
    private TaskService taskService;

    private static final Logger log = LoggerFactory.getLogger(TaskCrudController.class);

    @PostMapping(value = "/save")
    public String saveTask(@ModelAttribute(value = "task")Task task){
        taskService.save(task);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteTask(@RequestParam(value = "id")Integer taskId){
        taskService.deleteByTaskId(taskId);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String editTask(@RequestParam(value = "id")Integer taskId, Model model){
        //Getting the selected record from DB
        Task task = taskService.findByTaskId(taskId);
        log.error("Task is >>====>" + task.getTaskTitle());

        //Sending model for adding new record in DB
        model.addAttribute("task", task);

        //Sending model for getting all the saved records from db and showing on the page
        model.addAttribute("taskList", taskService.findAll());

        return "home";
    }


}
