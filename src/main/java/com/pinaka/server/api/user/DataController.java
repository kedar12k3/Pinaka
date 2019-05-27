package com.pinaka.server.api.user;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pinaka.server.db.FormRepository;
import com.pinaka.server.entities.Data;

@RestController
@RequestMapping(value="/api")
public class DataController {
	
	@Autowired
	FormRepository formrepository;
	
	@PostMapping(value="/entry/{formname}")
	public Data saveEntry(@PathVariable String formname, @RequestBody String dataToSet) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		return formrepository.createEntry(formname,dataToSet);
	}
	
	@GetMapping(value="/entry/{formname}/{id}")
	public Data getEntry(@PathVariable String formname, @PathVariable int id) throws ClassNotFoundException, IOException {
		return formrepository.getEntry(formname,id);
	}
	
	@GetMapping(value="/entry/{formname}/all")
	public List<Data> getListEntries(@PathVariable String formname) {
		return formrepository.getListEntries(formname);
	}
		
	@PutMapping(value="/entry/{formname}/{id}")
	public Data setEntry(@PathVariable String formname, @PathVariable int id, @RequestBody String dataToSet) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		return formrepository.setEntry(formname,id,dataToSet);
	}
	
	@DeleteMapping(value="/entry/{formname}/{id}")
	public String deleteEntry(@PathVariable String formname, @PathVariable int id) throws ClassNotFoundException, IOException {
		return formrepository.deleteEntry(formname,id);
	}
	



}
