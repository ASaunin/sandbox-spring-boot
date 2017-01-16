package annotations.autowiring.components;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Data
@Component
public class Logger {

    @Autowired
    private FileWriter fileLogger;

    @Autowired
    private ConsoleWriter consoleLogger;

    public void write(String msg) {
        Stream.of(fileLogger, consoleLogger).forEach(w -> {
            if (w != null)
                w.write(msg);
        });
    }

}
