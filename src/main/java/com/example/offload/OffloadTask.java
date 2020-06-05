package com.example.offload;

import com.example.offload.model.Offload;
import com.example.offload.repo.OffloadRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class OffloadTask implements Runnable {

    private boolean run = true;
    private OffloadRepo offloadRepo;
    private JmsTemplate jmsTemplate;

    private static Logger log = LoggerFactory.getLogger("some-log");

    public OffloadTask(OffloadRepo offloadRepo, JmsTemplate jmsTemplate) {
        this.offloadRepo = offloadRepo;
        this.jmsTemplate = jmsTemplate;
    }

    @PreDestroy
    public void onDestroy() {
        run = false;
    }

    private void performOffload() {
        //jmsTemplate.convertAndSend("some-dest", offloadRepo.findById(1).get());
        log.info("Querying Repo");
        Offload o = offloadRepo.findById(1).get();
    }

    @Override
    public void run() {
        while(run) {
            performOffload();
        }
    }
}
