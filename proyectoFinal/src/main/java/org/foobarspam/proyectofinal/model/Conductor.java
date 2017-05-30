package org.foobarspam.proyectofinal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by palliser on 27/05/2017.
 */

@Entity
public class Conductor {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	@NotNull
	private String matricula;
	private String modelo;
	private boolean ocupado = false;

	@OneToMany
	private List<Valoracion> valoraciones;

	//necesario JPA
	public Conductor() {
	}

	public Conductor(String nombre, String matricula, String modelo) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
		this.valoraciones = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

}
