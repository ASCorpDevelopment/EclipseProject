package com.bsangola.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsangola.model.Cliente;
import com.bsangola.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente cadastrar(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public void remover(Cliente cliente){
		clienteRepository.delete(cliente);
	}
	
	public Cliente buscarPorCodigo(Integer codigo){
		return clienteRepository.findOne(codigo);
	}
	
	public void alterar(Cliente cliente){
		clienteRepository.save(cliente);
	}
}
