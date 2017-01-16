package xml.autowiring.by.defolt;

import lombok.Data;
import xml.autowiring.ConsoleWriter;
import xml.autowiring.FileWriter;

import java.util.stream.Stream;

@Data
public class Logger {

    private FileWriter fileLogger;
    private ConsoleWriter consoleLogger;

    public void write(String msg) {
        Stream.of(fileLogger, consoleLogger).forEach(w -> {
            if (w != null)
                w.write(msg);
        });
    }

}
