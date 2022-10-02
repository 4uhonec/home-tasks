package com.vilensky.ht.dao;

import com.vilensky.ht.entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();
}
