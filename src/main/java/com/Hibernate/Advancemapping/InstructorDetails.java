package com.Hibernate.Advancemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="youtube_channel")
	private String youtube;
	
	@OneToOne(mappedBy="details",cascade=CascadeType.ALL)
	private Instructor instructor;
	
	
	public InstructorDetails() {
		
	}
	
	public InstructorDetails(String youtube, String hobby) {
		super();
		this.youtube = youtube;
		this.hobby = hobby;
	}
	@Column(name="hobby")
	private String hobby;

	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtube=" + youtube + ", hobby=" + hobby + "]";
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
}
