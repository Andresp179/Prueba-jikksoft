package com.example.pruebaJikksoft.pruebaJikksoft.Models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "members")
public class Miembros implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long member_id;
	private String name;
	private String member_code;
	@Override
	public String toString() {
		return "Miembros [member_id=" + member_id + ", name=" + name + ", member_code=" + member_code + "]";
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public Miembros(Long member_id, String name, String member_code) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.member_code = member_code;
	}
	public Miembros() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
