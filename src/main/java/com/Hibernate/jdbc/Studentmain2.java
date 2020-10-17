package com.Hibernate.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Studentmain2 {

	public static void main(String[] args) {
		// Querying and updating database

		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
				buildSessionFactory();
		Session session =sf.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			//retrieving all records from table student
		List<Student> students=session.createQuery("from Student").list();
			students.forEach(System.out::println);
		
			//retrieving all records from table student which have firstname `neha`or lastname `khatriya`
			List<Student> student=session.createQuery("from Student s where s.firstName='neha' OR s.lastName='khatriya'").list();
			student.forEach(System.out::println);
			
			
			//retrieving all records from table student which have firstname contains a
			List<Student> studentss=session.createQuery("from Student s where s.firstName LIKE '%a%'").list();
			studentss.forEach(System.out::println);
			
			//updating email address
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			List<Student> stu=session.createQuery("from Student").list();
			stu.forEach(System.out::println);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}
