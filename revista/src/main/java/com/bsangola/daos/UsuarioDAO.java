package com.bsangola.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.cruds.UsuarioCRUD;
import com.bsangola.modelos.Usuario;

public class UsuarioDAO implements UsuarioCRUD{
	
	private EntityManager manager;
	
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Usuario> buscarTodos() {
		return this.manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	@Override
	public Usuario burcarPorCodigo(Long codigo) {
		return this.manager.find(Usuario.class, codigo);
	}

	@Override
	public void criar(Usuario usuario) {
		this.manager.merge(usuario);
		this.manager.flush();
	}

	@Override
	public void elininar(Usuario usuario, Long codigo) {
		this.manager.remove(this.manager.find(usuario.getClass(), codigo));
		this.manager.flush();	
	}

	@Override
	public void editar(Long codigo) {
		Usuario usuario = this.burcarPorCodigo(codigo);
		this.criar(usuario);
	}

	
}
