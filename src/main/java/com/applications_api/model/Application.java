package com.applications_api.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "applications")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", nullable = false)
	public long id;

	@Column(name = "request")
	public String request;

	@Column(name = "bid")
	public Double bid;

	@Column(name = "due_date")
	@JsonIgnoreProperties
	public String dueDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

	@Column(name = "status")
	public String status;

	public Application() {
	}

	public long getId() {
		return id;
	}

	public String getRequest() {
		return request;
	}

	public Double getBid() {
		return bid;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getStatus() {
		return status;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
