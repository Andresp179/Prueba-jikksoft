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
@Table(name = "libro")
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long book_id;
	private String title;
	private String autor;
	private String isbn;
	private boolean is_available;
	
	
	public Libro() {
		super();
		
	}
	@Override
	public String toString() {
		return "Libro [book_id=" + book_id + ", title=" + title + ", autor=" + autor + ", isbn=" + isbn
				+ ", is_available=" + is_available + "]";
	}
	public Libro(Long book_id, String title, String autor, String isbn, boolean is_available) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.autor = autor;
		this.isbn = isbn;
		this.is_available = is_available;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isIs_available() {
		return is_available;
	}
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

}
