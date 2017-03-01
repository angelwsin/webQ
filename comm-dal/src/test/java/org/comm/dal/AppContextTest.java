package org.comm.dal;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
@Configuration("classpath:spring-*.xml")*/
public class AppContextTest {
	
	 private static Logger log = LoggerFactory.getLogger(AppContextTest.class); 
         //@Autowired
	     protected  ApplicationContext  context;
         
         //@Test
         public void contextTest(){
        	 log.info(context.getApplicationName());
        	   Assert.assertNotNull(context.getBean("dataSource"));
         }
        @Before
         public void context(){
        	 ClassPathXmlApplicationContext c= new ClassPathXmlApplicationContext("spring-db.xml");
        	 context = c;
        	// Assert.assertNotNull(c.getBean("userMapper"));
         }
}
