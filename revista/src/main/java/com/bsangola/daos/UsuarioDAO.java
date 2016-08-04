package com.bsangola.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.cruds.UsuarioCRUD;
import com.bsangola.modelos.Usuario;
import com.bsangola.servico.NegocioException;
import com.bsangola.util.FacesUtil;

/**
 * 
 * @author adilson
 *
 */
public class UsuarioDAO implements UsuarioCRUD{
	
	private EntityManager manager;
	
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Usuario> buscarTodos() throws NegocioException {
		return this.manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	
	@Override
	public Usuario burcarPorCodigo(Long codigo) throws NegocioException {
		return this.manager.find(Usuario.class, codigo);
	}

	@Override
	public void criar(Usuario usuario) throws NegocioException {
		this.manager.merge(usuario);
	}

	@Override
	public void elininar(Long codigo) throws NegocioException {
		this.manager.remove(burcarPorCodigo(codigo));
	}
}
