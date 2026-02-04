package com.learning.dev.spring.myfirstapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	
	
	private int ticket_no;
	private int customer_id;
	private String subject;
	private String description;
	private String priority;
	private String status;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	
	public Ticket() {
		
	}
	
	public Ticket(int ticket_no, int customer_id, String subject, String description, String priority, String status,
			LocalDateTime create_at, LocalDateTime update_at) {
		super();
		this.ticket_no = ticket_no;
		this.customer_id = customer_id;
		this.subject = subject;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTicket_no() {
		return ticket_no;
	}

	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}

	public LocalDateTime getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticket_no=" + ticket_no + ", customer_id=" + customer_id + ", subject=" + subject
				+ ", description=" + description + ", priority=" + priority + ", status=" + status + ", create_at="
				+ create_at + ", update_at=" + update_at + "]";
	}
	
	
	
	
}
