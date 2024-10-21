package com.kafkaDemo.kafkaConsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kafkaDemo.kafkaConsumer.entity.UserInfo;

@Service
public class KafkaConsumerService {


	
	@KafkaListener(topics = "my-topic", groupId = "my-consumer-group",topicPartitions = {@TopicPartition(topic="my-topic",partitions = {"3"})})
	//we can consumed message from specific partitions with above configuration
	public void consumeData(UserInfo userInfo)
	{
		System.out.println(userInfo.toString());
	}
}
