package pe.edu.galaxy.training.java.crud.oracle.crud.docker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.crud.oracle.crud.docker.dto.CategoriaDto;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.CategoriaEntity;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.repository.CategoriaRepository;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public List<CategoriaEntity> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public CategoriaEntity saveCategoria(CategoriaEntity categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public CategoriaEntity updateCategoria(Long id, CategoriaEntity categoria) {
		CategoriaEntity categoriaBD = categoriaRepository.findById(id).orElse(null);
		if (categoriaBD != null) {
			if (categoria.getNombre() != null && !categoria.getNombre().isEmpty()) {
				categoriaBD.setNombre(categoria.getNombre());
			}
		}
		if (categoria.getDescripcion() != null) {
			categoriaBD.setDescripcion(categoria.getDescripcion());
		}

		if (categoria.getEstado() != null && !categoria.getEstado().isEmpty()) {
			categoriaBD.setEstado(categoria.getEstado());
		}

		return categoriaRepository.save(categoriaBD);

	}

	@Override
	public void deleteCategoria(Long id) { // Cambio de deleteCarrera a deleteCategoria
		categoriaRepository.deleteById(id);
	}

	@Override
	public Optional<CategoriaEntity> findByNombreIgnoreCase(String nombre) {
		return categoriaRepository.findByNombreIgnoreCase(nombre);
	}

	@Override
	public List<CategoriaDto> findCategoriaBy() {
		return categoriaRepository.findCategoriaBy();
	}
}
