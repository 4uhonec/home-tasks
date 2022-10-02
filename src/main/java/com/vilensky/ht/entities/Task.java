package com.vilensky.ht.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String name;
    private String status; //not started, in progress, completed
    private String urgency; //chill, moderate, urgent
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "task_worker",
                joinColumns = @JoinColumn(name="task_id"),
                inverseJoinColumns = @JoinColumn(name="worker_id"))
    private List<Worker> workers;

    public Task(){}

    public Task(String name, String status, String urgency, String description) {
        super();
        this.name = name;
        this.status = status;
        this.urgency = urgency;
        this.description = description;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public void addWorker(Worker worker){
        if(workers == null){
            workers = new ArrayList<>();
        }
        workers.add(worker);
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
