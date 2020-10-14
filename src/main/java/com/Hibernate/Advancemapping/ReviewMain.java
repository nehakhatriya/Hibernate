package com.Hibernate.Advancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReviewMain {

	public static void main(String[] args) {
		// one-to-many 
		
		SessionFactory sf= new Configuration().configure("hibernateadvmapping.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session =sf.getCurrentSession();
		
		try {
			
			//cascade delete
			session.beginTransaction();
			
			Course crs=new Course("roadrash");
			
			crs.addReview(new Review("good job"));
			crs.addReview(new Review("good job keep going"));
			session.save(crs);
			int id=21;
			Course c=session.get(Course.class, id);
			System.out.print(c.getReviews());
			//cascade delete
			session.delete(c);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}

	}
}
