package es.fpdual2020.conversoresyvalidadores.servicio.implementacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Usuario;
import es.fpdual2020.conversoresyvalidadores.capadatos.repositorio.interfaz.RepositorioUsuarios;
import es.fpdual2020.conversoresyvalidadores.servicio.excepciones.ValidacionUsuarioException;
import es.fpdual2020.conversoresyvalidadores.servicio.interfaz.ServicioUsuario;

public class ServicioUsuariosImpl implements ServicioUsuario {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;

	@Override
	@Transactional
	public void guardar(Usuario usuario) throws ValidacionUsuarioException {
		Map<Integer, String> errores = this.validar(usuario);

		if (!errores.isEmpty()) {
			throw new ValidacionUsuarioException(errores);
		}

		repositorioUsuarios.save(usuario);
	}

	private Map<Integer, String> validar(Usuario usuario) {
		Map<Integer, String> errores = new HashMap<>();

		if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
			errores.put(1, "El usuario tiene el nombre vacio");
		}

		if (usuario.getApellido1() == null || usuario.getApellido1().isEmpty()) {
			errores.put(2, "El usuario tiene el primer apellido vacio");
		}

		return errores;
	}

	@Override
	public List<Usuario> getTodos() {
		return this.repositorioUsuarios.findAll();
	}

	@Override
	public Usuario get(String nif) {
		return this.repositorioUsuarios.findByNif(nif);
	}

	@Override
	@Transactional
	public void modificar(String nifUsuarioViejo, Usuario usuarioNuevo) throws ValidacionUsuarioException {
		Map<Integer, String> errores = this.validar(usuarioNuevo);

		if (!errores.isEmpty()) {
			throw new ValidacionUsuarioException(errores);
		}

		this.eliminar(nifUsuarioViejo);
		repositorioUsuarios.save(usuarioNuevo);
	}

	@Override
	@Transactional
	public void eliminar(Usuario usuario) {
		this.eliminar(usuario.getNif());
	}

	@Override
	@Transactional
	public void eliminar(String nif) {
		Usuario usuarioAEliminar = this.repositorioUsuarios.findByNif(nif);
		this.repositorioUsuarios.delete(usuarioAEliminar);
	}

}
