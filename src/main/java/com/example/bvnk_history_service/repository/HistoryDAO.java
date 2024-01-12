package com.example.bvnk_history_service.repository;



import com.example.bvnk_history_service.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface HistoryDAO extends JpaRepository<History, Long> { //try with crud or some else repo

	@Query("SELECT h FROM History h WHERE h.clientId = :clientId")
	Optional<History> findByClientId(@Param("clientId") Long clientId);
}
