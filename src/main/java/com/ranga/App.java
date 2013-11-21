package com.ranga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ranga.mapping.Person;
import com.ranga.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person p1 = new Person();
		p1.setFirstName("ranga");
		p1.setLastName("reddy");
		p1.setAge(25);
		long personId = (Long) session.save(p1);
		session.getTransaction().commit();
		
		Person person = (Person) session.get(Person.class, personId);		
		System.out.println(person);
				
		session.close();
	}
}