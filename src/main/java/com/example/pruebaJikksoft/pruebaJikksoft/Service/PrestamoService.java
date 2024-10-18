package com.example.pruebaJikksoft.pruebaJikksoft.Service;

import java.util.List;
import java.util.Optional;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Prestamo;

public interface PrestamoService {

	public List<Prestamo> listaPrestamo();

	public void guardar(Prestamo prestamo);

	public void eliminar(Prestamo prestamo);

	public Optional<Prestamo> encontrarProducto(Prestamo prestamo);

}
