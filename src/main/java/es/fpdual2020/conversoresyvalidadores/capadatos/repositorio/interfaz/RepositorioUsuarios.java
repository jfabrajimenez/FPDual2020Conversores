package es.fpdual2020.conversoresyvalidadores.capadatos.repositorio.interfaz;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Usuario;

public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {

	/**
	 * Busca el usuario que tiene el NIF proporcionado.
	 * 
	 * @param nif Nif del usuario a buscar.
	 * @return Usuario que tiene el nif indicado.
	 */
	Usuario findByNif(String nif);

}
