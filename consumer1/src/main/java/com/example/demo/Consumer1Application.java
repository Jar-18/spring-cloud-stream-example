package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Consumer1Channels.class)
@RestController
public class Consumer1Application {

	String messages = "";
	
	@StreamListener(Consumer1Channels.INPUT)
    public void input(Message<String> message) {
    	messages += (message.getPayload() + "  ");
    }
	
	@StreamListener(Consumer1Channels.INPUT2)
	@SendTo(Consumer1Channels.OUTPUT)
    public SimpleMessage input2(SimpleMessage sm) {
    	messages += (sm.toString() + " ");
    	sm.setValue(sm.getValue() + "!");
    	return sm;
    }
	
	@RequestMapping("/")
    public String getRoot() {
    	return "Consumer1";
    }
	
	@RequestMapping("/all")
    public String getAll() {
    	return "Consumer1 Received: " + messages;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Consumer1Application.class, args);
	}
}
