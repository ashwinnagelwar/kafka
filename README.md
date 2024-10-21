1. Install Kafka on PC

2. extract any folder, but keep path small ex. c:/kafka->extract here

3. change path in server.properties and zookeeper.properties file
	-server.properties-> log.dirs=c:/kafka--> same path where we extract the kafka
	-zookeeper.properties-> Data.dir=c:/kafka-->same path where we extract the kafka

4. Run Zookeeper Server by following command(cammand can change wrt time)
	-C:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	
5. Run Kafka Broker/Server by following command(cammand can change wrt time)
	-C:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties
	
6. Create topic over kafka server with partiotion
	-C:\kafka>.\bin\windows\kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
----------------------------------------------------------------------------------------------------

1. Create Kafka Producer App by adding kafka dependency
	-then user KafkaTemplate object to send message over topic
	-user key-value serialization configuration to send object over topic as kafka work with byte stream.
	
2. We have alos used offset explorer to see message over topic

3. Create Kafka Cconsumer app by adding same kafka dependency
	-also added jackson-databind dependency to consume any json object
	- add some configuration to deserialize consumed object
	
4. define method with @kafkaListener to consume message, and give topic name same as producer and group id which you can give any
