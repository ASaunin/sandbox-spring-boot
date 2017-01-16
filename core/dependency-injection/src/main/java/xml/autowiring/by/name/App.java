package xml.autowiring.by.name;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:autowiring-by-name.xml");
        final Logger logger = context.getBean("logger", Logger.class);
        logger.write("Hello, Spring");
        context.close();
    }

}
