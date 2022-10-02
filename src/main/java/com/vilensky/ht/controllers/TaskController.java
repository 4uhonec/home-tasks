package com.vilensky.ht.controllers;

import com.vilensky.ht.dao.TaskRepository;
import com.vilensky.ht.dao.WorkerRepository;
import com.vilensky.ht.entities.Task;
import com.vilensky.ht.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;

    @GetMapping
    public String displayTasks(Model model){
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);

        return "tasks/list-tasks";
    }

    @GetMapping("/new")
    public String displayTaskForm(Model model){
        Task aTask = new Task();
        List<Worker> workers = workerRepository.findAll();
        model.addAttribute("workersList", workers);
        model.addAttribute("task", aTask);

        return "tasks/new-task";
    }

    @PostMapping("/save")
    public String createTask(Task task, Model model){
        taskRepository.save(task);

        return "redirect:/tasks";
    }
}
