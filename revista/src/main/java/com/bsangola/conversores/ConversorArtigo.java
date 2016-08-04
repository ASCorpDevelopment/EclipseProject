package com.bsangola.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bsangola.modelos.Artigo;
import com.bsangola.servico.Artigos;

@FacesConverter(forClass=Artigo.class)
public class ConversorArtigo implements Converter{
	
	private Artigos artigos = new Artigos();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Artigo retorno = null;
		if( value != null ){
			retorno = (Artigo) this.artigos.buscarPorCodigo(new Long(value));
		}
		return retorno;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Long codigo = ((Artigo) value).getCodigo();
			String retorno = (codigo == null? null : codigo.toString());
			
			return retorno;
		}
		return "";
	}

}
