package com.example.mvcblocknonblock.sync_nonblock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sync/non_block")
public class SyncNonBlockController {

    private final SyncNonBlockService syncNonBlockService;

    @GetMapping
    public void syncNonBlockTest() {
        log.info("syncNonBlockTest start Thread : {}", Thread.currentThread().getName());
        syncNonBlockService.callTimeOutLog();
        log.info("syncNonBlockTest finish Thread : {}", Thread.currentThread().getName());
    }

}
