package com.Hibernate.Advancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseMain {

	public static void main(String[] args) {
		// one to many + many to one 
		
		
				SessionFactory sf= new Configuration().configure("hibernateadvmapping.cfg.xml").addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
				Session session =sf.getCurrentSession();
				
				try {
					
					session.beginTransaction();
					int id=3;
					Instructor inst=session.get(Instructor.class, id);
					Course cs1=new Course("Guita");
					Course cs2=new Course("Pian");
					inst.addCourse(cs1);
					inst.addCourse(cs2);
					session.save(cs1);
					session.save(cs2);
					session.getTransaction().commit();
					session.close();
					System.out.print("d");
				}
				catch(Exception e) {
					System.out.print(e);
				}

	}

}
