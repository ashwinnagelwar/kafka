package com.kafkaDemo.kafkaDemo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaDemo.kafkaDemo.entity.UserInfo;
import com.kafkaDemo.kafkaDemo.service.KafkaProducerService;

@RestController
@RequestMapping("/producer-app")
public class KafkaProducerController {

	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@PostMapping("/publish-data")
	public ResponseEntity<String> publicMessage(@RequestBody UserInfo userInfo) throws InterruptedException, ExecutionException 
	{
		kafkaProducerService.sendMessage(userInfo);
		return new ResponseEntity<String>("Data Send successfully", HttpStatus.OK);
	}
}
