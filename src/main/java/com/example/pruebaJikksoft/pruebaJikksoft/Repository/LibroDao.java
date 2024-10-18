package com.example.pruebaJikksoft.pruebaJikksoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Libro;

public interface LibroDao extends JpaRepository<Libro, Long> {

}
