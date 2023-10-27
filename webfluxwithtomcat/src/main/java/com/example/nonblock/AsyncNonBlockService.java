package com.example.nonblock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
public class AsyncNonBlockService {

    public Mono<Void> nonBlockingMethod() {
        return Mono.delay(java.time.Duration.ofSeconds(20)) // 10초 딜레이
                .doOnNext(i -> log.info("Non-blocking method: Delayed for 5 seconds"))
                .then()
                .subscribeOn(Schedulers.boundedElastic()); // 백그라운드 스레드에서 실행
    }
}
