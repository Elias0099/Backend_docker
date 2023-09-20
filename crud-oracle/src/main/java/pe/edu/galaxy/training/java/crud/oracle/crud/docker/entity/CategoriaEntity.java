package pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
public class CategoriaEntity {
	
private static final long serialVersionUID = -2170897015344177815L;
	
	@Id
  	@Column(name = "ID_CATEGORIA")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategoria")
    @SequenceGenerator(sequenceName = "SEQ_CATEGORIA", allocationSize = 1, name = "seqCategoria")
	private Long id_categoria;
	

	@NotNull(message = "Nombre de la categoria es requerida")
	@Size(min = 1, max = 120, message = "El nombre.....")
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ESTADO")
	private String estado;

	
	
}
