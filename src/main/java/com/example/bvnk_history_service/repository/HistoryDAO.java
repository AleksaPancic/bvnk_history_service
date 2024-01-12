package com.example.bvnk_history_service.repository;



import com.example.bvnk_history_service.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryDAO extends JpaRepository<History, Long> {

}
