package org.foobarspam.proyectofinal.model;

import javax.persistence.*;

/**
 * Created by palliser on 27/05/2017.
 */
@Entity
public class Carrera {

	@Id
	@GeneratedValue
	private Long id;
	private String origen;
	private String destino;
	private String modoPago;
	private double precioCarrera;
	private double propina;

	@OneToOne
	private Conductor conductor;

	@OneToOne
	private Valoracion valoracion;

	public Carrera() {
	}

	public Carrera(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getModoPago() {
		return modoPago;
	}

	public void setModoPago(String modoPago) {
		this.modoPago = modoPago;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	public double getCoste() {
		return precioCarrera;
	}

	public void setPrecioCarrera(double precioCarrera) {
		this.precioCarrera = precioCarrera;
	}

	public double getPropina() {
		return propina;
	}

	public void setPropina(double propina) {
		this.propina = propina;
	}
}
