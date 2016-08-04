package com.bsangola.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.cruds.PermissaoCRUD;
import com.bsangola.modelos.Permissao;

public class PermissaoDAO implements PermissaoCRUD{
	
	private EntityManager manager;
	
	public PermissaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Permissao> buscarTodos() {
		return this.manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao burcarPorCodigo(Long codigo) {
		return this.manager.find(Permissao.class, codigo);
	}

	@Override
	public void criar(Permissao permissao) {
		this.manager.merge(permissao);
	}

	@Override
	public void elininar(Permissao permissao, Long codigo) {
		this.manager.remove(this.manager.find(permissao.getClass(), codigo));
		this.manager.flush();	
	}

}
