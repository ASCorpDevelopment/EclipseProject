package com.bsangola.servico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bsangola.daos.UsuarioDAO;
import com.bsangola.modelos.Usuario;
import com.bsangola.util.HibernateUtil;

@SuppressWarnings("serial")
public class Usuarios implements Serializable {

	private EntityManager manager;
	private UsuarioDAO usuarioDAO;
	private EntityTransaction transaction;

	public Usuarios() {

	}

	private void init() {
		this.manager = HibernateUtil.getEntityManagerFactory().createEntityManager();
		this.usuarioDAO = new UsuarioDAO(manager);
		this.transaction = manager.getTransaction();
	}

	public List<Usuario> buscarTodos(){
		init();
		return this.usuarioDAO.buscarTodos();
	}

	public void criar(Usuario usuario){
		init();
		try {
			this.transaction.begin();
			this.usuarioDAO.criar(usuario);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
		}	
	}

	public Usuario buscarPorCodigo(Long codigo) {
		init();
		return this.usuarioDAO.burcarPorCodigo(codigo);
	}

	public void eliminar(Usuario usuario, Long codigo) {
		init();
		try {
			this.transaction.begin();
			this.usuarioDAO.elininar(usuario, codigo);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
		}
	}
	
	public void editar(Long codigo) {
		init();
		try {
			this.transaction.begin();
			this.usuarioDAO.editar(codigo);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
		}
	}
}
