package com.studentsurvey;
import javax.ws.rs.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.*;
@Path("/surveys")
public class Hello {
		
	private static final String TOPIC = "survey-data-topic";

	
	@GET
	@Path("/all")
	@Produces("application/json")
	public  Student getall (){
		 
	  
		/*TypedQuery<Student> query =
			      entitymanager.createNamedQuery("Student.findAll", Student.class);
			  List<Student> results = query.getResultList();*/
		
		
		Student s =new Student();
		return s;
		

		
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
		
		
	@Path("/new")
	@Consumes("application/json") 
	public String addsurvey(Student p) {
		 Properties settings = setUpproducerProperties();
	     Producer<Long, Student> producer =  new KafkaProducer<>(settings);

	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            System.out.println("...Stopping Basic Producer...");
	            producer.close();
	        }));
	 
	        final String TOPIC = "survey-data-topic";
			ProducerRecord<Long, Student> record = new ProducerRecord<Long, Student>(TOPIC, null, p);
			producer.send(record);
			System.out.println("Send record#" + record);
	
		
		return ""+p.toString();
	}
		
		
		
		
		private static Properties setUpconsumerProperties() {
			Properties settings = new Properties();
			settings.put(GROUP_ID_CONFIG, "basic-consumer");
			settings.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			settings.put(ENABLE_AUTO_COMMIT_CONFIG, "true");
			settings.put(AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
			settings.put(AUTO_OFFSET_RESET_CONFIG, "earliest");
			settings.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
			settings.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
			return settings;
		}
		
		private static Properties setUpproducerProperties() {
			Properties settings = new Properties();
			settings.put(ProducerConfig.CLIENT_ID_CONFIG, "basic-producer");
			settings.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "35.238.147.164");
			settings.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
					"org.apache.kafka.common.serialization.StringSerializer");
			settings.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
					"org.apache.kafka.common.serialization.StringSerializer");
			return settings;
		}

		
	}



