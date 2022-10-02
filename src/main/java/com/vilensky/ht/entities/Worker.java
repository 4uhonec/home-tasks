package com.vilensky.ht.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workerId;
    private String name;
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="task_worker",
                joinColumns = @JoinColumn(name = "worker_id"),
                inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    public Worker(){}

    public Worker(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
