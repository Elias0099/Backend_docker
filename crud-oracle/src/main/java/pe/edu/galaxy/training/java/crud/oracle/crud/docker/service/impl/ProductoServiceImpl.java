package pe.edu.galaxy.training.java.crud.oracle.crud.docker.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.ProductoEntity;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.exceptions.ProductoNotFoundExceptions;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.repository.ProductoRepository;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService { // Cambio de AlumnoServiceImpl a ProductoServiceImpl
	
	@Autowired
	ProductoRepository productoRepository; // Cambio de AlumnoRepository a ProductoRepository

	@Override
	public List<ProductoEntity> findAll() { // Cambio de List<Alumno> a List<Producto>
		return productoRepository.findAll();
	}

	@Override
	public ProductoEntity saveProducto(ProductoEntity producto) { // Cambio de saveAlumno a saveProducto
		return productoRepository.save(producto);
	}

	@Override
	public ProductoEntity updateProducto(Long id, ProductoEntity producto) { // Cambio de updateAlumno a updateProducto
		ProductoEntity productoBD = productoRepository.findById(id).get();
		if (Objects.nonNull(producto.getNombre()) && !"".equalsIgnoreCase(producto.getNombre())){
			productoBD.setNombre(producto.getNombre());					
		 }

        if (producto.getDescripcion() != null) {
            productoBD.setDescripcion(producto.getDescripcion());
        }
        
        if (producto.getPrecio() > 0) {
            productoBD.setPrecio(producto.getPrecio());
        }
        
        if (producto.getEstado() != null && !producto.getEstado().isEmpty()) {
            productoBD.setEstado(producto.getEstado());
        }
        
        if (producto.getCategoria() != null) {
            productoBD.setCategoria(producto.getCategoria());
        }
		

		return productoRepository.save(productoBD);
	}

	@Override
	public void deleteProducto(Long id) { // Cambio de deleteAlumno a deleteProducto
		productoRepository.deleteById(id);
	}

	@Override
	public Optional<ProductoEntity> findByNombre(String nombre) throws ProductoNotFoundExceptions { // Cambio de findByNombre a findByNombre
		Optional<ProductoEntity> producto = productoRepository.findByNombre(nombre);
		if (!producto.isPresent()){
			throw new ProductoNotFoundExceptions("El nombre no está presente");
		}
		return producto;
	}

	@Override
	public Optional<ProductoEntity> findByNombreIgnoreCase(String nombre) { // Cambio de findByNombreIgnoreCase a findByNombreIgnoreCase
		return productoRepository.findByNombreIgnoreCase(nombre);
	}
}
