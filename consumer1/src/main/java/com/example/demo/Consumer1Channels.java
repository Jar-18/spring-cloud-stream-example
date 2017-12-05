package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Consumer1Channels {
    String INPUT = "input";
    String INPUT2 = "input2";
    
    String OUTPUT = "output";

    @Input("input")
    SubscribableChannel input();
    
    @Input("input2")
    SubscribableChannel input2();
    
    @Output("output")
    MessageChannel output();
}