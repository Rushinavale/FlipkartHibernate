package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.archive.scan.spi.ScanEnvironment;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Imp.Product;
import com.Imp.User;
import com.unImp.FlipkartInterface;

public class UserMethod implements FlipkartInterface {

	public void Register() {
		// TODO Auto-generated method stub
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User u1 = new User();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id ");
		int id = sc.nextInt();
		System.out.println("Enter you Name");
		String name = sc.next();
		System.out.println("Enter your Mobile");
		long mobileNo = sc.nextLong();
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();
		System.out.println("Confirm Password");
		String pass1 = sc.next();
		
		u1.setId(id);
		u1.setName(name);
		u1.setMobileNo(mobileNo);
		u1.setEmail(email);
		u1.setPass(pass);
//		u1.setCpass(pass1);
		for(int i = 0; i<1;i++) {
			if(pass.equals(pass1)) {
				u1.setCpass(pass1);
			}else {
				System.out.println("Password Not Match");
				i--;//we can provide two option re-enter password or visit to main menu
			}
		}
		
		session.save(u1);
		tx.commit();
		session.close();
		
	}

	public void Login() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("Enter your password");
		String pass= sc.next();
		
		Query query = s.createQuery("from User where email =: x");
//		query.
		try {
			 query.setParameter("x", email);
			
			List<User> l1 = query.list();
			for(User u : l1) {
				String email2 = u.getEmail();
				String pass2 = u.getPass();
				String name = u.getName();
				
				if(email2.equals(email) && pass.equals(pass2)) {
					System.out.println("***********************");
					System.out.println(" Welcome " + name);
					System.out.println("**********************");
				}else if(!email2.equals(email) || !pass.equals(pass2)) {
					System.out.println("Enter Correct Email or Password");
				}
				else {
					System.out.println("Enter Correct Email or Password");
				}
			
			}
			
			
		}catch( Exception e) {
			System.out.println("Enter Correct Email");
			
		}
		
		
		
//		List<User> l1 = query.list();
//		for(User u : l1) {
//			String email2 = u.getEmail();
//			String pass2 = u.getPass();
//		}
		
	}

	public void ShowAllProducts() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Query<Product> query = s.createQuery("from Product");
		List<Product> l1 = query.list();
		for(Product p1 : l1) {
			System.out.println(p1.getPid());
			System.out.println(p1.getPname());
		}
		
	}

	public void SelectProduct() {
		// TODO Auto-generated method stub
		ShowAllProducts();
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Product Id ");
		int id = sc.nextInt();
		
		Query query = s.createQuery("from Product where id = : x");
		query.setParameter("x",id);
		List<Product> l1 = query.list();
		for(Product p1 : l1) {
			System.out.println(p1.getPid());
			System.out.println(p1.getPname());
			System.out.println(p1.getPrice());
		}
		
	}
	
	public void DeleteUser() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email to delete user");
		int id = sc.nextInt();
		
	
//		Query query = s.createQuery("delete from User u where u.email =: x");
//		query.setParameter("x", email);
//		s.delete(object);
//		int row = query.executeUpdate();
		
		User u1 = s.get(User.class, id);
		
		
		s.save(u1);
		s.delete(u1);
		tx.commit();
		s.close();
		
	}
	
	
}
