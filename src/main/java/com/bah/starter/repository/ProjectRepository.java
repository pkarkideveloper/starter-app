package com.bah.starter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bah.starter.domain.ProjectData;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectData, Long> {

	List<ProjectData> findAllById (Long Id);
	//@Override
	//Iterable<ProjectData> findAllById(Iterable<Long> iterable);

}
