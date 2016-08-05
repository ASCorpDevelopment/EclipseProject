package com.bsangola.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsangola.model.Cliente;
import com.bsangola.services.ClienteService;

@RestController
public class ClienteControler {
	
	
	@Autowired
	ClienteService clienteService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadstrarCliente(@RequestBody Cliente cliente){
		Cliente resposta = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(resposta, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes(){
		Collection resposta = clienteService.buscarTodos();
		return new ResponseEntity<Collection<Cliente>>(resposta, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/clientes/{codigo}")
	public ResponseEntity<Cliente> removerCliente(@PathVariable Integer codigo){
		
		Cliente clienteBuscado = clienteService.buscarPorCodigo(codigo);
		
		if(clienteBuscado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.remover(clienteBuscado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
