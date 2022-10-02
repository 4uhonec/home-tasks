package com.vilensky.ht.controllers;

import com.vilensky.ht.dao.TaskRepository;
import com.vilensky.ht.dao.WorkerRepository;
import com.vilensky.ht.dto.WorkerTask;
import com.vilensky.ht.entities.Task;
import com.vilensky.ht.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Task> tasks = taskRepository.findAll();
        List<Worker> workers = workerRepository.findAll();

        List<WorkerTask> workerTasks = workerRepository.workerTasks();//**test

        model.addAttribute("tasks", tasks);
        model.addAttribute("workers", workers);

        model.addAttribute("worker_tasks", workerTasks);//**test


        return "main/home";
    }
}
