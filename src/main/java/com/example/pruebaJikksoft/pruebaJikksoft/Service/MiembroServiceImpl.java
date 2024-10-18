package com.example.pruebaJikksoft.pruebaJikksoft.Service;

import java.util.List;
import java.util.Optional;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Miembros;
import com.example.pruebaJikksoft.pruebaJikksoft.Repository.MiembrosDao;

public class MiembroServiceImpl implements MiembrosService {

	private MiembrosDao miembrosDao;

	@Override
	public List<Miembros> listaMiembro() {
		return (List<Miembros>) miembrosDao.findAll();
	}

	@Override
	public void guardar(Miembros miembro) {
		miembrosDao.save(miembro);
	}

	@Override
	public void eliminar(Miembros miembro) {
		miembrosDao.delete(miembro);
	}

	@Override
	public Optional<Miembros> encontrarProducto(Miembros miembro) {

		return miembrosDao.findById(miembro.getMember_id());
	}

}
