package com.executor.implementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.executor.Execution;
import com.executor.executionInfo.ExecutionInfo;
import com.reference.Language;

@Component
public class JavaExecutor implements Execution {

    private String entryClass;

    /**
     * Source code executor
     */
    @Override
    public String execute(String programCode) {
        String tempFileName = this.entryClass;
        File file = new File("D:SourceFile\\JAVA\\" + tempFileName + ".java");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(programCode);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.execute(file);
    }

    /**
     * File Execution
     */
    @Override
    public String execute(File programFile) {
        ExecutionInfo programExecutionDetails = new ExecutionInfo();
        Runtime runtime = Runtime.getRuntime();  // To execute the cmd commands
        String programFilePath = programFile.getAbsolutePath();
        String classPath = programFilePath.substring(0, programFilePath.lastIndexOf("\\") + 1); //extract the directory path of .java file
        String classFile = programFilePath.substring(programFilePath.lastIndexOf("\\") + 1, programFilePath.lastIndexOf(".")); //to extract the file name
        String programOutput = "";
        try {
            // COMPILE PROGRAM
            Process process = runtime.exec("javac " + programFilePath);
            //	programOutput += "> COMPILE PROGRAM" + System.lineSeparator();
            //	programOutput += System.lineSeparator();
            programOutput += programExecutionDetails.show(Language.JAVA, process);

            // EXECUTE PROGRAM
            process = runtime.exec("java -cp " + classPath + " " + classFile);
            //	programOutput += "> EXECUTE PROGRAM" + System.lineSeparator();
            //	programOutput +=  System.lineSeparator();
            programOutput += programExecutionDetails.show(Language.JAVA, process);
        } catch (IOException e) {
            programOutput += "Server execution error";
            e.printStackTrace();
        }
        return programOutput;
    }

    @Override
    public Execution entryClass(String entryClass) {
        this.entryClass = entryClass;
        return this;
    }

}
