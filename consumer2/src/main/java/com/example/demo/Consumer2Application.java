package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Consumer2Channels.class)
@RestController
public class Consumer2Application {

	String messages = "";
	
	@StreamListener(Consumer2Channels.INPUT)
    public void input(Message<String> message) {
    	messages += (message.getPayload() + "  ");
    }
	
	@RequestMapping("/")
    public String getRoot() {
    	return "Consumer2";
    }
	
	@RequestMapping("/all")
    public String getAll() {
    	return "Consumer2 Received: " + messages;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Consumer2Application.class, args);
	}
}
