package com.executor.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository repository;

    @Override
    public String saveRecord(RecordModel record) {
        repository.save(record);
        return "code save";
    }

    @Override
    public List<RecordModel> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public RecordModel getRecordById(int rollNo) {
        return repository.findById(rollNo).orElse(null);
    }

    @Override
    public void deleteRecord(int rollNo) {
        repository.deleteById(rollNo);
    }

    @Override
    public void deleteAllRecord() {
        repository.deleteAll();
    }
}
