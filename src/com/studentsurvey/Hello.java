
/* Mahbubul Alam Palash & Taseef Rahman
 * Class tht implements Rest API
		 * 
		 */

package com.studentsurvey;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import com.studentsurvey.*;
import com.studentsurvey.Survey;
import com.studentsurvey.Student;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Application;
import javax.xml.bind.*;
import javax.persistence.Query;
@Path("/surveys")
public class Hello {

	
		@GET
		@Path("/all")
		@Produces("application/json")
		public  List<Employee> getall (){
			 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "surveywebjpa" );
		      
		      EntityManager entitymanager = emfactory.createEntityManager( );
			 entitymanager.getTransaction( ).begin( );
		  
			/*TypedQuery<Student> query =
				      entitymanager.createNamedQuery("Student.findAll", Student.class);
				  List<Student> results = query.getResultList();*/
			
			TypedQuery<Employee> query = entitymanager.createQuery("SELECT h FROM Employee h ", Employee.class);
			
			return query.getResultList();
			
	
			
			}


		/* Mahbubul Alam Palash & Taseef Rahman
		 * 
		 * This method takes return all survey as JSON
		 */

		@GET    
		@Path("/allsurvey")
		@Produces("application/json")
		public  List<Survey> getallsurvey (){
			 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "surveywebjpa" );
		      
		      EntityManager entitymanager = emfactory.createEntityManager( );
			 entitymanager.getTransaction( ).begin( );
		  
			/*TypedQuery<Student> query =
				      entitymanager.createNamedQuery("Student.findAll", Student.class);
				  List<Student> results = query.getResultList();*/
			
			TypedQuery<Survey> query = entitymanager.createQuery("SELECT h FROM Survey h ", Survey.class);
			
			return query.getResultList();
			
	
			
			}

	
	/* Mahbubul Alam Palash & Taseef Rahman
	 * 
	 * This method takes survey data as Jason maps with POJO and uses jpa persistence to enter into database in GKE Container
	 */
		
		@POST
		@Path("/new")
		@Consumes("application/json") 
		public String addsurvey(Survey p) {
		    
			 EntityManagerFactory emfactory=Persistence.createEntityManagerFactory( "surveywebjpa" );
			EntityManager entitymanager = emfactory.createEntityManager( );
		      entitymanager.getTransaction( ).begin( );
		  
		  
		      entitymanager.persist( p);
		      entitymanager.getTransaction( ).commit( );
		      entitymanager.close( );
		      emfactory.close( );
			
			return "Survey Entered  updated  "+p.toString();
		}

		
	}
