package org.foobarspam.proyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by palliser on 27/05/2017.
 */
@Entity
public class Valoracion {

	@Id
	@GeneratedValue
	private Long id;
	private double valoracion;

	@ManyToOne
	private Conductor conductor;

	//necesario JPA
	public Valoracion() {
	}

	public Valoracion(double valoracion, Conductor conductor) {
		this.valoracion = valoracion;
		this.conductor = conductor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
}

