package com.Hibernate.Advancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hibernate.jdbc.Student;

public class DeleteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf= new Configuration().configure("hibernateadvmapping.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session =sf.getCurrentSession();
		
		try {
			
			//cascade delete
			session.beginTransaction();
			int id=1;
			Instructor inst=session.get(Instructor.class, id);
			if(inst!=null) {
				session.delete(inst);
			}
			else {
				System.out.println("instructor not found");
			}
			
			//bidirectional relation
			id=2;
			InstructorDetails detail=session.get(InstructorDetails.class, id);
			System.out.print(detail.getInstructor());
			
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}

	}

}
