package com.mkyong;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import com.mkyong.stock.Address;
import com.mkyong.stock.Customer;
import com.mkyong.stock.Payment;
import com.mkyong.stock.Tickets;
import com.mkyong.util.HibernateUtil;

public class CustomerRun {
	public static void main(String[] args) {
		System.out.println("Hibernate Customer one to one (Annotation)");
		CustomerRun a = new CustomerRun();
		
		a.saveTenCustomerTickets();
		a.getTenCustomerTickets();
		
//		1 starts
//		int customerId = a.saveCustomer1();
//		System.out.println("Saved id => " + customerId);
//		System.out.println("going to list all the tasks ... ");
//		
//		System.out.println("Going to udate it ... ");
//		a.updateCustomer1(customerId);
//		1 ends
		
//		a.listCustomer();
		
//		System.out.println("Going to udate it ... ");
//		a.updateCustomer(customerId);
//		System.out.println("going to list all the tasks ... ");
//		a.listCustomer();
		
//		System.out.println("going to delete it  ... ");
//		a.deleteCustomer(customerId);
//		
//		System.out.println("after deletion  ... ");
//		a.listCustomer();
		System.out.println("Done ");
	}
	
//	http://www.mkyong.com/hibernate/hibernate-criteria-examples/
//	http://www.mkyong.com/hibernate/hibernate-native-sql-queries-examples/
	public void getCustomerByPhoneNo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
//			// Onle line queries
//			Customer customer = (Customer) session.createCriteria(Customer.class).add( Restrictions.eq("uid", 5) ).uniqueResult();
			
			//Native sql query
			Customer customer = (Customer)session.createSQLQuery("select * from customer c where c.uid = :uid").addEntity(Customer.class).setParameter("uid", 5).uniqueResult();
			
			System.out.println("customer name => " + customer.getName());
			System.out.println("customer Address => " + customer.getAddress());
	        
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void saveTenCustomer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			for (int i = 0; i < 10; i++) {
				Customer customer = new Customer();
				customer.setName("kalees" + i);
				customer.setRegistrationDate(new Date());
				
				int custId = (Integer) session.save(customer);
				
				System.out.println("custId > " + custId);
			}
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void getTenCustomerTickets() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			// following a blog
			Criteria createCriteria = session.createCriteria(Tickets.class);
			List<Tickets> ticketObj = (List<Tickets>)createCriteria.add(Restrictions.like("repairTye", "office0%")).list();
			
			System.out.println("ticketObj > " + ticketObj.size());
			
			
//			Criteria createCriteria = session.createCriteria(Tickets.class);
//			Tickets ticketObj = (Tickets)createCriteria.add(Restrictions.eq("repairTye", "office0")).uniqueResult();
//			System.out.println("paymentObj > " + ticketObj.getTicketId());
//			System.out.println("Customer > " + ticketObj.getCustomer().getName());
			
			// working fine
//			Criteria criteria = session.createCriteria(Customer.class);
//			criteria.setFetchMode("Address", FetchMode.JOIN);
//			List resultList = criteria.list();
			
			
			
			// one query working fine
//			Criteria criteria = session.createCriteria(Customer.class,"customer")
//		    .createAlias("customer.address","address")
//		    .add(Restrictions.eq("address.phoneNumber", 998 ));
//		    List<Customer> resultList = criteria.list();
			
//			// Onle line queries
//			Customer customer = (Customer) session.createCriteria(Customer.class).add(Restrictions.eq("uid", 5) ).uniqueResult();
			
			//Native sql query
//			Customer customer = (Customer)session.createSQLQuery("select * from customer c where c.uid = :uid").addEntity(Customer.class).setParameter("uid", 5).uniqueResult();
			
//			System.out.println("customer name => " + customer.getName());
//			System.out.println("customer Address => " + customer.getAddress());
	        
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void saveTenCustomerTickets() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int stockId = 0;
		try {
			transaction = session.beginTransaction();

			for (int i = 0; i < 10; i++) {
				Customer customer = new Customer();
				customer.setName("kalees" + i);
				customer.setRegistrationDate(new Date());
				
				stockId = (Integer) session.save(customer);
				
				// One to many mapping
				Tickets ticket = new Tickets();
				ticket.setProblem("Not able to start the amchine. " + i);
				ticket.setRepairTye("office" + i);
				ticket.setProblemFiledDate(new Date());
				ticket.setStatus("open" + i);
				ticket.setStatusChangedDate(new Date());
				
				List<Tickets> tickets = new ArrayList<Tickets>();
				tickets.add(ticket);
				
				ticket.setCustomer(customer);
				customer.setTickets(tickets);
				
				session.save(ticket);
			}
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void saveTenCustomerAddress() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			for (int i = 0; i < 10; i++) {
				Customer customer = new Customer();
				customer.setName("kalees" + i);
				customer.setRegistrationDate(new Date());
				
				Address address = new Address();
				address.setCity("cbe" + i);
				address.setCountry("in" + i);
				address.setStreet("CTM" + i);
				address.setPhoneNumber(Integer.parseInt("99" + i));
				
				customer.setAddress(address);
				address.setCustomer(customer);
				
				int custId = (Integer) session.save(customer);
				
				System.out.println("custId > " + custId);
			}
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
//	REf:
//	http://stackoverflow.com/questions/12113592/how-to-inner-join-two-tables-using-hibernate-hql-or-criteria
//	http://stackoverflow.com/questions/12035152/hibernate-criteria-selection-from-two-tables-with-foreign-key-relationship
//	http://www.jroller.com/agileanswers/entry/multiple_join_criteria_queries_in
//	DetachedCriteria Example
//	http://java.dzone.com/articles/hibernate-example-part-2
//	http://www.jairrillo.com/blog/2009/01/29/how-to-use-left-join-in-hibernate-criteria/
//	http://technicalmumbojumbo.wordpress.com/2011/08/24/investigating-hibernate-fetch-strategy-tutorial/
	public void getCustomerByPhoneNo(String phoneNo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
//			http://www.mkyong.com/hibernate/hibernate-fetching-strategies-examples/
//			http://kruders.com/hibernate/hibernate-criteria/
//			https://netbeans.org/kb/docs/web/hibernate-webapp.html
//			https://netbeans.org/kb/docs/java/hibernate-java-se.html
			
			// working fine
//			Criteria criteria = session.createCriteria(Customer.class);
//			criteria.setFetchMode("Address", FetchMode.JOIN);
//			List resultList = criteria.list();
			
			// one query working fine
//			Criteria criteria = session.createCriteria(Customer.class,"customer")
//		    .createAlias("customer.address","address")
//		    .add(Restrictions.eq("address.phoneNumber", 998 ));
//		    List<Customer> resultList = criteria.list();
		    
//			executes 2 queries
//			Query q = session.createQuery("from Customer cust where uid=5");
//	        List<Customer> resultList = q.list();
//	        System.out.println("resultList size => " + resultList.size());
//	        System.out.println("UId => " + resultList.get(0).getName());
	        
			// Efficient then other queries
			Customer customer = (Customer) session.createCriteria(Customer.class)
	        .add( Expression.eq("uid", 5) ).uniqueResult();
			System.out.println("customer name => " + customer.getName());
	        
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public int saveCustomer1() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int stockId = 0;
		try {
			transaction = session.beginTransaction();

			Customer customer = new Customer();

			customer.setName("kalees");
			customer.setRegistrationDate(new Date());
			
			stockId = (Integer) session.save(customer);
			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stockId;
	}
	
	
	public void updateCustomer1(int customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			customer.setName("Muthu ");
			
			Address address = new Address();
			address.setCity("cbe");
			address.setCountry("in");
			address.setStreet("CTM");
			address.setPhoneNumber(12345);
			
			customer.setAddress(address);
			address.setCustomer(customer);
			
			session.save(customer);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public int saveCustomer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int stockId = 0;
		try {
			transaction = session.beginTransaction();

			Customer customer = new Customer();

			customer.setName("kalees");
			customer.setRegistrationDate(new Date());
			
			Address address = new Address();
			address.setCity("cbe");
			address.setCountry("in");
			address.setStreet("CTM");
			
			customer.setAddress(address);
			address.setCustomer(customer);

			stockId = (Integer) session.save(customer);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stockId;
	}
	
	public void listCustomer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List customers = session.createQuery("from Customer").list();
			for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
				Customer  customer = (Customer) iterator.next();
				System.out.println("stock name " + customer.getName());
				System.out.println("stock detail info " +customer.getAddress().getStreet());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void updateCustomer(int customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			customer.setName("Muthu ");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void deleteCustomer(int customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			session.delete(customer);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
