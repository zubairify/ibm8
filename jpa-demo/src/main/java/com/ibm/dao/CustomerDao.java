package com.ibm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ibm.entity.Customer;

public class CustomerDao {

	private EntityManagerFactory factory;
	
	public CustomerDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public void save(Customer c) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(c);
		txn.commit();
		em.close();
	}
	
	public Customer fetch(int custId) {
		EntityManager em = factory.createEntityManager();
		Customer c = em.find(Customer.class, custId);
		return c;
	}
	
	public List<Customer> list() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("FROM Customer");
		
		return query.getResultList();
	}
	
	public void update(Customer c) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.merge(c);
		txn.commit();
		em.close();
	}
	
	public void delete(int custId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Customer c = em.find(Customer.class, custId);
		em.remove(c);
		txn.commit();
		em.close();
	}
}
