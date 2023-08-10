package com.codingdojo.listadeestudiantes.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, message = "Name must contain at least 2 characters.")
	@Size(max = 50, message = "Name must contain less than 50 characters.")
	@NotNull(message = "First name cannot be empty.")
	private String firstName;

	@Size(min = 2, message = "Last name must contain at least 2 characters.")
	@Size(max = 50, message = "Last name must contain less than 50 characters.")
	@NotNull(message = "Last name cannot be empty.")
	private String lastName;

	@Min(value = 16, message = "Minimum age should be 16.")
	@Max(value = 99, message = "Maximum age should be 99.")
	@NotNull(message = "Age cannot be empty.")
	private Integer age;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Contact contact;

	public Student() {
	}

	public Student(
			@Size(min = 4, message = "Name must contain at least 2 characters.") @Size(max = 50, message = "Name must contain less than 50 characters.") String firstName,
			@Size(min = 4, message = "Last name must contain at least 2 characters.") @Size(max = 50, message = "Last name must contain less than 50 characters.") String lastName,
			@Min(value = 16, message = "Minimum age should be 16.") @Max(value = 99, message = "Maximum age should be 99.") Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
    }

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
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