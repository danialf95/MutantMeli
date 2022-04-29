package com.meli.mutant.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(	name = "logauditadn" , schema = "test")
public class LogAuditAdn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer Identifier;
	
	@Column(name = "input_data")
	String Request;
	@Column(name = "verification")
	boolean status;
	@Column(name = "time")
	Timestamp time;
	
	public LogAuditAdn() {
	
	}
		
	public LogAuditAdn(Integer identifier, String request, boolean status, Timestamp time) {
		super();
		Identifier = identifier;
		Request = request;
		this.status = status;
		this.time = time;
	}
	
	public Integer getIdentifier() {
		return Identifier;
	}
	public void setIdentifier(Integer identifier) {
		Identifier = identifier;
	}
	public String getRequest() {
		return Request;
	}
	public void setRequest(String request) {
		Request = request;
	}
	public boolean getResponse() {
		return status;
	}
	public void setResponse(boolean status) {
		this.status = status;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
	
	
	
	
}
