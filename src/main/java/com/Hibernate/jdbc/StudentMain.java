package com.Hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {

	public static void main(String[] args) {
		// Insert and read database

		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session =sf.getCurrentSession();
		
		try {
			Student st1=new Student("neha","khatriya","neha@gmail.com");
			Student st2=new Student("zayn","malik","zayn@gmail.com");
			session.beginTransaction();
			session.save(st1);
			session.save(st2);
			session.getTransaction().commit();
			Session sessionn =sf.getCurrentSession();
			sessionn.beginTransaction();
			Student Readst=sessionn.get(Student.class,st1.getId());
			sessionn.getTransaction().commit();
			System.out.print(Readst.toString());
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
