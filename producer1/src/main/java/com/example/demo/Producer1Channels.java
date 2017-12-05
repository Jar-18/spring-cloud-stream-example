package com.example.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Producer1Channels {
    String OUTPUT = "output";

    @Output("output")
    MessageChannel output();
    
    @Output("output2")
    MessageChannel output2();
}