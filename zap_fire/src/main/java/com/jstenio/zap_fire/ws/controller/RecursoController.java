package com.jstenio.zap_fire.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jstenio.zap_fire.ws.model.Recurso;
import com.jstenio.zap_fire.ws.service.RecursoService;

@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class RecursoController {
	
	@Autowired
	private RecursoService serv;

	
	@RequestMapping(method=RequestMethod.GET, value="/recursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recurso>> listAll(){
		return new ResponseEntity<>(serv.listAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<Recurso> createRecurso(@RequestBody Recurso rec) {
		return new ResponseEntity<>(serv.create(rec), HttpStatus.OK);
	}

}
