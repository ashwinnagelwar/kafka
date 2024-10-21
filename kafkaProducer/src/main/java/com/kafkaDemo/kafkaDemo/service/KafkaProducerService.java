package com.kafkaDemo.kafkaDemo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.common.message.ConsumerProtocolAssignment.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kafkaDemo.kafkaDemo.entity.UserInfo;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(UserInfo userInfo) throws InterruptedException, ExecutionException
	{
		CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send("my-topic",3,null, userInfo);
		//we can send data to specific partition by defining topic no as we defined in above method
		CompletableFuture<SendResult<String,Object>> whenComplete = completableFuture.whenComplete((result,ex)->{
			if(result!=null)
			{
				System.out.println("Data Sent "+result.getRecordMetadata().offset());
			}else
			{
				System.out.println("Unable to send data");
			}
		});
	}
	
}
