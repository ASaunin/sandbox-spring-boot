package com.asaunin.annotations.autowiring.beans;

import com.asaunin.annotations.autowiring.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("Console output: " + msg);
    }

}
