package annotations.autowiring.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"annotations.autowiring.beans"})
public class AppConfig {

    @Bean
    public FileWriter getFileWriter() {
        return new FileWriter();
    }

    @Bean
    public ConsoleWriter getConsoleWriter() {
        return new ConsoleWriter();
    }

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Logger logger = context.getBean(Logger.class);
        logger.write("Hello, Spring");
        context.close();
    }

}
