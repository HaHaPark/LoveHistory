package com.example.lovehistory.history.service;

import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.couple.repository.CoupleRepository;
import com.example.lovehistory.history.dto.HistoryReq;
import com.example.lovehistory.history.dto.HistoryRes;
import com.example.lovehistory.history.entity.History;
import com.example.lovehistory.history.repository.HistoryRepository;
import com.example.lovehistory.question.entity.Question;
import com.example.lovehistory.question.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final QuestionRepository questionRepository;
    private final CoupleRepository coupleRepository;

    public HistoryRes createHistory(Long coupleId, Long questionId, HistoryReq historyReq) {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        Optional<Couple> coupleOpt = coupleRepository.findById(coupleId);

        if (questionOpt.isPresent() && coupleOpt.isPresent()) {
            History history = historyReq.toEntity();
            history.setQuestion(questionOpt.get());
            history.setCouple(coupleOpt.get());
            History savedHistory = historyRepository.save(history);
            return HistoryRes.fromEntity(savedHistory);
        } else {
            throw new IllegalArgumentException("Invalid questionId or coupleId");
        }
    }

    public List<HistoryRes> getAllHistories() {
        List<History> histories = historyRepository.findAll();
        return histories.stream()
                .sorted(Comparator.comparing(History::getDatingDate).reversed()) // datingDate를 기준으로 내림차순 정렬
                .map(HistoryRes::fromEntity)
                .collect(Collectors.toList());
    }

    public HistoryRes updateHistory(Long datingHistoryId, HistoryReq historyReq) {
        Optional<History> historyOpt = historyRepository.findById(datingHistoryId);

        if (historyOpt.isPresent()) {
            History history = historyOpt.get();
            history.setDatingDate(historyReq.datingDate());
            history.setDatehistory(historyReq.datehistory());
            history.setAnswer(historyReq.answer());
            History updatedHistory = historyRepository.save(history);
            return HistoryRes.fromEntity(updatedHistory);
        } else {
            throw new IllegalArgumentException("Invalid datingHistoryId");
        }
    }

    public void deleteHistory(Long datingHistoryId) {
        if (historyRepository.existsById(datingHistoryId)) {
            historyRepository.deleteById(datingHistoryId);
        } else {
            throw new IllegalArgumentException("Invalid datingHistoryId");
        }
    }


}
