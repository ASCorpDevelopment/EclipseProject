package com.bsangola.servico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bsangola.daos.ArtigoDAO;
import com.bsangola.modelos.Artigo;
import com.bsangola.util.HibernateUtil;

@SuppressWarnings("serial")
public class Artigos implements Serializable {

	private EntityManager manager;
	private ArtigoDAO artigoDAO;
	private EntityTransaction transaction;

	public Artigos() {

	}

	private void init() {
		this.manager = HibernateUtil.getEntityManagerFactory().createEntityManager();
		this.artigoDAO = new ArtigoDAO(manager);
		this.transaction = manager.getTransaction();
	}

	public List<Artigo> buscarTodos() {
		init();
		return this.artigoDAO.buscarTodos();
	}

	public void criar(Artigo artigo){
		init();
		try {
			transaction.begin();
			this.artigoDAO.criar(artigo);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			this.manager.close();
		}
	}

	public Artigo buscarPorCodigo(Long codigo){
		init();
		return this.artigoDAO.burcarPorCodigo(codigo);
	}

	public void eliminar(Artigo artigo, Long codigo) {
		init();
		try {
			transaction.begin();
			this.artigoDAO.elininar(artigo, codigo);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			this.manager.close();
		}
		
	}
}
