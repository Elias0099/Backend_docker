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
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.ProductoEntity;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.exceptions.ProductoNotFoundExceptions;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.service.ProductoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	ProductoService productoService; 
	
	@GetMapping
	public List<ProductoEntity> findAll() { 
		return productoService.findAll();
	}

	@GetMapping("/all/{nombre}")
	public Optional<ProductoEntity> findByNombre(@PathVariable String nombre) throws ProductoNotFoundExceptions { 
		return productoService.findByNombre(nombre);
	}
	
	@GetMapping("/all2/{nombre}")
	public Optional<ProductoEntity> findByNombreIgnoreCase(@PathVariable String nombre) { 
		return productoService.findByNombreIgnoreCase(nombre);
	}

	@PostMapping
	public ProductoEntity GuardarProducto(@Valid @RequestBody ProductoEntity producto) { 
		return productoService.saveProducto(producto);
	}
	
	@PutMapping("/{id}")
	public ProductoEntity ActualizarProducto(@RequestBody ProductoEntity producto, @PathVariable Long id) {
		return productoService.updateProducto(id, producto);
	}

	@DeleteMapping("/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.deleteProducto(id);
		return "Eliminado Correctamente";
	}

}