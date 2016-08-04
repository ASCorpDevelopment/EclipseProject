package com.bsangola.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.bsangola.modelos.Usuario;
import com.bsangola.servico.Usuarios;

@FacesConverter(forClass=Usuario.class)
public class ConversorUsuario implements Converter{
	
	private Usuarios usuarios = new Usuarios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		if( value != null ){
			retorno = (Usuario) this.usuarios.buscarPorCodigo(new Long(value));
			
			if(retorno == null){
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuário não existe.", "Usuário não existe.");
				throw new ConverterException(message);
			}
		}
		return retorno;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Long codigo = ((Usuario) value).getCodigo();
			String retorno = (codigo == null? null : codigo.toString());
			
			return retorno;
		}
		return "";
	}
}
