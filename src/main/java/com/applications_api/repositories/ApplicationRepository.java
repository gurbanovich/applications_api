package com.applications_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.applications_api.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	@Modifying
	@Query("update Application as a set a.status='Executed' where a.id = :id")
	public void executeApp(@Param("id") Long id);

	@Modifying
	@Query("update Application as a set a.status='Refused' where a.id = :id")
	public void refuseApp(@Param("id") Long id);

	@Query("select count(*) from Application as a where a.status = 'Executed'")
	public int countExecutedApp();

	@Query("select count(*) from Application as a where a.status = 'Refused'")
	public int countRefusedApp();
}
