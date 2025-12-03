package com.executor.executionInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import com.reference.Language;

@Component
public class ExecutionInfo {
    public String show(Language language, Process process) {
        String executionOutput = "";
        String executionError = "";
        try {
            BufferedReader executionOutputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader executionErrorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            /**
             * PRINTING PROGRAM COMPILATION/EXECUTION OUTPUT
             */
            //  executionOutput += "OUTPUT: -> \n" + System.lineSeparator();
            //  executionOutput +=  System.lineSeparator();
            String s = null;
            while ((s = executionOutputStream.readLine()) != null) {
                executionOutput += s + System.lineSeparator();
                //  System.out.println(returnStrings.getExecutionOutput());
            }


            /**
             * PRINTING PROGRAM COMPILATION/EXECUTION ERRORS
             */
            //  executionOutput += "\n\n" + System.lineSeparator();
            while ((s = executionErrorStream.readLine()) != null) {
                // System.out.println(s);
                executionError += s + System.lineSeparator();
            }

            if (!executionError.isEmpty()) {
                return "\n\nTHERE ARE ERRORS IN YOUR CODE.......\n\n" + executionError;
            } else {
                return executionOutput;
            }

        } catch (IOException e) {
            executionOutput += "Service execution error";
            e.printStackTrace();
            return executionOutput;
        }
    }
}