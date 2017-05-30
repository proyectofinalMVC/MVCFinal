package org.foobarspam.proyectofinal.service.component;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by palliser on 27/05/2017.
 */
@Component
public class Tarifa {

	private double COSTEMILLA = 1.35;
	private double COSTEMINUTO = 0.35;
	private double 	COSTEMINIMO = 5.00;
	private double distancia;
	private double minutos;
	private double costeTarifa;

	public Tarifa() {
	}

	public Tarifa(double distancia, double minutos) {
		this.distancia = distancia;
		this.minutos = minutos;
	}

	public double getCOSTEMILLA() {
		return COSTEMILLA;
	}

	public void setCOSTEMILLA(double COSTEMILLA) {
		this.COSTEMILLA = COSTEMILLA;
	}

	public double getCOSTEMINUTO() {
		return COSTEMINUTO;
	}

	public void setCOSTEMINUTO(double COSTEMINUTO) {
		this.COSTEMINUTO = COSTEMINUTO;
	}

	public double getCOSTEMINIMO() {
		return COSTEMINIMO;
	}

	public void setCOSTEMINIMO(double COSTEMINIMO) {
		this.COSTEMINIMO = COSTEMINIMO;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getMinutos() {
		return minutos;
	}

	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	public void setCosteTotal(double costeTotal) {
		this.costeTarifa = costeTotal;
	}

	public double getCosteDistancia(double distancia){
		return distancia * COSTEMILLA;
	}

	public double getCosteTiempo(double minutos){
		return minutos * COSTEMINUTO;
	}

	public double getCosteTarifa(){

		costeTarifa = getCosteDistancia(distancia) + getCosteTiempo(minutos);
		if (costeTarifa > COSTEMINIMO){
			return costeTarifa;
		}
		return COSTEMINIMO;
	}
}
