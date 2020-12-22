package es.fpdual2020.conversoresyvalidadores.servicio.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Direccion;
import es.fpdual2020.conversoresyvalidadores.capadatos.repositorio.interfaz.RepositorioDirecciones;
import es.fpdual2020.conversoresyvalidadores.servicio.interfaz.ServicioDirecciones;

@Service
public class ServicioDireccionesImpl implements ServicioDirecciones {

	@Autowired
	private RepositorioDirecciones repositorioDirecciones;

	@Override
	@Transactional
	public void guardar(Direccion direccion) {
		this.repositorioDirecciones.save(direccion);
	}

}
