package com.executor.service;

import java.io.File;
import java.io.IOException;


import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.executor.factory.ProgramExecutorFactory;
import com.reference.Language;

/**
 * @author Onkar
 * @date 2018
 */
@Service
public class ExecutorService {

	/**
	 * @param sourceFile
	 * @param requestData
	 * @throws IOException
	 */
	public ResponseEntity<String> executorServiceFile(@RequestPart MultipartFile sourceFile, @RequestPart String requestData) throws IOException {

		// SAVE FILE
		File file = new File("D:\\" + sourceFile.getOriginalFilename());
		sourceFile.transferTo(file);

		JSONObject requestJsonData = new JSONObject(requestData);

		JSONObject jo = requestJsonData.getJSONObject("requestData");
		// LANGUAGE TYPE
		Language requestLanguageType = Language.valueOf(jo.getString("languageType"));

		String output = "";
		switch (requestLanguageType) {
			case JAVA:
				output = ProgramExecutorFactory.getIExecutor(Language.JAVA).execute(file);
				break;
			case PYTHON:
				output = ProgramExecutorFactory.getIExecutor(Language.PYTHON).execute(file);
				break;
			default:
				output = "- Wrong request -";
		}
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	/**
	 * @param requestData
	 * @throws IOException
	 */
	public ResponseEntity<String> executorServiceSource(@RequestBody String requestData) {

		JSONObject requestJsonData = new JSONObject(requestData);

		// LANGUAGE TYPE
		Language requestLanguageType = Language.valueOf(requestJsonData.getString("languageType"));

		// SOURCE Data/ FILE
		String requestInput = requestJsonData.getString("input");

		String output = "";
		switch (requestLanguageType) {
			case JAVA:
				output = ProgramExecutorFactory.getIExecutor(Language.JAVA).entryClass(requestJsonData.getString("class")).execute(requestInput);
				break;
			case PYTHON:
				output = ProgramExecutorFactory.getIExecutor(Language.PYTHON).execute(requestInput);
				break;
			default:
				output = "- Wrong request -";
		}
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
