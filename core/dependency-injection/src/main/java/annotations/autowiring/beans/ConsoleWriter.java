package annotations.autowiring.beans;

import annotations.autowiring.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("Console output: " + msg);
    }

}
