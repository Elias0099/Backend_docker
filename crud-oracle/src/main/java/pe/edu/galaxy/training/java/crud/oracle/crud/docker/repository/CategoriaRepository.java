package pe.edu.galaxy.training.java.crud.oracle.crud.docker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.galaxy.training.java.crud.oracle.crud.docker.dto.CategoriaDto;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{

	Optional<CategoriaEntity> findByNombreIgnoreCase(String nombre);
	
	
	List<CategoriaDto> findCategoriaBy();
	
}
