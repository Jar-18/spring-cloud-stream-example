package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Consumer2Channels {
    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();
}