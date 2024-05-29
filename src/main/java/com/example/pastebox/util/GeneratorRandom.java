package com.example.pastebox.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GeneratorRandom {
    private AtomicInteger counter = new AtomicInteger();

    public int generate() {
        return counter.getAndIncrement();
    }

}
