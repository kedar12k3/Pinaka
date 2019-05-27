package com.pinaka.server.db;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinaka.server.entities.Data;
import com.pinaka.server.utils.ClassDetails;

@Repository
@Transactional
public class FormRepository {
	//@Autowired
	//@Qualifier("theEntityManager")
	private EntityManager em = null;
		
	public Data createEntry(String formName, String dataToSet) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
	
		em.getTransaction().begin();
		ObjectMapper mapper = new ObjectMapper();
		Data data = (Data) mapper.readValue(dataToSet, new ClassDetails().getClassn(formName));
		em.persist(data);
		em.getTransaction().commit();
		//em.close();
		return data;
	}

	
	public Data getEntry(String formName, int id) throws ClassNotFoundException, IOException {
		setEntityManager();
		Data data = (Data) em.find(new ClassDetails().getClassn(formName), id);
		return data;
	}

	
	private void setEntityManager() {
		// TODO Auto-generated method stub
		System.out.println("What");
		em = AppConfiguration.getEntityManager();
	}


	@SuppressWarnings("unchecked")
	public List<Data> getListEntries(String formName) {
		List<Data> listData = (List<Data>) em.createQuery("select data from " + formName +" data").getResultList();
		return listData;
	}

	public Data setEntry(String formName, int id, String dataToSet) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
		em.getTransaction().begin();
		ObjectMapper mapper = new ObjectMapper();
		Data data2Set = (Data) mapper.readValue(dataToSet, new ClassDetails().getClassn(formName));
		Data mergedData = em.merge(data2Set);
		em.getTransaction().commit();
		//em.close();
		return mergedData;
	}
	
	public String deleteEntry(String formName, int id) throws ClassNotFoundException, IOException {
		em.getTransaction().begin();
		Data data = (Data) em.find(new ClassDetails().getClassn(formName), id);
		em.remove(data);
		em.getTransaction().commit();
		//em.close();
		return "Deleted entry no: ".concat(Integer.toString(id)).concat(" in form named: ").concat(formName);
	}

}
