package com.studentsurvey;
import javax.ws.rs.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;

import java.util.*;
@Path("/surveys")
public class Hello {
		
	private static final String TOPIC_NAME = "survey-data-topic";
	private static Hello instance = null;

	public static final String SERVER = "35.2";
	private Producer<Long, Survey> producer;
	private KafkaConsumer<Long, Survey> kafkaConsumer;
	private ConsumerRecords<Long, Survey> records;
	List<String> studList =new ArrayList<String>();
	List<Survey> sb =new ArrayList<Survey>();

	/**
	 * creating a singleton instance of database connection class
	 * 
	 * @return
	 */


	/**
	 * creating a singleton instance of database connection class
	 * 
	 * @return
	 */
	public static synchronized Hello getInstance() {
		// if singleton instance is not available create an instance object
		if (null == instance) {
			instance = new Hello();
		}
		// else return the existing instance object
		return instance;
	}

	
	private void setKafkaProducer() {
		Properties producerProperties = new Properties();

		producerProperties.put("bootstrap.servers",  "35.238.147.164:9093");
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Survey.class.getName());
		producerProperties.put(ProducerConfig.ACKS_CONFIG, "all");
		producer = new KafkaProducer<>(producerProperties);
	}
	
	private void setKafkaConsumer() {
		Properties consumerProperties = new Properties();
		consumerProperties.put("bootstrap.servers",  "35.238.147.164:9093");
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Survey.class.getName());
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		consumerProperties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
		kafkaConsumer = new KafkaConsumer<>(consumerProperties);
		kafkaConsumer.subscribe(Collections.singletonList(TOPIC_NAME));
		
	}
	private Producer<Long, Survey> getKafkaProducer() {
		return producer;
	}

	@GET
	@Path("/all")
	@Produces("application/json")
	public  List<Survey> getall (){
	setKafkaConsumer();
	try {
    while (true) { 
        ConsumerRecord<Long, Survey> record = consumer.poll(100); 
        for (ConsumerRecord<Long, Survey> record : records) {
			System.out.println("Received: " + record.key() + ":" + record.value());
			Survey temp = (Survey) record.value();
			sb.add(temp);
			

		}
} finally {
    consumer.close(); 
}
	
	
		
		
		
		return sb;
		

		
		}


		/*@POST
		@Path("/new")
		@Consumes("application/json") 
		public String addsurvey(Student p) {
		    
			 EntityManagerFactory emfactory=Persistence.createEntityManagerFactory( "surveywebjpa" );;
			EntityManager entitymanager = emfactory.createEntityManager( );
		      entitymanager.getTransaction( ).begin( );
		  
		  
		      entitymanager.persist( p);
		      entitymanager.getTransaction( ).commit( );
		      entitymanager.close( );
		      emfactory.close( );
			
			return "HI HI post jason"+p.toString();
		}*/
		
	@POST	
	@Path("/new")
	@Consumes("application/json") 
	public String addsurvey(Survey p) {

		setKafkaProducer();

	Producer<Long, Survey> producer = getKafkaProducer();

	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            System.out.println("...Stopping Basic Producer...");
	            producer.close();
	        }));
	        Survey p1= new Survey();
	        p1.setCity("dhaka");
	        final String TOPIC = "survey-data-topic";
			ProducerRecord<Long, Survey> record = new ProducerRecord<Long, Survey>(TOPIC, null, p1);
			producer.send(record);
			System.out.println("Send record#" + record);
			producer.close();
			return "Posted";
	
	}
		
		
		
		

		
	}
