package com.executor.controller;

import com.executor.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;


@RestController
public class ApplicationController {

    //    @Autowired
//    private ExecutorService executorService;
//
//    @RequestMapping(path = "/sourceExecutor", method = RequestMethod.POST, consumes = "application/json")
//    public ResponseEntity<String> executorServiceSource(@RequestBody String Data) throws IOException {
//        return this.executorService.executorServiceSource(Data);
//    }
    @Autowired
    private ExecutorService executorService;

    @RequestMapping(path = "/sourceExecutor", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> executorServiceSource(@RequestBody String Data) {
        java.util.concurrent.ExecutorService timeoutExecutor = Executors.newSingleThreadExecutor();
        Callable<ResponseEntity<String>> task = () -> executorService.executorServiceSource(Data);
        Future<ResponseEntity<String>> future = timeoutExecutor.submit(task);
        try {
            return future.get(5, TimeUnit.SECONDS); // wait max 5 seconds
        } catch (TimeoutException e) {
            future.cancel(true);
            return ResponseEntity.status(408).body("Execution timed out.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        } finally {
            timeoutExecutor.shutdown();
        }
    }
}