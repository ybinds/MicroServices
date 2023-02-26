package com.app.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.service.ProducerService;

@Component
public class TestSenderRunner { 
//implements CommandLineRunner {

	@Autowired
	private ProducerService service;
	
//	@Override
//	public void run(String... args) throws Exception {
//		service.sendMessage("HELLO " + new Date());
//	}
	
	@Scheduled(cron="*/10 * * * * *")
	public void sendMessageTest() throws Exception {
		service.sendMessage("HELLO " + new Date());
	}

}
