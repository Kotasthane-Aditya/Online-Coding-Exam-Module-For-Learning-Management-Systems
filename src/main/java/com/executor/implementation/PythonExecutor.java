package com.executor.implementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.reference.Language;
import org.springframework.stereotype.Component;

import com.executor.Execution;
import com.executor.executionInfo.ExecutionInfo;

@Component
public class PythonExecutor implements Execution {

	@Override
	public String execute(String programCode) {
		String tempFileName = "temp" + System.currentTimeMillis();
		File file = new File("D:SourceFile\\PYTHON\\" + tempFileName + ".py");
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

	@Override
	public String execute(File programFile) {
		ExecutionInfo programExecutionDetails = new ExecutionInfo();
		Runtime runtime = Runtime.getRuntime();
		String programFilePath = programFile.getAbsolutePath();
		String programOutput = "";
		try {
			// EXECUTE PROGRAM
			Process process = runtime.exec("python " + programFilePath);
		//	programOutput += "> EXECUTING" + System.lineSeparator();
			programOutput += programExecutionDetails.show(Language.PYTHON, process);
		} catch (IOException e) {
			programOutput += "Server execution error";
			e.printStackTrace();
		}
		return programOutput;
	}


	@Override
	public Execution entryClass(String entryClass) {
		return null;
	}
}
