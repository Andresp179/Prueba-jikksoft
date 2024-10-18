package com.example.pruebaJikksoft.pruebaJikksoft.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long transaction_id;
	private Long member_id;
	private Long book_id;
	private Date borrow_date;
	private Date return_date;
	private String status;
	public Long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prestamo(Long transaction_id, Long member_id, Long book_id, Date borrow_date, Date return_date,
			String status) {
		super();
		this.transaction_id = transaction_id;
		this.member_id = member_id;
		this.book_id = book_id;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.status = status;
	}
	

}
