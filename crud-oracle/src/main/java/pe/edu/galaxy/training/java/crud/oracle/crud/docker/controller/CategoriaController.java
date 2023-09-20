package pe.edu.galaxy.training.java.crud.oracle.crud.docker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.CategoriaEntity;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.service.CategoriaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorias")
public class CategoriaController { 

	@Autowired
	CategoriaService categoriaService; 
	
	@GetMapping
	public List<CategoriaEntity> findAll() { 
		return categoriaService.findAll();
	}
	
	@GetMapping("/all/{nombre}")
	public Optional<CategoriaEntity> findByNombreIgnoreCase(@PathVariable String nombre) { 
		return categoriaService.findByNombreIgnoreCase(nombre);
	}

	@PostMapping
	public CategoriaEntity GuardarCategoria(@Valid @RequestBody CategoriaEntity categoria) { 
		return categoriaService.saveCategoria(categoria);
	}
	
	@PutMapping("/{id}")
	public CategoriaEntity ActualizarCategoria(@RequestBody CategoriaEntity categoria, @PathVariable Long id) {
		return categoriaService.updateCategoria(id, categoria);
	}

	@DeleteMapping("/{id}")
	public String eliminarCategoria(@PathVariable Long id) {
		categoriaService.deleteCategoria(id);
		return "Eliminado Correctamente";
	}
}