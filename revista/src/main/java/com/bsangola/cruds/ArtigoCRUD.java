package com.bsangola.cruds;

import java.util.List;

import com.bsangola.modelos.Artigo;

public interface ArtigoCRUD {
	
	public List<Artigo> buscarTodos();
	public Artigo burcarPorCodigo(Long codigo);
	public void criar(Artigo artigo);
	public void elininar(Artigo artigo, Long codigo);

}
