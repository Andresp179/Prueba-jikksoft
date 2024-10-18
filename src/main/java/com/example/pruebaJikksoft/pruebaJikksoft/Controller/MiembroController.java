package com.example.pruebaJikksoft.pruebaJikksoft.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaJikksoft.pruebaJikksoft.Excepciones.ResourceNotFoundException;
import com.example.pruebaJikksoft.pruebaJikksoft.Models.Libro;
import com.example.pruebaJikksoft.pruebaJikksoft.Models.Miembros;
import com.example.pruebaJikksoft.pruebaJikksoft.Repository.MiembrosDao;

@RestController
@RequestMapping
public class MiembroController {

	@Autowired
	private MiembrosDao miembrosDao;

	@RequestMapping(value = "/api/v1/miembro", method = RequestMethod.GET)
	public List<Miembros> listarMiembro() {
		return miembrosDao.findAll();
	}

	@PostMapping("/api/v1/miembro")
	public Miembros guardarMiembro(@RequestBody Miembros miembro) {
		return miembrosDao.save(miembro);
	}

	@GetMapping("/api/v1/miembro/{id}")
	public ResponseEntity<Miembros> obtenerMiembroPorId(@PathVariable Long id) {
		Miembros miembro = miembrosDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el miembro con el ID : " + id));
		return ResponseEntity.ok(miembro);
	}

	@PutMapping("/api/v1/miembro/{id}")
	public ResponseEntity<Miembros> actualizarMiembro(@PathVariable Long id, @RequestBody Miembros detallesMiembro) {
		Miembros miembro = miembrosDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el miembro con el ID : " + id));

		miembro.setMember_id(detallesMiembro.getMember_id());
		miembro.setName(detallesMiembro.getName());
		miembro.setMember_code(detallesMiembro.getMember_code());

		Miembros miembroActualizado = miembrosDao.save(miembro);
		return ResponseEntity.ok(miembroActualizado);
	}

	@DeleteMapping("/api/v1//miembro/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarMiembro(@PathVariable Long id) {
		Miembros miembro = miembrosDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el miembro con el ID : " + id));

		miembrosDao.delete(miembro);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}

}
