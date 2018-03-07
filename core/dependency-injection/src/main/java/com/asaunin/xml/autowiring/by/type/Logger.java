package com.asaunin.xml.autowiring.by.type;

import lombok.Data;
import com.asaunin.xml.autowiring.ConsoleWriter;
import com.asaunin.xml.autowiring.FileWriter;

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
