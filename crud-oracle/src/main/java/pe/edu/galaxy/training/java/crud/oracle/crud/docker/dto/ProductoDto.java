package pe.edu.galaxy.training.java.crud.oracle.crud.docker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity.CategoriaEntity;

@Data
@AllArgsConstructor
public class ProductoDto {

	private String nombre;
	private String descripcion;
	private double precio;
	private String estado;
	private CategoriaEntity categoriaentity;
	
	
}
