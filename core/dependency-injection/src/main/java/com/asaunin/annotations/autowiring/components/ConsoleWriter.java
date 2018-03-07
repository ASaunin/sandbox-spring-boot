package com.asaunin.annotations.autowiring.components;

import com.asaunin.annotations.autowiring.Writer;
import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("Console output: " + msg);
    }

}
