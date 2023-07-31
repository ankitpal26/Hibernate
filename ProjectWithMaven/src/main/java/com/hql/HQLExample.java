package com.hql;


import com.tut.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();

        //HQl
        //syntax:
        //

        String query = "from Student where city='Lucknow'";
       Query q =  s.createQuery(query);

       //single - (Unique result)
        //multiple - list
        List<Student> list= q.list();
        for(Student student:list){
            System.out.println(student.getName() + " : " + student.getCerti().getCourse());
        }

        s.close();
        factory.close();
    }
}
