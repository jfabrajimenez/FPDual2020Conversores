package es.fpdual2020.conversoresyvalidadores.vista.managedbeans;

import java.util.Date;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Usuario;
import es.fpdual2020.conversoresyvalidadores.servicio.excepciones.ValidacionUsuarioException;
import es.fpdual2020.conversoresyvalidadores.servicio.interfaz.ServicioUsuario;

@ViewScoped
@Component
public class FormEjercicioVista {

	@Autowired
	private ServicioUsuario servicioUsuario;

	private String nif;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private Integer edad;

	private Date fechaNacimiento;

	private String firma;

	public void resetearFirma() {
		this.firma = "";
	}

	public void guardar() {
		Usuario usuario = new Usuario();
		usuario.setNif(this.nif);
		usuario.setNombre(this.nombre);
		usuario.setApellido1(this.apellido1);
		usuario.setApellido2(this.apellido2);
		usuario.setEdad(this.edad);
		usuario.setFirma(this.firma);
		usuario.setFechaNacimiento(this.fechaNacimiento);

		try {
			this.servicioUsuario.guardar(usuario);
		} catch (ValidacionUsuarioException e) {
			this.mostrarError("El usuario no se ha podido guardar");
		}
	}

	public void noValidar() {
		this.mostrarWarn("No se ha validado el formulario");
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFirma() {
		return firma;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	protected boolean isBlank(String texto) {
		return Objects.isNull(texto) || texto == "";
	}

	protected void mostrarError(String error) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}

	protected void mostrarWarn(String warn) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", warn));
	}

	protected void mostrarInfo(String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", info));
	}
}
