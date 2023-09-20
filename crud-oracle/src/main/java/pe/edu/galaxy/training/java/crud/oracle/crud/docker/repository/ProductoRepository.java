package pe.edu.galaxy.training.java.crud.oracle.crud.docker.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

	Optional<ProductoEntity> findByNombre(String nombre);
	
	Optional<ProductoEntity> findByNombreIgnoreCase(String nombre);


}
