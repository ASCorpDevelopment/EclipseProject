package com.bsangola.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.cruds.ArtigoCRUD;
import com.bsangola.modelos.Artigo;

public class ArtigoDAO implements ArtigoCRUD {

	private EntityManager manager;
	
	public ArtigoDAO(EntityManager manager){
		this.manager = manager;
	}
	
	@Override
	public List<Artigo> buscarTodos() {
		return this.manager.createQuery("from Artigo", Artigo.class).getResultList();
	}

	@Override
	public Artigo burcarPorCodigo(Long codigo) {
		return this.manager.find(Artigo.class, codigo);
	}

	@Override
	public void criar(Artigo artigo) {
		this.manager.merge(artigo);
	}

	@Override
	public void elininar(Artigo artigo, Long codigo) {
		this.manager.remove(this.manager.find(artigo.getClass(), codigo));
		this.manager.flush();	
	}
}
