package com.myprojects.gza.myGymApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pages")
public class Page {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "page")
	private String page;
	
	@Column(name = "number_of_views")
	private int numberOfViews;
	
	public Page() {}

	public Page(String page) {
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(int numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", page=" + page + ", numberOfViews=" + numberOfViews + "]";
	}
}
