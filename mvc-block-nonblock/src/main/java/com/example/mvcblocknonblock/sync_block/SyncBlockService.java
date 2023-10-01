package com.example.mvcblocknonblock.sync_block;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SyncBlockService {

    public void callTimeOutLog() {
        try {
            Thread.sleep(10000);
            log.info("callTimeOutLog for 10 second Thread : {}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
