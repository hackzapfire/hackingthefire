package com.jstenio.zap_fire.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jstenio.zap_fire.ws.model.Checks;
import com.jstenio.zap_fire.ws.service.ChecksService;

@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ChecksController {
	
	@Autowired
	private ChecksService serv;
	
	@RequestMapping(method=RequestMethod.POST, value="/checks", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Checks> create(@RequestBody Checks checks){
		return new ResponseEntity<Checks>(serv.create(checks), HttpStatus.OK);
	}
}
