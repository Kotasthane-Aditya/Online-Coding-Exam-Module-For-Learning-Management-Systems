package com.executor.execution;

import com.executor.Execution;
import com.executor.implementation.CExecutor;
import com.executor.implementation.JavaExecutor;
import com.executor.implementation.PythonExecutor;
import com.reference.Language;

public class ProgramExecution<T> {
    public static Execution getIExecutor(Language language) {
        Execution iExecutor = null;
        switch (language) {
            case JAVA:
                iExecutor = new JavaExecutor();
                break;
            case PYTHON:
                iExecutor = new PythonExecutor();
                break;
            case C:
                iExecutor = new CExecutor();
                break;
            default:
                break;
        }
        return iExecutor;
    }
}