package com.myprojects.gza.myGymApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_equipment_list")
public class BoookingEquipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name="equipment_id")
	private int equipmentId;
	
	@Column(name="client_id")
	private int clientId;
	
	public BoookingEquipment(int id, String startTime, String endTime, int equipmentId, int clientId) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.equipmentId = equipmentId;
		this.clientId = clientId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "BoookingEquipment [bookingId=" + id + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", equipmentId=" + equipmentId + ", clientId=" + clientId + "]";
	}
}
