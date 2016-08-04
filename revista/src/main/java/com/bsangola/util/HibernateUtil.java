package com.bsangola.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("RevistaPU");
		
	public static final EntityManagerFactory getEntityManagerFactory(){
		return FACTORY;
	}
	
}
