package com.executor.inputOutputProcess;

import java.util.Arrays;

public class OutputProcess {
    public String process(String output) {
       // System.out.println("OP -> \n" + output);
        if (output.startsWith("[") && output.endsWith("]")) {
            return Arrays.toString(output.toCharArray()).replaceAll("[\\[\\],]", "").replaceAll("\\s+", " ").trim();
        } else {
            return output.trim().replaceAll("\\s{2,}", " ");
        }
    }
}
