package com.vilensky.ht.controllers;

import com.vilensky.ht.dao.WorkerRepository;
import com.vilensky.ht.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerRepository workerRepository;

    @GetMapping
    public String displayWorkers(Model model){
        List<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);

        return "workers/list-workers";
    }

    @GetMapping("/new")
    public String displayWorkerForm(Model model){
        Worker worker = new Worker();
        model.addAttribute("worker", worker);

        return "workers/new-worker";
    }

    @PostMapping("/save")
    public String createWorker(Worker worker){
        workerRepository.save(worker);

        return "redirect:/workers/new";
    }
}
