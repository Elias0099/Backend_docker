package pe.edu.galaxy.training.java.crud.oracle.crud.docker.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
@Table(name = "producto")
public class ProductoEntity {
	
	private static final long serialVersionUID = -2170897015344177815L;
	
	@Id
  	@Column(name = "ID_PRODUCTO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
    @SequenceGenerator(sequenceName = "SEQ_PRODUCTO", allocationSize = 1, name = "seqProducto")
	private Long id;
	

	@NotNull(message = "Nombre del producto es requerido")
	@Size(min = 1, max = 120, message = "El nombre.....")
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "PRECIO")
	private double precio;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne
    @JoinColumn(name = "id_categoria" , referencedColumnName = "ID_CATEGORIA") 
    private CategoriaEntity categoria;
	
	


}
