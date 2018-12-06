package pk.edu.project.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pk.edu.project.todo.model.Task;
import pk.edu.project.todo.service.TaskService;

/**
 * Created by ADMIN on 12/6/2018.
 */

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    private static final Logger log = LoggerFactory.getLogger(TaskCrudController.class);

    @GetMapping(value = "/")
    public String getHome(Model model){
        //Sending model for adding new record in DB
        model.addAttribute("task", new Task());

        //Sending model for getting all the saved records from db and showing on the page
        model.addAttribute("taskList", taskService.findAll());
        return "home";
    }
}
