package org.develop.votogen.model.passport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.develop.votogen.security.SystemUser;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date insertedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date updatedDate;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(nullable = false)
	private SystemUser user;

	// constructor
	public Passport(SystemUser user) {
		super();
		this.user = user;
	}

	protected Passport() {
	}

	@PrePersist
	protected void onCreate() {
		insertedDate = updatedDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", insertedDate=" + insertedDate + ", updatedDate=" + updatedDate + "]";
	}

	// set e getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public SystemUser getUser() {
		return user;
	}

}
