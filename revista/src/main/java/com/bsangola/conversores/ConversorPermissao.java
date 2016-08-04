package com.bsangola.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bsangola.modelos.Permissao;
import com.bsangola.servico.Permissoes;

@FacesConverter("com.bsangola.ConversorPermissao")
public class ConversorPermissao implements Converter{
	
	private Permissoes permissoes = new Permissoes();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Permissao retorno = null;
		if( value != null ){
			retorno = (Permissao) this.permissoes.buscarPorCodigo(new Long(value));
		}
		return retorno;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Long codigo = ((Permissao) value).getCodigo();
			String retorno = (codigo == null? null : codigo.toString());
			
			return retorno;
		}
		return "";
	}
}
