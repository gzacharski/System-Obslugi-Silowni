package com.myprojects.gza.myGymApp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.myprojects.gza.myGymApp.helperClasses.UserAction;

@Entity
@Table(name = "user_login_logout_timestamp")
public class UserTimestamp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="action")
	private UserAction userAction;
	
	@Column(name="timestamp")
	private LocalDateTime timestamp;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH}, 
	fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public UserTimestamp() {}

	public UserTimestamp(UserAction userAction, LocalDateTime timestamp, User user) {
		this.userAction = userAction;
		this.timestamp = timestamp;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserAction getUserAction() {
		return userAction;
	}

	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserTimestamp [id=" + id + ", userAction=" + userAction + ", timestamp=" + timestamp + "]";
	}
}
