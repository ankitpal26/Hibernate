package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
	       Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        Student student1 = new Student();
	        student1.setId(01);
	        student1.setName("Ankit Pal");
	        student1.setCity("Lucknow");
	        
	       
	        Certificate certificate = new Certificate();
	        certificate.setCourse("Android");
	        certificate.setDuation("3 Months");
	        certificate.setPlatform("Online");
	        student1.setCerti(certificate);
	        
	        Student student2 = new Student();
	        student2.setId(02);
	        student2.setName("Shivam Pal");
	        student2.setCity("Masena Mirzapur");
	        
	        Certificate certificate1 = new Certificate();
	        certificate1.setCourse("Web Developer");
	        certificate1.setDuation("1 year");
	        certificate1.setPlatform("Offline");
	        student2.setCerti(certificate1);
	        
	        Student student3 = new Student();
	        student3.setId(03);
	        student3.setName("Anshu");
	        student3.setCity("Indore");
	        
	        Certificate certificate2 = new Certificate();
	        certificate2.setCourse("Web Developer");
	        certificate2.setDuation("1 year");
	        certificate2.setPlatform("Online");
	        student3.setCerti(certificate2);
	        
	        Session s = factory.openSession();
	        Transaction tx=s.beginTransaction();
	        
	        //object save;
	        
	        s.save(student1);
	        s.save(student2);
	        s.save(student3);
	        
	        tx.commit();
	        s.close();
	        factory.close();
	}
}
