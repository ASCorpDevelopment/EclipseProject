package com.bsangola.servico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.daos.UsuarioDAO;
import com.bsangola.modelos.Usuario;
import com.bsangola.util.CalendarUtil;
import com.bsangola.util.FacesUtil;

@SuppressWarnings("serial")
public class Usuarios implements Serializable {

	private EntityManager manager;
	private UsuarioDAO usuarioDAO;

	public Usuarios() {
		this.manager = FacesUtil.getRequestManager();
		this.usuarioDAO = new UsuarioDAO(manager);
	}

	public List<Usuario> buscarTodos() {
		try {

			return this.usuarioDAO.buscarTodos();

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possivel buscar a lista dos usuário");
			e.printStackTrace();
		}
		return null;
	}

	public void criar(Usuario usuario) {
		try {
			if(usuario.getCodigo() != null){
				this.usuarioDAO.criar(usuario);
				FacesUtil.addMensagemInformacao("Usuario actualizado com sucesso!");
				this.manager.flush();
			}else{
				usuario.setDataCadastro(CalendarUtil.dataDeHoje());
				this.usuarioDAO.criar(usuario);
				FacesUtil.addMensagemInformacao("Usuario salvo com sucesso!");
				this.manager.flush();
			}
		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível efectuar a operação");
			e.printStackTrace();
		}
	}

	public Usuario buscarPorCodigo(Long codigo) {
		try {

			return this.usuarioDAO.burcarPorCodigo(codigo);

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível efectuar a operação");
			e.printStackTrace();
		}
		return null;
	}

	public void eliminar(Long codigo) {
		try {
			
			this.usuarioDAO.elininar(codigo);
			FacesUtil.addMensagemInformacao("Usuário eliminado com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível eliminar o usuário");
			e.printStackTrace();
		}
	}
}
