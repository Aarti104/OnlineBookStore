package com.cg.bookstore.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;

public class CustomCustomerRepositoryImpl implements CustomCustomerRepository{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Customer> getCustomerByCity(String city) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Customer c where c.address.city=:city";
		
		Query<Customer> query = session.createQuery(queryString);
		query.setString("city", city);
		
		List<Customer>  list = (List<Customer>) query.getResultList();
		
		if(list != null)
		{
			return list;
		}
		else
		{
			throw new javax.persistence.NoResultException("City Name Records Not In The DB");
		}
	}

	@Override
	public List<Customer> getCustomerByState(String state) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Customer c where c.address.state=:state";
		
		Query<Customer> query = session.createQuery(queryString);
		query.setString("state", state);
		
		List<Customer>  list = (List<Customer>) query.getResultList();
		
		if(list != null)
		{
			return list;
		}
		else
		{
			throw new javax.persistence.NoResultException("State Name Records Not In The DB");
		}
	}

	@Override
	public List<Customer> getCustomerByCountry(String country) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Customer c where c.address.country=:country";
		
		Query<Customer> query = session.createQuery(queryString);
		query.setString("country", country);
		
		List<Customer>  list = (List<Customer>) query.getResultList();
		
		if(list != null)
		{
			return list;
		}
		else
		{
			throw new javax.persistence.NoResultException("Contry Name Records Not In The DB");
		}
	}
	
}
