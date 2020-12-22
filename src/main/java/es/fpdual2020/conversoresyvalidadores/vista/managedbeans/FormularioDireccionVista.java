package es.fpdual2020.conversoresyvalidadores.vista.managedbeans;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Direccion;
import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Usuario;
import es.fpdual2020.conversoresyvalidadores.servicio.interfaz.ServicioDirecciones;

@ViewScoped
@Component
public class FormularioDireccionVista {

	@Autowired
	private ServicioDirecciones servicioDirecciones;

	private String calle;
	private Integer numero;
	private String bloque;
	private String puerta;

	private Usuario habitante1;
	private Usuario habitante2;
	private Usuario habitante3;

	private List<Usuario> getHabitantes() {
		return Arrays.asList(habitante1, habitante2, habitante3).stream().filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	public void guardar() {
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setNumero(numero);
		direccion.setBloque(bloque);
		direccion.setPuerta(puerta);
		direccion.setHabitantes(this.getHabitantes());

		this.servicioDirecciones.guardar(direccion);
	}

	public ServicioDirecciones getServicioDirecciones() {
		return servicioDirecciones;
	}

	public void setServicioDirecciones(ServicioDirecciones servicioDirecciones) {
		this.servicioDirecciones = servicioDirecciones;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public Usuario getHabitante1() {
		return habitante1;
	}

	public void setHabitante1(Usuario habitante1) {
		this.habitante1 = habitante1;
	}

	public Usuario getHabitante2() {
		return habitante2;
	}

	public void setHabitante2(Usuario habitante2) {
		this.habitante2 = habitante2;
	}

	public Usuario getHabitante3() {
		return habitante3;
	}

	public void setHabitante3(Usuario habitante3) {
		this.habitante3 = habitante3;
	}

}
