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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "shows")
public class Show {
	
	// Generación de columnas de la tabla.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotEmpty(message = "Name cannot be empty.")
	private String name;

	@Column(nullable = false)
	@NotEmpty(message = "Network cannot be empty.")
	private String network;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date updatedAt;
	
	// Relaciones con el resto de tablas.

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ratings", joinColumns = @JoinColumn(name = "show_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> usersJoin;

	@OneToMany(mappedBy = "show", fetch = FetchType.LAZY)
	private List<Rating> ratings;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	// Constructor, métodos getters y setters.

	public Show() {
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String red) {
		this.network = red;
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

	public List<User> getUsersJoin() {
		return usersJoin;
	}

	public void setUsersJoin(List<User> usersJoin) {
		this.usersJoin = usersJoin;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Double avg() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double totalRating = 0.0;
        for (Rating rating : ratings) {
            totalRating += rating.getRating();
        }
        return totalRating / ratings.size();
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
