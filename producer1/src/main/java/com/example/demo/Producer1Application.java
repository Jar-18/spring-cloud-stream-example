package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Producer1Channels.class)
@RestController
public class Producer1Application {

	@Autowired
    @Qualifier("output")
    MessageChannel output;
	
	String messages = "";
	
	@RequestMapping("/send")
    public String send() {
		int randomNumber = new Random().nextInt(10000);
		String message = randomNumber + "FromProducer1";
		output.send(MessageBuilder.withPayload(message).build());
		messages += (message + " ");
		return "" + randomNumber;
    }
	
	@RequestMapping("/all")
    public String getAll() {
    	return "Producer1 Sent: " + messages;
    }
	
	@RequestMapping("/")
    public String getRoot() {
    	return "Producer1";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Producer1Application.class, args);
	}
}
