package com.bsangola.cruds;

import java.util.List;

import com.bsangola.modelos.Permissao;
import com.bsangola.servico.NegocioException;

/**
 * 
 * @author Adilson Cardoso
 *
 */
public interface PermissaoCRUD {
	
	/**
	 * 
	 * @return
	 * @throws NegocioException
	 */
	public List<Permissao> buscarTodos() throws NegocioException;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws NegocioException
	 */
	public Permissao burcarPorCodigo(Long codigo) throws NegocioException;
	
	/**
	 * 
	 * @param permissao
	 * @throws NegocioException
	 */
	public void criar(Permissao permissao) throws NegocioException;
	
	/**
	 * 
	 * @param codigo
	 * @throws NegocioException
	 */
	public void elininar(Long codigo) throws NegocioException;

}
