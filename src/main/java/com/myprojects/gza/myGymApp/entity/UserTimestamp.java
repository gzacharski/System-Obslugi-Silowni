package com.myprojects.gza.myGymApp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="user_id")
	private int userId;
	
	public UserTimestamp() {}

	public UserTimestamp(UserAction userAction, LocalDateTime timestamp, int userId) {
		this.userAction = userAction;
		this.timestamp = timestamp;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserLoginLogoutTimeStamp [id=" + id + ", userAction=" + userAction + ", timestamp=" + timestamp
				+ ", userId=" + userId + "]";
	}
}
