package com.example.mvcblocknonblock.sync_block;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sync/block")
public class SyncBlockController {

    private final SyncBlockService syncBlockService;

    @GetMapping
    public void syncBlockTest() {
        log.info("syncBlockTest start Thread : {}", Thread.currentThread().getName());
        syncBlockService.callTimeOutLog();
        log.info("syncBlockTest finish Thread : {}", Thread.currentThread().getName());
    }

}
