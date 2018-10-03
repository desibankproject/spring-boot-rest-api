package com.synergisticit.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.service.CustomerService;

@RestController
public class CustomerRestAPI {
	
	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	
	//http://localhost:8080/v1/customer/paula
	@GetMapping("/customer/{fname}")
	//@PathVariable this is from spring mvc annotation
	public CustomerVO findCustomer(@PathVariable("fname") String name){
		CustomerVO customerVO=customerService.findCustomerByName(name);
		return customerVO;
	}
	
	@PostMapping("/customer")
	//@PathVariable this is from spring mvc annotation
	public ApplicationResponseVO saveCustomer(@RequestBody CustomerVO customerVO){
		String message=customerService.saveCustomer(customerVO);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setStatus("success");
		applicationResponseVO.setMessage(message);
		return applicationResponseVO;
	}
	
	@GetMapping("/customer/detail/{cid}")
	//@PathVariable this is from spring mvc annotation
	public CustomerVO findCustomerByCid(@PathVariable("cid") long cid){
		CustomerVO customerVO=customerService.findCustomerById(cid);
		return customerVO;
	}
	
	@GetMapping("/customer/count")
	//@PathVariable this is from spring mvc annotation
	@ResponseStatus(value=HttpStatus.OK)
	public ApplicationResponseVO findCustomerCount(){
		int count=customerService.findCustomerCount();
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setStatus("success");
		applicationResponseVO.setMessage(count+"");
		return applicationResponseVO;
	}

}
