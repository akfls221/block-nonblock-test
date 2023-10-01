package com.example.mvcblocknonblock.sync_nonblock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SyncNonBlockService {

    @Async(value = "nonblockTaskExecutor")
    public void callTimeOutLog() {
        try {
            Thread.sleep(10000);
            log.info("callTimeOutLog for 10 second Thread : {}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
