package com.synergisticit.service;

import com.synergisticit.web.rest.CustomerVO;

public interface CustomerService {

	CustomerVO findCustomerByName(String name);

	CustomerVO findCustomerById(long cid);

	int findCustomerCount();

	String saveCustomer(CustomerVO customerVO);

}
