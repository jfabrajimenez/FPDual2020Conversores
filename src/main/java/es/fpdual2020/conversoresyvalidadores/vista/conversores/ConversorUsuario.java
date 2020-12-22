package es.fpdual2020.conversoresyvalidadores.vista.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.fpdual2020.conversoresyvalidadores.capadatos.modelo.Usuario;
import es.fpdual2020.conversoresyvalidadores.servicio.interfaz.ServicioUsuario;

@FacesConverter("conversorUsuario")
@Component
public class ConversorUsuario implements Converter {

	@Autowired
	private ServicioUsuario servicioUsuario;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Usuario usuario = servicioUsuario.get(value);

			if (usuario != null) {
				return usuario;
			}
		}

		throw new ConverterException("El nif proporcionado no corresponde a ningún usuario");
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof Usuario) {
			return ((Usuario) value).getNif();
		}

		throw new ConverterException("El objeto no tiene nif");
	}

}
