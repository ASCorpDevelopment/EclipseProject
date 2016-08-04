package com.bsangola.cruds;

import java.util.List;

import com.bsangola.modelos.Artigo;
import com.bsangola.servico.NegocioException;

/**
 * 
 * @author Adilson Cardoso
 *
 */
public interface ArtigoCRUD {
	
	/**
	 * 
	 * @return
	 * @throws NegocioException
	 */
	public List<Artigo> buscarTodos() throws NegocioException;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws NegocioException
	 */
	public Artigo burcarPorCodigo(Long codigo) throws NegocioException;
	
	/**
	 * 
	 * @param artigo
	 * @throws NegocioException
	 */
	public void criar(Artigo artigo) throws NegocioException;
	
	/**
	 * 
	 * @param codigo
	 * @throws NegocioException
	 */
	public void elininar(Long codigo) throws NegocioException;

}
