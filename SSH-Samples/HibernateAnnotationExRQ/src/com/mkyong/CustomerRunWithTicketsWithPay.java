package com.mkyong;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.Address;
import com.mkyong.stock.Customer;
import com.mkyong.stock.Payment;
import com.mkyong.stock.Tickets;
import com.mkyong.util.HibernateUtil;

public class CustomerRunWithTicketsWithPay {
	public static void main(String[] args) {
		System.out.println("Hibernate Customer one to one (Annotation)");
		CustomerRunWithTicketsWithPay a = new CustomerRunWithTicketsWithPay();
		int customerId = a.saveCustomer1();
		System.out.println("Saved id => " + customerId);
//		System.out.println("going to list all the tasks ... ");
//		a.listCustomer();
		
//		System.out.println("Going to udate it ... ");
//		a.updateCustomer(customerId);
//		System.out.println("going to list all the tasks ... ");
//		a.listCustomer();
//		
//		System.out.println("going to delete it  ... ");
//		a.deleteCustomer(customerId);
//		
//		System.out.println("after deletion  ... ");
//		a.listCustomer();
//		System.out.println("Done ");
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
			
			Address address = new Address();
			address.setCity("cbe");
			address.setCountry("in");
			address.setStreet("CTM");
			address.setPhoneNumber(99423);
			
			// One to one relationshi
			customer.setAddress(address);
			address.setCustomer(customer);

			stockId = (Integer) session.save(customer);
			
			// One to many mapping
			Tickets ticket = new Tickets();
			ticket.setProblem("Not able to start the amchine. ");
			ticket.setRepairTye("office");
			ticket.setProblemFiledDate(new Date());
			ticket.setStatus("open");
			ticket.setStatusChangedDate(new Date());
			
			List<Tickets> tickets = new ArrayList<Tickets>();
			tickets.add(ticket);
//			tickets.add(ticket);
			
			ticket.setCustomer(customer);
			customer.setTickets(tickets);
			
			session.save(ticket);
			
			Payment payment = new Payment();
			payment.setAmount(100);
			payment.setPaymentDate(new Date());
			payment.setStaus("oen");
			payment.setTicket(ticket);
			ticket.setPayment(payment);
			
			session.save(ticket);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stockId;
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
			address.setPhoneNumber(99423);
			
			// One to one relationshi
			customer.setAddress(address);
			address.setCustomer(customer);

			// One to many mapping
			Tickets ticket = new Tickets();
			ticket.setProblem("Not able to start the amchine. ");
			ticket.setRepairTye("office");
			ticket.setProblemFiledDate(new Date());
			ticket.setStatus("open");
			ticket.setStatusChangedDate(new Date());
			
			Payment payment = new Payment();
			payment.setAmount(100);
			payment.setPaymentDate(new Date());
			payment.setStaus("oen");
			payment.setTicket(ticket);
			
			ticket.setPayment(payment);
			ticket.setCustomer(customer);
			
			List<Tickets> tickets = new ArrayList<Tickets>();
			tickets.add(ticket);
//			tickets.add(ticket);
			customer.setTickets(tickets);
			
			stockId = (Integer) session.save(customer);
			session.save(ticket);
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
				System.out.println("stock detail info " +customer.getTickets().get(0).getProblem());
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
//			customer.setName("Muthu ");
			customer.getTickets().get(0).setProblem("I udated the ticket... ");
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
