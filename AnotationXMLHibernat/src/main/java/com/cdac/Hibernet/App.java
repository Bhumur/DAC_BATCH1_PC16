package com.cdac.Hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cdac.entity.User;

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
        //persist
        User obj = new User("hellobhumur","hellobhumur","Bhumur Agrawal","bhumur@gmail.com","Jaipur");
//        hibernateSession.beginTransaction();
//        hibernateSession.persist(obj);
//        hibernateSession.getTransaction().commit();
        
        //find
//        User user = hibernateSession.find(User.class, "admin");
//        System.out.println(user);
        
        //merge
//        hibernateSession.beginTransaction();
//        hibernateSession.merge(obj);
//        hibernateSession.getTransaction().commit();
        
        //remove
//        hibernateSession.beginTransaction();
//        hibernateSession.remove(obj);
//        hibernateSession.getTransaction().commit();
        
        
        //load
        hibernateSession.load(obj,"bhumur");
	    System.out.println(obj);
        
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("admin");
//        list.add("bhumur");
//        list.add("shubhu");
//        FindOption options = new FindOption(true, "name", 10, 0);
//        List<User> multiple = hibernateSession.findMultiple(User.class, list, FindOption.class);
//        System.out.println(multiple);
        
        
//        List<User> users = hibernateSession.createQuery("FROM User WHERE name IN :name", User.class)
//                .setParameter("name", list)
//                .getResultList();
//        System.out.println(users);
    }
}
