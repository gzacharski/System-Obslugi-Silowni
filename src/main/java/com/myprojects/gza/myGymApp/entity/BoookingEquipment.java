package com.myprojects.gza.myGymApp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "booking_equipment_list")
public class BoookingEquipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "start_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime startTime;
	
	@Column(name = "end_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime endTime;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.EAGER)
	@JoinColumn(name="equipment_id")
	private Equipment equipment;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public BoookingEquipment() {}

	public BoookingEquipment(LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public BoookingEquipment(LocalDateTime startTime, LocalDateTime endTime, Equipment equipment) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.equipment = equipment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BoookingEquipment [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", equipment="
				+ equipment + ", user=" + user + "]";
	}
}
