package com.bsangola.cruds;

import java.util.List;

import com.bsangola.modelos.Usuario;

public interface UsuarioCRUD {
	
	public List<Usuario> buscarTodos();
	public Usuario burcarPorCodigo(Long codigo);
	public void editar(Long codigo);
	public void criar(Usuario usuario);
	public void elininar(Usuario usuario, Long codigo);

}
