package com.Hibernate.Advancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hibernate.jdbc.Student;

public class StudentMain {

	public static void main(String[] args) {


		//  to many to many
		
		
		SessionFactory sf= new Configuration().configure("hibernateadvmapping.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(com.Hibernate.Advancemapping.Student.class).
				addAnnotatedClass(Review.class).
				buildSessionFactory();
		Session session =sf.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			//create student and adding student to course
			com.Hibernate.Advancemapping.Student st1=new com.Hibernate.Advancemapping.Student("neha","khatriya","neha@gmail.com");
			com.Hibernate.Advancemapping.Student st2=new com.Hibernate.Advancemapping.Student("zayn","malik","zayn@gmail.com");
			int id=10;
			Course cs=session.get(Course.class, id);
			System.out.print(cs);
			cs.addStudent(st1);
			cs.addStudent(st2);
			session.save(st1);
			session.save(st2);
			
			//create course and adding course to student
			id=2;
			com.Hibernate.Advancemapping.Student st=session.get(com.Hibernate.Advancemapping.Student.class,id);
			Course cs1=new Course("Cubing");
			Course cs2=new Course("Java");
			st.addCourse(cs1);
			st.addCourse(cs2);
			
			session.save(cs1);
			session.save(cs2);
			
			//get course for student
			System.out.print(st.getCourses());
			
			session.getTransaction().commit();
			session.close();
			System.out.print("d");
		}
		catch(Exception e) {
			System.out.print(e);
		}

	}

}
