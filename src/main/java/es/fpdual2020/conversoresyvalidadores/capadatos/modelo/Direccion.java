package es.fpdual2020.conversoresyvalidadores.capadatos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Direccion implements Serializable {
	private static final long serialVersionUID = -3261357190429350104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String calle;

	private Integer numero;

	private String bloque;

	private String puerta;

	@OneToMany(targetEntity = Usuario.class)
	private List<Usuario> habitantes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Usuario> getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(List<Usuario> habitantes) {
		this.habitantes = habitantes;
	}

}
