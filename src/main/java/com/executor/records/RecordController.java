package com.executor.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping
    public String addRecord(@RequestBody RecordModel record) {
        System.out.println(record.getRollNo());
        System.out.println(record.getJava());
        System.out.println(record.getJava2());
        System.out.println(record.getC());
        System.out.println(record.getC2());
        System.out.println(record.getPython());
        System.out.println(record.getPython2());
        return (service.saveRecord(record));
    }

    @GetMapping
    public ResponseEntity<List<RecordModel>> getAllRecords() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<?> getRecordById(@PathVariable int rollNo) {
        RecordModel record = service.getRecordById(rollNo);
        if (record != null) {
            return ResponseEntity.ok(record);
        } else {
            return ResponseEntity.status(404).body("Record not found for Roll No: " + rollNo);
        }
    }

    @DeleteMapping("/delete/{rollNo}")
    public ResponseEntity<String> deleteRecord(@PathVariable int rollNo) {
        service.deleteRecord(rollNo);
        return ResponseEntity.ok("Record with Roll No " + rollNo + " deleted successfully.");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllRecord() {
        service.deleteAllRecord();
        return ResponseEntity.ok("all records deleted successfully.");
    }
}
