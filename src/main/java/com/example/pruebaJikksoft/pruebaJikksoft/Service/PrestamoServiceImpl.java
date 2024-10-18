package com.example.pruebaJikksoft.pruebaJikksoft.Service;

import java.util.List;
import java.util.Optional;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Prestamo;
import com.example.pruebaJikksoft.pruebaJikksoft.Repository.PrestamoDao;

public class PrestamoServiceImpl implements PrestamoService {

	private PrestamoDao prestamoDao;

	@Override
	public List<Prestamo> listaPrestamo() {
		return (List<Prestamo>) prestamoDao.findAll();
	}

	@Override
	public void guardar(Prestamo prestamo) {
		prestamoDao.save(prestamo);
	}

	@Override
	public void eliminar(Prestamo prestamo) {
		prestamoDao.delete(prestamo);
	}

	@Override
	public Optional<Prestamo> encontrarProducto(Prestamo prestamo) {
		return prestamoDao.findById(prestamo.getTransaction_id());
	}

}
