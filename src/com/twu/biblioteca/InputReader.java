package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class InputReader {

    private BufferedReader bufferReader;

    public InputReader(BufferedReader bufferReader) {
        this.bufferReader = bufferReader;
    }

    public String readUserInput() {
        String option = null;
        try {
            option = bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return option;
    }
}