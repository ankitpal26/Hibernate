package com.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
//		//Creating Question
//		Question q1 = new Question();
//	    q1.setQuestionId(1212);
//	    q1.setQuestion("What is Java ?");
//	    
//	    //creating Answer
//	    Answer answer = new Answer();
//	    answer.setAnswerId(343);
//	    answer.setAnswer("Java is programming language.");
//	    answer.setQuestion(q1);
//	    
//	    
//	    //creating Answer
//	    Answer answer1 = new Answer();
//	    answer1.setAnswerId(344);
//	    answer1.setAnswer("With help of java we can create a software");
//	    answer1.setQuestion(q1);
//	    
//	    //creating Answer
//	    Answer answer2= new Answer();
//	    answer2.setAnswerId(345);
//	    answer2.setAnswer("Java has differenet types of framwork.");
//	    answer2.setQuestion(q1);
//	    
//	    
//	    List<Answer> list = new ArrayList<Answer>();
//	    list.add(answer);
//	    list.add(answer1);
//	    list.add(answer2);
//	
//	   q1.setAnswers(list);
//	    //Session
	    Session s=factory.openSession();
	    Transaction tx = s.beginTransaction();
//		
//	    //save
//	   
//	    s.save(q1);
//	    s.save(answer);
//	    s.save(answer1);
//	    s.save(answer2);
//		
	    
	    
	    Question q= (Question)s.get(Question.class, 1212);
	    
	    System.out.println(q.getQuestion());
	    
	    for(Answer a:q.getAnswers())
	    {
	    	
	    	System.out.println(a.getAnswer());
	    	
	    }
	    
		tx.commit();
		
//		//fetching
//	Question newQuestion = (Question)s.load(Question.class, 1214);
//	System.out.println(newQuestion.getQuestion());
	
		factory.close();
	}

}
