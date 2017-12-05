package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Consumer3Channels.class)
@RestController
public class Consumer3Application {

	String messages = "";
	
	@StreamListener(Consumer3Channels.INPUT)
    public void input(Message<String> message) {
    	messages += (message.getPayload() + "  ");
    }
	
	@RequestMapping("/")
    public String getRoot() {
    	return "Consumer3";
    }
	
	@RequestMapping("/all")
    public String getAll() {
    	return "Consumer3 Received: " + messages;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Consumer3Application.class, args);
	}
}
