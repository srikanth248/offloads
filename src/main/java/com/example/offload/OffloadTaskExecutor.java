package com.example.offload;

import com.example.offload.model.Offload;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OffloadTaskExecutor {

    public OffloadTaskExecutor(TaskExecutor taskExecutor, OffloadTask offloadTask) {
        //for(int i=0; i < 5; i++) {
            taskExecutor.execute(offloadTask);
        //}
    }
}
