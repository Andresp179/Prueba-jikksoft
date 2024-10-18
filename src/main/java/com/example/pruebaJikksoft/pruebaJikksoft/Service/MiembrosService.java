package com.example.pruebaJikksoft.pruebaJikksoft.Service;

import java.util.List;
import java.util.Optional;

import com.example.pruebaJikksoft.pruebaJikksoft.Models.Miembros;

public interface MiembrosService {

	public List<Miembros> listaMiembro();

	public void guardar(Miembros miembro);

	public void eliminar(Miembros miembro);

	public Optional<Miembros> encontrarProducto(Miembros miembro);

}
