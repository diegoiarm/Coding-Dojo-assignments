package com.codingdojo.beltexamjava.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	// Generación de columnas de la tabla. 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotEmpty(message="Name cannot be empty. Please enter a valid name.")
	private String name;

	@Column(nullable = false)
    @NotEmpty(message="Email cannot be empty. Please enter a valid email address.")
	@Email(message = "{jakarta.validation.constraints.Email.message}")
	private String email;

	@Column(nullable = false)
	@NotEmpty(message="Password cannot be empty. Please enter a valid password.")
	@Size(min = 8, message = "{jakarta.validation.constraints.Size.min.message}")
	@Size(max = 255, message = "{jakarta.validation.constraints.Size.max.message}")
	private String password;

	@Transient
	@NotEmpty(message="Please confirm your password.")
	private String passwordConfirmation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date updatedAt;

	// Relaciones con el resto de tablas. 
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Show> createdShows;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Rating> ratings;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ratings", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "show_id"))
	private List<Show> Shows;
	
	// Constructor, métodos getters y setters.

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Show> getCreatedShows() {
		return createdShows;
	}

	public void setCreatedShows(List<Show> createdShows) {
		this.createdShows = createdShows;
	}

	public List<Show> getShows() {
		return Shows;
	}

	public void setShows(List<Show> shows) {
		Shows = shows;
	}
	
	// Anotaciones para fechas.

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
