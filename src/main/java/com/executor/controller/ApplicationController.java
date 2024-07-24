package com.executor.controller;

import com.executor.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ApplicationController {

    @Autowired
    private ExecutorService executorService;

    @RequestMapping(path = "/sourceFileExecutor", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<String> executorServiceFile(@RequestPart MultipartFile sourceFile, @RequestPart String requestData) throws IOException {
        return this.executorService.executorServiceFile(sourceFile, requestData);
    }

    @RequestMapping(path = "/sourceExecutor", method = RequestMethod.POST)
    public ResponseEntity<String> executorServiceSource(@RequestBody String requestData) throws IOException {
        return this.executorService.executorServiceSource(requestData);
    }
}