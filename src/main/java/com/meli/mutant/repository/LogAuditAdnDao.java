package com.meli.mutant.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.mutant.model.LogAuditAdn;
@Repository
public interface LogAuditAdnDao extends JpaRepository<LogAuditAdn, Integer>{

	
	@SuppressWarnings("unchecked")
	public LogAuditAdn saveAndFlush(LogAuditAdn log);
	
	@Query("SELECT COUNT(*) FROM LogAuditAdn log where log.Response = ?1")
	public Long countByStatus(boolean state);
}
