package com.bsangola.cruds;

import java.util.List;

import com.bsangola.modelos.Usuario;
import com.bsangola.servico.NegocioException;

/**
 * Interface 
 * @author Adilson Cardoso
 *
 */
public interface UsuarioCRUD {
	
	/**
	 * Este método faz uma consulta em um banco de dados e re
	 * @return
	 * @throws NegocioException
	 */
	public List<Usuario> buscarTodos() throws NegocioException;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws NegocioException
	 */
	public Usuario burcarPorCodigo(Long codigo) throws NegocioException;
	
	/**
	 * 
	 * @param usuario
	 * @throws NegocioException
	 */
	public void criar(Usuario usuario) throws NegocioException;
	
	/**
	 * 
	 * @param codigo
	 * @throws NegocioException
	 */
	public void elininar(Long codigo) throws NegocioException;

}
