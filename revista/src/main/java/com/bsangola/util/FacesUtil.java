package com.bsangola.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {
	
	private static FacesMessage message;
	private static FacesContext context;
	private static ExternalContext externalContext;
	private static HttpServletRequest request;
	
	
	public FacesUtil() {
	}
	
	
	public static final void addMensagemInformacao(String mensagem){
		FacesUtil.message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesUtil.context = FacesContext.getCurrentInstance();
		FacesUtil.context.addMessage(null, message);
	}

	public static final void addMensagemErro(String mensagem){
		FacesUtil.message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesUtil.context = FacesContext.getCurrentInstance();
		FacesUtil.context.addMessage(null, message);
	}
	
	public static final void addMensagemAviso(String mensagem){
		FacesUtil.message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem);
		FacesUtil.context = FacesContext.getCurrentInstance();
		FacesUtil.context.addMessage(null, message);
	}
	
	public static final void addMensagemFatal(String mensagem){
		FacesUtil.message = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, mensagem);
		FacesUtil.context = FacesContext.getCurrentInstance();
		FacesUtil.context.addMessage(null, message);
	}
	
	public static final EntityManager getRequestManager(){
		FacesUtil.context = FacesContext.getCurrentInstance();
		FacesUtil.externalContext = FacesUtil.context.getExternalContext();
		FacesUtil.request = (HttpServletRequest) FacesUtil.externalContext.getRequest();
		return (EntityManager) FacesUtil.request.getAttribute("manager");
	}
}
