package com.codingdojo.listadeestudiantes.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity

@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=5, message="Address must contain at least 5 characters.")
    @Size(max=50, message="Address must contain less than 50 characters.")
    @NotNull(message="Address cannot be empty.")
    private String address;
    
    @Size(min=3, message="City must contain at least 3 characters.")
    @Size(max=50, message="City must contain less than 50 characters.")
    @NotNull(message="City cannot be empty.")
    private String city;
    
    @Size(min=1, message="State must contain at least 1 character.")
    @Size(max=4, message="State must contain less than 4 characters.")
    @NotNull(message="State cannot be empty.")
    private String state;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
    @NotNull(message="Student cannot be empty.")
	private Student student;

	public Contact() {
	}


	public Contact(
			@Size(min = 5, message = "Address must contain at least 5 characters.") @Size(max = 50, message = "Address must contain less than 50 characters.") String address,
			@Size(min = 3, message = "City must contain at least 3 characters.") @Size(max = 50, message = "City must contain less than 50 characters.") String city,
			@Size(min = 1, message = "State must contain at least 1 character.") @Size(max = 4, message = "State must contain less than 4 characters.") String state,
			Student student) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
	
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

	@PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
	
	
}
