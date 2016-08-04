package com.bsangola.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Usuario")
public class Usuario extends Pessoa implements Serializable {

	private String login;
	private String senha;
	private List<Permissao> permissoes;
	private List<Artigo> artigosCadastrados;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@ManyToMany()
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	@OneToMany(mappedBy="publicante")
	public List<Artigo> getArtigosCadastrados() {
		return artigosCadastrados;
	}
	public void setArtigosCadastrados(List<Artigo> artigosCadastrados) {
		this.artigosCadastrados = artigosCadastrados;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}	
}
