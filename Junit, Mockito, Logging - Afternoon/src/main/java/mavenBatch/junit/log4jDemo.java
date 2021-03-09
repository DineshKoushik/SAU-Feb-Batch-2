package mavenBatch.junit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

public class log4jDemo {
	
	static Logger log = Logger.getLogger(log4jDemo.class.getName());
	   
	   public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      log.info("Going to create HelloWord Obj");
	      Log4jTest obj = (Log4jTest) context.getBean("helloWorld");
	      obj.getMessage();
	      
	      log.info("Exiting the program");
	      
	      ((ClassPathXmlApplicationContext) context).close();
	   }

}
