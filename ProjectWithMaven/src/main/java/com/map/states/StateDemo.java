package com.map.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// Practical of Hibernate Object States;
		//Transient state
		//Persistent
		//Detached
		//Removed
		System.out.println("Example:");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		//Creating S Student Object
		
		Student student = new Student();
		student.setId(1414);
		student.setName("No Name");
		student.setCity("Lucknow");
		student.setCerti(new Certificate("Java Hiberenate Course","2 month","Online"));
		//student : Transient
		
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//student: Persistent state (student object associated with session and database both
		student.setName("John");
		
		
		tx.commit();
		s.close();
		
		student.setName("Sachin");
		System.out.println(student);
		
	}

}
