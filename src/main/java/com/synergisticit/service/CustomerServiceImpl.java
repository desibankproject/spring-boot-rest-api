package com.synergisticit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.dao.CustomerDaoRepository;
import com.synergisticit.dao.entity.CustomerEntity;
import com.synergisticit.web.rest.CustomerVO;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDaoRepository customerDao;
	
	@Override
	public CustomerVO findCustomerById(long cid){
		CustomerEntity customerEntity=customerDao.findOne(cid);
		CustomerVO customerVO=new CustomerVO();
		BeanUtils.copyProperties(customerEntity, customerVO);
		return customerVO;
	}
	
	@Override
	public CustomerVO findCustomerByName(String name){
		CustomerEntity customerEntity=customerDao.findByName(name);
		CustomerVO customerVO=new CustomerVO();
		BeanUtils.copyProperties(customerEntity, customerVO);
		return customerVO;
	}
	
	@Override
	public String saveCustomer(CustomerVO customerVO){
		CustomerEntity entity=new CustomerEntity();
		BeanUtils.copyProperties(customerVO, entity);
		customerDao.save(entity);
		return "done!";
	}
	
	@Override
	public int findCustomerCount(){
		int counts=customerDao.totalCustomers();
		return counts;
	}

}
