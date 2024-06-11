package com.example.lovehistory.history.controller;


import com.example.lovehistory.history.dto.HistoryReq;
import com.example.lovehistory.history.dto.HistoryRes;
import com.example.lovehistory.history.service.HistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping("/{coupleId}/{questionId}")
    public ResponseEntity<HistoryRes> createHistory(@PathVariable Long coupleId, @PathVariable Long questionId, @RequestBody HistoryReq historyReq) {
        HistoryRes historyRes = historyService.createHistory(coupleId, questionId, historyReq);
        return ResponseEntity.ok(historyRes);
    }

    @GetMapping
    public ResponseEntity<List<HistoryRes>> getAllHistories() {
        List<HistoryRes> histories = historyService.getAllHistories();
        return ResponseEntity.ok(histories);
    }

    @PutMapping("/{datingHistoryId}")
    public ResponseEntity<HistoryRes> updateHistory(@PathVariable Long datingHistoryId, @RequestBody HistoryReq historyReq) {
        HistoryRes historyRes = historyService.updateHistory(datingHistoryId, historyReq);
        return ResponseEntity.ok(historyRes);
    }

    @DeleteMapping("/{datingHistoryId}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long datingHistoryId) {
        historyService.deleteHistory(datingHistoryId);
        return ResponseEntity.noContent().build();
    }

}
