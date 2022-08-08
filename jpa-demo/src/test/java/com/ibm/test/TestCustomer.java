package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ibm.dao.CustomerDao;
import com.ibm.entity.Customer;

public class TestCustomer {
	private static CustomerDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new CustomerDao();
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer(101, "George", 2000);
		dao.save(c);
	}
	
	@Test
	public void testFetch() {
		Customer c = dao.fetch(101);
		assertNotNull(c);
		System.out.println(c);
	}
	
	@Test
	public void testList() {
		List<Customer> customers = dao.list();
		assertFalse(customers.isEmpty());
		customers.forEach(System.out::println);
	}
	
	@Test
	public void testUpdate() {
		Customer c = new Customer(101, "George", 5000);
		dao.update(c);
	}
	
	@Test
	public void testDelete() {
		dao.delete(101);
	}
}
