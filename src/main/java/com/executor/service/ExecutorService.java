package com.executor.service;

import com.executor.inputOutputProcess.InputProcess;
import com.executor.inputOutputProcess.OutputProcess;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.executor.execution.ProgramExecution;
import com.reference.Language;

@Service
public class ExecutorService {

	public ResponseEntity<String> executorServiceSource(@RequestBody String data) {
		String executionSymbol = "";
		JSONObject jsonData = new JSONObject(data);

		// LANGUAGE TYPE
		Language languageType = Language.valueOf(jsonData.getString("languageType"));

		// SOURCE Data
		String requestInput = jsonData.getString("input");

		//Pre-Defined Input
		String preDefineInput = jsonData.getString("preDefineInput");
		InputProcess inputProcess = new InputProcess();
		inputProcess.process(preDefineInput);

		//Pre-Defined Output
		String preDefineOutput = jsonData.getString("preDefineOutput");
		OutputProcess outputProcess = new OutputProcess();
		String preDefineOP = outputProcess.process(preDefineOutput);


		String output = "";
		executionSymbol += "*** Execution Warning/Errors OR Result ***";
		switch (languageType) {
			case JAVA:
				output = ProgramExecution.getIExecutor(Language.JAVA).entryClass(jsonData.getString("class")).execute(requestInput);
				break;
			case PYTHON:
				output = ProgramExecution.getIExecutor(Language.PYTHON).execute(requestInput);
				break;
			case C:
				output = ProgramExecution.getIExecutor(Language.C).execute(requestInput);
				break;
			default:
				output = "- Wrong request -";
		}

		String normalizedOutput = output.trim().replaceAll("\\s+", " ");
		String normalizedPreDefineOutput = preDefineOP.trim().replaceAll("\\s+", " ");

//        //Compare the normalized outputs
//        System.out.println();
//        System.out.println(normalizedOutput);
//        System.out.println(normalizedPreDefineOutput);

		if (preDefineOP.isEmpty()) {
			return new ResponseEntity<>("your manual input is  -> " + preDefineInput + "\nyour manual output is -> " + output, HttpStatus.OK);
		}

		if (normalizedOutput.equals(normalizedPreDefineOutput)) {
			output = languageType + "\n\n\n" + executionSymbol + "\n\n\npredefine output ->  \n" + preDefineOP + "\n\n\n     your output ->  \n" + output + "\n\nStatus of your output ->  Matched";
		} else {
			output = languageType + "\n\n\n" + executionSymbol + "\n\n\npredefine output ->  \n" + preDefineOP + "\n\n\n     your output ->  \n" + output + "\n\nStatus of your output ->  Not_Matched";
		}
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
