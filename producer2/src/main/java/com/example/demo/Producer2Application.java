package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Producer2Channels.class)
@RestController
public class Producer2Application {
	
	@Autowired
    @Qualifier("output2")
    MessageChannel output2;
	
	String messages = "";
	String receivedMessages = "";
	
	@RequestMapping("/send2")
    public String send2() {
		Random r = new Random();
		char randomLetter = (char)(r.nextInt(26) + 'A');
		SimpleMessage sm = new SimpleMessage();
		sm.setValue("" + randomLetter);
		output2.send(MessageBuilder.withPayload(sm).build());
		String message = sm.toString() + "FromProducer2";
		messages += (message + " ");
		return "" + sm.toString();
    }
	
	@StreamListener(Producer2Channels.INPUT)
    public void input(SimpleMessage sm) {
		receivedMessages += (sm.toString() + " ");
    }
	
	@RequestMapping("/all")
    public String getAll() {
    	return "Producer2 Sent: " + messages + "---------------------------" + "Producer2 Received: " + receivedMessages;
    }
	
	@RequestMapping("/")
    public String getRoot() {
    	return "Producer2";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Producer2Application.class, args);
	}
}
