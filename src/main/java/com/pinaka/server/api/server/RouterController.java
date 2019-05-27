package com.pinaka.server.api.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinaka.server.db.AppConfiguration;

@RestController
@RequestMapping(value="/server")
public class RouterController {
	
	@GetMapping(value="/refreshEntities")
	public boolean refreshEntityCache() {
		AppConfiguration.refreshEntityFactory();
		return true;
	}
	
}
