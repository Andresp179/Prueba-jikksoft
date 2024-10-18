package com.example.pruebaJikksoft.pruebaJikksoft.Service;

import java.util.List;
import java.util.Optional;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Libro;

public interface LibroService {

	public List<Libro> listaLibros();

	public void guardar(Libro libro);

	public void eliminar(Libro libro);

	public Optional<Libro> encontrarProducto(Libro libro);

}
