package com.mkyong;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDetail;
import com.mkyong.util.HibernateUtil;

public class StockRun {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
//		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		session.beginTransaction();
//
//		Stock stock = new Stock();
//
//		stock.setStockCode("7052");
//		stock.setStockName("PADINI");
//
//		StockDetail stockDetail = new StockDetail();
//		stockDetail.setCompName("PADINI Holding Malaysia");
//		stockDetail.setCompDesc("one stop shopping");
//		stockDetail.setRemark("vinci vinci");
//		stockDetail.setListedDate(new Date());
//
//		stock.setStockDetail(stockDetail);
//		stockDetail.setStock(stock);
//
//		int stockId = (Integer)session.save(stock);
//		session.getTransaction().commit();
		
		StockRun a = new StockRun();
		int stockId = a.saveStock();
		System.out.println("Saved id => " + stockId);
		System.out.println("going to list all the tasks ... ");
		a.listStock();
		
		System.out.println("Going to udate it ... ");
		a.updateStock(stockId);
		System.out.println("going to list all the tasks ... ");
		a.listStock();
		
		System.out.println("going to delete it  ... ");
		a.deleteStock(stockId);
		
		System.out.println("after deletion  ... ");
		a.listStock();
		System.out.println("Done ");
	}
	
	public int saveStock() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int stockId = 0;
		try {
			transaction = session.beginTransaction();

			Stock stock = new Stock();

			stock.setStockCode("7052");
			stock.setStockName("PADINI");

			StockDetail stockDetail = new StockDetail();
			stockDetail.setCompName("PADINI Holding Malaysia");
			stockDetail.setCompDesc("one stop shopping");
			stockDetail.setRemark("vinci vinci");
			stockDetail.setListedDate(new Date());

			stock.setStockDetail(stockDetail);
			stockDetail.setStock(stock);

			stockId = (Integer) session.save(stock);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stockId;
	}
	
	public void listStock() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List stocks = session.createQuery("from Stock").list();
			for (Iterator iterator = stocks.iterator(); iterator.hasNext();) {
				Stock stock = (Stock) iterator.next();
				System.out.println("stock name " + stock.getStockName());
				System.out.println("stock detail info " + stock.getStockDetail().getCompName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void updateStock(int stockId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, stockId);
			stock.setStockName("kalees");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void deleteStock(int stockId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, stockId);
			session.delete(stock);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
