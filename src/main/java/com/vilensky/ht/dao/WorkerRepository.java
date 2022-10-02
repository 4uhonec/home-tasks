package com.vilensky.ht.dao;

import com.vilensky.ht.dto.WorkerTask;
import com.vilensky.ht.entities.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    @Override
    List<Worker> findAll();

    @Query(nativeQuery = true, value="select w.name as name, tw.worker_id as workerId, tw.task_id as taskId, t.name as taskName " +
            "from worker as w left join task_worker as tw on w.worker_id=tw.worker_id inner join task as t " +
            "on tw.task_id=t.task_id")
    List<WorkerTask> workerTasks();
}
