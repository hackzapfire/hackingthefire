package com.jstenio.zap_fire.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jstenio.zap_fire.ws.model.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer>{
	
	@Query("SELECT r FROM Recurso r WHERE r.userId=:userId")
	Recurso findByUserId(@Param("userId") String userId);
}
