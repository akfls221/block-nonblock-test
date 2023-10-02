package com.example.mvcblocknonblock.deferred_result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/deferred-result")
public class DeferredResultController {

    private final DeferredResultService deferredResultService;

    @GetMapping
    public DeferredResult<Void> handleReqDefResult() {
        log.info("start async-deferredresult request");
        DeferredResult<Void> output = new DeferredResult<>();

        ForkJoinPool.commonPool().submit(() -> {
            log.info("Processing in separate thread");
            deferredResultService.callTimeOutLog();
        });

        log.info("finish thread freed");
        return output;
    }
}
