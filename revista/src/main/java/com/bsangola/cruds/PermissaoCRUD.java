package com.bsangola.cruds;

import java.util.List;

import com.bsangola.modelos.Permissao;

public interface PermissaoCRUD {
	
	public List<Permissao> buscarTodos();
	public Permissao burcarPorCodigo(Long codigo);
	public void criar(Permissao permissao);
	public void elininar(Permissao permissao, Long codigo);

}
