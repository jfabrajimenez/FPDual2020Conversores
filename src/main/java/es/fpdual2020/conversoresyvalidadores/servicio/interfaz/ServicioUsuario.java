package es.fpdual2020.conversoresyvalidadores.servicio.interfaz;

import java.util.List;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Usuario;
import es.fpdual2020.conversoresyvalidadores.servicio.excepciones.ValidacionUsuarioException;

public interface ServicioUsuario {
	public void guardar(Usuario usuario) throws ValidacionUsuarioException;

	public List<Usuario> getTodos();

	public Usuario get(String nif);

	public void modificar(String nifUsuarioViejo, Usuario usuarioNuevo) throws ValidacionUsuarioException;

	public void eliminar(Usuario usuario);

	public void eliminar(String nif);
}
