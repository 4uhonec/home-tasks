package com.vilensky.ht.dto;

public interface WorkerTask {

    //important to have names as get+....
    String getName();
    Long getWorkerId();
    Long getTaskId();
    String getTaskName();
}
