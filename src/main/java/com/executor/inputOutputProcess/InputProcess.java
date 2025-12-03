package com.executor.inputOutputProcess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputProcess {
    public void process(String input){
        File file = new File("D:SourceFile\\Input\\inputPreDefined.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(input);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
