package com.cdac.SpringbootHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.cdac.SpringbootHibernate.entity.User;


@SpringBootApplication
@EntityScan("com.cdac.SpringbootHibernate.entity")
public class SpringbootHibernateApplication implements CommandLineRunner {

	@Autowired
	SessionFactory hiberFactory;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u = new User("manu", "manu", "Manu Garg", "manu@gmail.com", "jaipur");
		Session hibersession = hiberFactory.openSession();
		hibersession.beginTransaction();
		hibersession.persist(u);
		hibersession.getTransaction().commit();
		System.out.println("ADDEDD");
	}

}
