package com.Hibernate.Advancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hibernate.jdbc.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf= new Configuration().configure("hibernateadvmapping.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session =sf.getCurrentSession();
		
		try {
			InstructorDetails detail=new InstructorDetails("four","singing");
			Instructor inst=new Instructor("Zayn","Malik","Malik@123",detail);
			
			InstructorDetails detail2=new InstructorDetails("abc","singing");
			Instructor inst2=new Instructor("neha","khatriya","neha@123",detail2);
			session.beginTransaction();
			session.save(inst);
			session.save(inst2);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}

	}

}
