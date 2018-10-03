package com.synergisticit.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synergisticit.dao.entity.CustomerEntity;

@Repository
public interface CustomerDaoRepository extends CrudRepository<CustomerEntity, Long> {
	
	public CustomerEntity findByName(String name);
	public CustomerEntity findByNameAndEmail(String name,String email);
	
    @Query("SELECT count(*) from CustomerEntity")
	public  int totalCustomers();

}
