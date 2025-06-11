package com.cdac.FirstMaven;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cdac.entity.User;

import jakarta.persistence.FindOption;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration hibernateConfig = new Configuration();
        hibernateConfig.configure("first.cfg.xml");
        SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
        Session hibernateSession = hibernateFactory.openSession();
        
//        User obj = new User("shubhu","shubh@123","shubham","shubham@gmail","kolhapur");
//        hibernateSession.beginTransaction();
//        hibernateSession.persist(obj);
//        hibernateSession.getTransaction().commit();
        
        
//        User user = hibernateSession.find(User.class, "ADMiN");
//        System.out.println(user);
        
        
        
        
        ArrayList<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("bhumur");
        list.add("shubhu");
//        FindOption options = new FindOption(true, "name", 10, 0);
//        List<User> multiple = hibernateSession.findMultiple(User.class, list, FindOption.class);
//        System.out.println(multiple);
        
        
//        List<User> users = hibernateSession.createQuery("FROM User WHERE name IN :name", User.class)
//                .setParameter("name", list)
//                .getResultList();
//        System.out.println(users);
        
        
    }
}





























