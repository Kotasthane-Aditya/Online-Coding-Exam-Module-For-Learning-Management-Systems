package com.executor.records;

import java.util.List;

public interface RecordService {
    String saveRecord(RecordModel record);
    List<RecordModel> getAllRecords();
    RecordModel getRecordById(int rollNo);
    void deleteRecord(int rollNo);
    void deleteAllRecord();
}
