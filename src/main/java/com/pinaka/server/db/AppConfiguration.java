package com.pinaka.server.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	//private static Entity
	static EntityManager entityManager=null;
	@Bean(name="theEntityManager")
	public static EntityManager getEntityManager() {
		if(entityManager==null) {
			refreshEntityFactory();
		}
		return entityManager;	    
	}
	
	public static void refreshEntityFactory() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	    Set<javax.persistence.metamodel.EntityType<?>> entityTypes = factory.getMetamodel().getEntities();
		for (javax.persistence.metamodel.EntityType entityType : entityTypes){
		     System.out.println(entityType.getName());
		     System.out.println(entityType.getJavaType().getCanonicalName());
		     System.out.println("******************************");
		}
		entityManager =  factory.createEntityManager();
	}
}
