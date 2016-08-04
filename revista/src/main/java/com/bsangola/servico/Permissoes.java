package com.bsangola.servico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bsangola.daos.PermissaoDAO;
import com.bsangola.modelos.Permissao;
import com.bsangola.util.HibernateUtil;

@SuppressWarnings("serial")
public class Permissoes implements Serializable{

	private EntityManager manager;
	private PermissaoDAO permissaoDAO;
	private EntityTransaction transaction;
	
	public Permissoes() {
	}
	
	private void init(){
		this.manager = HibernateUtil.getEntityManagerFactory().createEntityManager();
		this.permissaoDAO = new PermissaoDAO(manager);
		this.transaction = manager.getTransaction();
	}

	public List<Permissao> buscarTodos(){
		init();
		return this.permissaoDAO.buscarTodos();
	}
	
	public void criar(Permissao permissao){
		init();
		try {
			this.transaction.begin();
			this.permissaoDAO.criar(permissao);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
		}
		
	}
	
	public Permissao buscarPorCodigo(Long codigo){
		init();
		return this.permissaoDAO.burcarPorCodigo(codigo);
	}
	
	public void eliminar(Permissao permissao, Long codigo){
		init();
		try {
			this.transaction.begin();
			this.permissaoDAO.elininar(permissao, codigo);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
		}
					
	}	
}
