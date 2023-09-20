package pe.edu.galaxy.training.java.crud.oracle.crud.docker.service;

import java.util.List;
import java.util.Optional;



import pe.edu.galaxy.training.java.crud.oracle.crud.docker.dto.CategoriaDto;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.CategoriaEntity;



public interface CategoriaService { 

	List<CategoriaEntity> findAll(); 
    CategoriaEntity saveCategoria(CategoriaEntity categoria); 
    CategoriaEntity updateCategoria(Long id, CategoriaEntity categoria); 
    void deleteCategoria(Long id); 
    Optional<CategoriaEntity> findByNombreIgnoreCase(String nombre);
    List<CategoriaDto> findCategoriaBy();
    
}