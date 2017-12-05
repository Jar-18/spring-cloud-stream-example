package com.example.demo;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Producer2Channels {
    String OUTPUT2 = "output2";
    String INPUT = "input";
    
    @Output("output2")
    MessageChannel output2();
    
    @Input("input")
    SubscribableChannel input();
}