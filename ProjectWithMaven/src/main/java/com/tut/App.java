package com.tut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started.." );
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
//creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Ashu");
        st.setCity("Delhi");
        System.out.println(st);
   
//creating object of address class
        Address ad=new Address();
        ad.setStreet("street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new java.sql.Date(0));
        ad.setX(1234.4533);
        
//reading image
        FileInputStream fis = new FileInputStream("src/main/java/pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
     Session session = factory.openSession();
     session.beginTransaction();
     session.save(st);
     session.save(ad);
     session.getTransaction().commit();
     session.close();
     System.out.println("done..");
          }
}
