package com.example.lovehistory.history.repository;

import com.example.lovehistory.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}