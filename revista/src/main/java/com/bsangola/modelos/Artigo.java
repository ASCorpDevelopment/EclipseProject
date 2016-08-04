package com.bsangola.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bsangola.enums.Categoria;
import com.bsangola.enums.Estado;

@SuppressWarnings("serial")
@Entity
public class Artigo implements Serializable {

	private Long codigo;
	private Integer imagem;
	private String titulo;
	private String artigo;
	private Date dataCadastro;
	private Date dataPublicacao;
	private Date dataDespublicacao;
	private Usuario publicante;
	private Estado estado;
	private Categoria categoria;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Integer getImagem() {
		return imagem;
	}
	public void setImagem(Integer imagem) {
		this.imagem = imagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtigo() {
		return artigo;
	}
	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDespublicacao() {
		return dataDespublicacao;
	}
	public void setDataDespublicacao(Date dataDespublicacao) {
		this.dataDespublicacao = dataDespublicacao;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_publicante")
	public Usuario getPublicante() {
		return publicante;
	}
	public void setPublicante(Usuario publicante) {
		this.publicante = publicante;
	}
	
	@Enumerated(EnumType.STRING)
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Enumerated(EnumType.STRING)
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artigo other = (Artigo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
