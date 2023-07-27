package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//Creating Question
		Question q1 = new Question();
	    q1.setQuestionId(1212);
	    q1.setQuestion("What is Java ?");
	    
	    //creating Answer
	    Answer answer = new Answer();
	    answer.setAnswerId(343);
	    answer.setAnswer("Java is programming language.");
	    answer.setQuestion(q1);
	    q1.setAnswer(answer);
	    
	    
	    
	  //Creating Question
	    Question q2 = new Question();
	    q2.setQuestionId(1213);
	    q2.setQuestion("What is Hibernate? ");
	    
	    //creating Answer
	    Answer answer1 = new Answer();
	    answer1.setAnswerId(344);
	    answer1.setAnswer("Hibernate is framwork which is the implementation of JPA.");
	    answer1.setQuestion(q2);
	    q2.setAnswer(answer1);
	    
	    
	    
	  //Creating Question
	    Question q3 = new Question();
	    q3.setQuestionId(1214);
	    q3.setQuestion("What is mapping ?");
	    
	   
	  //creating Answer
	    Answer answer2 = new Answer();
	    answer2.setAnswerId(345);
	    answer2.setAnswer("mapping is concept to mapped the object with the table in the databases with the help of Hibernate framwork.");
	    answer2.setQuestion(q3);
	    q3.setAnswer(answer2);
	   
	    //Session
	    Session s=factory.openSession();
		
	    Transaction tx = s.beginTransaction();
		
	    //save
	    s.save(q1);
	    s.save(q2);
	    s.save(q3);
	    
	    s.save(answer);
	    s.save(answer1);
	    s.save(answer2);
	    
		
		tx.commit();
		
		//fetching
	Question newQuestion = (Question)s.load(Question.class, 1214);
	System.out.println(newQuestion.getQuestion());
	System.out.println(newQuestion.getAnswer().getAnswer());
	
		factory.close();
	}

}
