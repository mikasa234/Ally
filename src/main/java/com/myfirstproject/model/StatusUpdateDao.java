package com.myfirstproject.model;

import org.springframework.data.repository.CrudRepository;
//CRUD : create-retrieve-update-delete
public interface StatusUpdateDao extends CrudRepository<StatusUpdate, Long>{
	StatusUpdate findFirstByOrderByAddedDesc();
	
}
