package pe.edu.galaxy.training.java.crud.oracle.crud.docker.service;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.ProductoEntity;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.exceptions.ProductoNotFoundExceptions;

public interface ProductoService {

	List<ProductoEntity> findAll();

	ProductoEntity saveProducto(ProductoEntity producto);

	ProductoEntity updateProducto(Long id, ProductoEntity producto);

	void deleteProducto(Long id);

	Optional<ProductoEntity> findByNombre(String nombre) throws ProductoNotFoundExceptions;

	Optional<ProductoEntity> findByNombreIgnoreCase(String nombre);

}