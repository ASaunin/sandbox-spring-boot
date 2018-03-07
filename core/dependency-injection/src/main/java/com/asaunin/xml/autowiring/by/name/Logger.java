package com.asaunin.xml.autowiring.by.name;

import lombok.Data;
import com.asaunin.xml.autowiring.Writer;

import java.util.stream.Stream;

@Data
public class Logger {

    private Writer fileLogger;
    private Writer consoleLogger;

    public void write(String msg) {
        Stream.of(fileLogger, consoleLogger).forEach(w -> {
            if (w != null)
                w.write(msg);
        });
    }

}
