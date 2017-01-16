package annotations.autowiring.components;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"annotations.autowiring.components"})
public class AppConfig {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Logger logger = context.getBean(Logger.class);
        logger.write("Hello, Spring");
        context.close();
    }

}
