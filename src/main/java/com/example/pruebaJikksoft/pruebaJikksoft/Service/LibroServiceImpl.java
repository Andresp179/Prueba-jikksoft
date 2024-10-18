package com.example.pruebaJikksoft.pruebaJikksoft.Service;

import java.util.List;
import java.util.Optional;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Libro;
import com.example.pruebaJikksoft.pruebaJikksoft.Repository.LibroDao;

public class LibroServiceImpl implements LibroService {

	private LibroDao libroDao;

	@Override
	public List<Libro> listaLibros() {
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	public void guardar(Libro libro) {
		libroDao.save(libro);
	}

	@Override
	public void eliminar(Libro libro) {
		libroDao.delete(libro);
	}

	@Override
	public Optional<Libro> encontrarProducto(Libro libro) {
		return libroDao.findById(libro.getBook_id());
	}

}
