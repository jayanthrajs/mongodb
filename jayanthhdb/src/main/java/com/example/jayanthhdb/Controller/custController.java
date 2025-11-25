package com.example.jayanthhdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jayanthhdb.Model.Customer;
import com.example.jayanthhdb.Repository.CustRepo;





@RestController
public class custController {
	@Autowired
	CustRepo CustRepo;
	
	@RequestMapping("/addCust")
	public String addCust(@RequestBody Customer customer) {
		CustRepo.save(customer);
		return "added successfully";
	}
	
	@GetMapping("/getCust")
	public List<Customer> getCust(){
		return (List<Customer>) CustRepo.findAll();
	}
	@DeleteMapping("delCust/{cid}")
	public String delCust(@PathVariable int cid) {
		CustRepo.deleteById(cid);
		return "record deleted successfully";
	}
	@PutMapping("updCust")
	public String updCust(@RequestBody Customer Customer) {
		Customer newCust=CustRepo.findById(Customer.getCid()).get();
		newCust.setCname(Customer.getCname());
		newCust.setCname(Customer.getFname());
		newCust.setCname(Customer.getLname());
		newCust.setCname(Customer.getLocation());
		CustRepo.save(newCust);
		return "record updated";
	}
		

}

