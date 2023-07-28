package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappinDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1=new Emp();
		Emp e2= new Emp();
		Emp e3=new Emp();
		
		e1.setEid(34);
		e1.setName("Ram");
		
		e2.setEid(35);
		e2.setName("shyam");
		
		e3.setEid(36);
		e2.setName("Sundar");
		
		
		Project p1 = new Project();
		Project p2 = new Project();
		Project p3 = new Project();
		
		p1.setPid(1212);
		p1.setProjectName("Library management system");
		
		p2.setPid(1213);
		p2.setProjectName("ChatBot");
		
		p3.setPid(1214);
		p3.setProjectName("Android Application for online Education");
		
		List<Emp> list1= new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		list1.add(e3);
		
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		
		
		//
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		
		Session s = factory.openSession();
		Transaction  tx = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(e3);
		s.save(p1);
		s.save(p2);
		s.save(p3);
		
		tx.commit();
		factory.close();
	}

}
