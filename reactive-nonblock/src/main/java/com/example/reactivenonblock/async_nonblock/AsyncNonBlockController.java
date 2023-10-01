package com.example.reactivenonblock.async_nonblock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/async/non_block")
public class AsyncNonBlockController {

    private final AsyncNonBlockService asyncNonBlockService;

    @GetMapping
    public Mono<String> nonBlockingEndpoint() {
        return asyncNonBlockService.nonBlockingMethod()
                .thenReturn("Non-blocking operation completed!");
    }
}
