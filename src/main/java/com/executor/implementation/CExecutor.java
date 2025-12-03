package com.executor.implementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.executor.Execution;
import com.executor.executionInfo.ExecutionInfo;
import com.reference.Language;

@Component
public class CExecutor implements Execution {

    private String entryClass;
    /**
     * Source code executor
     */
    @Override
    public String execute(String programCode) {
        String tempFileName = this.entryClass;
        File file = new File("D:\\SourceFile\\C\\" + tempFileName + ".c");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(programCode);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing to file: " + e.getMessage();
        }
        return this.execute(file);
    }

    /**
     * File execution
     */
    @Override
    public String execute(File programFile) {
        ExecutionInfo programExecutionDetails = new ExecutionInfo();
        Runtime runtime = Runtime.getRuntime();
        String programFilePath = programFile.getAbsolutePath();
        String classPath = programFilePath.substring(0, programFilePath.lastIndexOf("\\") + 1);
        String executableName = programFilePath.substring(programFilePath.lastIndexOf("\\") + 1, programFilePath.lastIndexOf("."));
        String programOutput = "";

        try {
            // Compile the C program
            Process compileProcess = runtime.exec("gcc -o " + classPath + executableName + " " + programFilePath);
            //  programOutput += "> COMPILING PROGRAM" + System.lineSeparator();
            //   programOutput += System.lineSeparator();
            programOutput += programExecutionDetails.show(Language.C, compileProcess);

            // Wait for the compilation to finish
            compileProcess.waitFor();

            // Execute the compiled program
            Process executeProcess = runtime.exec(classPath + executableName);
            // programOutput += "> EXECUTING PROGRAM" + System.lineSeparator();
            //  programOutput += System.lineSeparator();
            programOutput += programExecutionDetails.show(Language.C, executeProcess);

        } catch (IOException | InterruptedException e) {
            programOutput += "Server execution error: " + e.getMessage();
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
