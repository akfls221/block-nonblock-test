package com.example.mvcblocknonblock.deferred_result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeferredResultService {
    public void callTimeOutLog() {
        try {
            Thread.sleep(5000);
            log.info("callTimeOutLog for 10 second Thread : {}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
