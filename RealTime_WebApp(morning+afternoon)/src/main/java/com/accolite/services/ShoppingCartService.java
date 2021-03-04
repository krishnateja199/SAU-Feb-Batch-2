package com.accolite.services;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.accolite.model.Quantity;
import com.accolite.model.ShoppingCart;

@Service
public class ShoppingCartService {


	public static List<ShoppingCart> getDetails() {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();	
		
		Query query = session.createQuery("from ShoppingCart");
    	@SuppressWarnings("unchecked")
		List<ShoppingCart> items =  query.getResultList();
    	for(ShoppingCart sc : items) {
    		
    		System.out.println(sc.getItemId());
    		System.out.println(sc.getItemName());
    		System.out.println(sc.getItemImageUrl());
    		System.out.println(sc.getItemQuantity());
    		System.out.println(sc.getItemPrice());
    		
    	}
    	return items;

	}
	
	public static List<Quantity> updateQuantity(List<Quantity> quantity) {
		
		for(Quantity q: quantity) {

			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			SessionFactory factory = configuration.buildSessionFactory();
			
			Session session = factory.openSession();	
			Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("update ShoppingCart set itemQuantity = itemQuantity- :oldQuantity  WHERE itemId = :id");
			query.setParameter("oldQuantity", q.getItemQuantity());
			query.setParameter("id", q.getItemId());
		    int result = query.executeUpdate();
		    System.out.println("Item Update Status="+result);
			tx.commit();
		}
		
		return null;
		
	}

}
