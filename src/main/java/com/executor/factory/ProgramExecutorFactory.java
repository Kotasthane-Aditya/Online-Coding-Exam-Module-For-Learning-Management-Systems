package com.executor.factory;

import com.executor.IExecutor;
import com.executor.impl.JavaExecutor;
import com.executor.impl.PythonExecutor;
import com.reference.Language;

/**
 * @author Onkar
 * @date 2018
 */
public class ProgramExecutorFactory<T> {

	/**
	 * @param language
	 * @return
	 */
	public static IExecutor getIExecutor(Language language) {
		IExecutor iExecutor = null;
		switch (language) {
		case JAVA:
			iExecutor = new JavaExecutor();
			break;
		case PYTHON:
			iExecutor = new PythonExecutor();
			break;
		default:
			break;
		}
		return iExecutor;
	}
}
