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
import com.example.pruebaJikksoft.pruebaJikksoft.Models.Miembros;
import com.example.pruebaJikksoft.pruebaJikksoft.Models.Prestamo;
import com.example.pruebaJikksoft.pruebaJikksoft.Repository.PrestamoDao;

@RestController
@RequestMapping
public class PrestamoController {

	@Autowired
	private PrestamoDao prestamoDao;

	@RequestMapping(value = "/api/v1/prestamo", method = RequestMethod.GET)
	public List<Prestamo> listarPrestamo() {
		return prestamoDao.findAll();
	}

	@PostMapping("/api/v1/prestamo")
	public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo) {
		return prestamoDao.save(prestamo);
	}

	@GetMapping("/api/v1/prestamo/{id}")
	public ResponseEntity<Prestamo> obtenerPrestamoPorId(@PathVariable Long id) {
		Prestamo prestamo = prestamoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el prestamo con el ID : " + id));
		return ResponseEntity.ok(prestamo);
	}

	@PutMapping("/api/v1/prestamo/{id}")
	public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamo detallesPrestamo) {
		Prestamo prestamo = prestamoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el prestamo con el ID : " + id));

		prestamo.setTransaction_id(detallesPrestamo.getTransaction_id());
		prestamo.setMember_id(detallesPrestamo.getMember_id());
		prestamo.setBook_id(detallesPrestamo.getBook_id());
		prestamo.setBorrow_date(detallesPrestamo.getBorrow_date());
		prestamo.setReturn_date(detallesPrestamo.getReturn_date());

		Prestamo prestamoActualizado = prestamoDao.save(prestamo);
		return ResponseEntity.ok(prestamoActualizado);
	}

	@DeleteMapping("/api/v1//prestamo/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarMiembro(@PathVariable Long id) {
		Prestamo prestamo = prestamoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el prestamo con el ID : " + id));

		prestamoDao.delete(prestamo);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}

}
