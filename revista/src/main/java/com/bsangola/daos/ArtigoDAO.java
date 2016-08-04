package com.bsangola.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.cruds.ArtigoCRUD;
import com.bsangola.modelos.Artigo;
import com.bsangola.servico.NegocioException;

/**
 * 
 * @author adilson
 *
 */
public class ArtigoDAO implements ArtigoCRUD {

	private EntityManager manager;
	
	public ArtigoDAO(EntityManager manager){
		this.manager = manager;
	}

	@Override
	public List<Artigo> buscarTodos() throws NegocioException {
		return this.manager.createQuery("from Artigo", Artigo.class).getResultList();
	}

	@Override
	public Artigo burcarPorCodigo(Long codigo) throws NegocioException {
		return this.manager.find(Artigo.class, codigo);
	}

	@Override
	public void criar(Artigo artigo) throws NegocioException {
		this.manager.merge(artigo);
	}

	@Override
	public void elininar(Long codigo) throws NegocioException {
		this.manager.remove(this.burcarPorCodigo(codigo));
	}
}
