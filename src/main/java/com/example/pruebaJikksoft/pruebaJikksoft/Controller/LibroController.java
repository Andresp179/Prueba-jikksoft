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
import com.example.pruebaJikksoft.pruebaJikksoft.Repository.LibroDao;

@RestController
@RequestMapping
public class LibroController {
	
	@Autowired
	private LibroDao libroDao;
	
	@RequestMapping(value = "/api/v1/libro", method = RequestMethod.GET)
	public List<Libro> listarLibro() {
		return libroDao.findAll();
	}

	@PostMapping("/api/v1/libro")
	public Libro guardarLibro(@RequestBody Libro libro) {
		return libroDao.save(libro);
	}
	
	@GetMapping("/api/v1/libro/{id}")
	public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
		Libro libro = libroDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el libro con el ID : " + id));
		return ResponseEntity.ok(libro);
	}
	
	@PutMapping("/api/v1/libro/{id}")
	public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id,@RequestBody Libro detallesLibro){
		Libro libro = libroDao.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("No existe el libro con el ID : " + id));
		
		libro.setBook_id(libro.getBook_id());
		libro.setAutor(detallesLibro.getAutor());
		libro.setIsbn(detallesLibro.getIsbn());
		libro.setTitle(detallesLibro.getTitle());
		libro.setIs_available(detallesLibro.isIs_available());
		
		Libro libroActualizado = libroDao.save(libro);
		return ResponseEntity.ok(libroActualizado);
    }
	

	@DeleteMapping("/api/v1//libro/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarLibro(@PathVariable Long id){
		Libro libro = libroDao.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("No existe el libro con el ID : " + id));
		
		libroDao.delete(libro);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
