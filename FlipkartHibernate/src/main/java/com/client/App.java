package com.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Imp.Product;

public class App {
    public static void main( String[] args ){
    	
//    	Configuration cfg = new Configuration();
//    	cfg.configure();
//    	SessionFactory sf = cfg.buildSessionFactory();
//    	Session s = sf.openSession();
//    	
//    	Transaction tx = s.beginTransaction();
//    	
//    	//Adding Products to Flipkart
//    	
//    	Product p1 = new Product();
//    	p1.setPid(1);
//    	p1.setPname("T-Shirt");
//    	p1.setPrice(599);
//    	
//    	Product p2 = new Product();
//    	p2.setPid(2);
//    	p2.setPname("Jeans");
//    	p2.setPrice(1299);
//    	
//    	Product p3 = new Product();
//    	p3.setPid(3);
//    	p3.setPname("Mobile");
//    	p3.setPrice(22500);
//    	
//    	Product p4 = new Product();
//    	p4.setPid(4);
//    	p4.setPname("Watch");
//    	p4.setPrice(3999);
//    	
//    	Product p5 = new Product();
//    	p5.setPid(5);
//    	p5.setPname("Shoes");
//    	p5.setPrice(1699);
//    	
//    	s.save(p1);
//    	s.save(p2);
//    	s.save(p3);
//    	s.save(p4);
//    	s.save(p5);
//    	
//    	tx.commit();
//    	s.close();
   	
    	//program start
    	
    	
    	UserMethod u = new UserMethod();
    	
    	boolean flag = true;
    	
    	while(flag) {
    		
    		
    		Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Show All Products");
			System.out.println("4. Select Product");
			System.out.println("5. Delete User");
			System.out.println("6. Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 : u.Register();
			break;
			
			case 2 : u.Login();
			break;
			
			case 3 : u.ShowAllProducts();
			break;
			
			case 4 : u.SelectProduct();
			break;
			
			case 5 : u.DeleteUser();
			break;
			
			default : System.out.println("Thank You");
			          flag = false;
			break;
			
			}
    		
    	}
    	
    }
}
