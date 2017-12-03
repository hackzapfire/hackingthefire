package com.jstenio.zap_fire.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jstenio.zap_fire.ws.model.Ocorrencia;
import com.jstenio.zap_fire.ws.service.OcorrenciaService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaService serv;
	
	@RequestMapping(method=RequestMethod.GET, value="/ocorrencias", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ocorrencia>> list(){
		return new ResponseEntity<List<Ocorrencia>>(serv.listAll(), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, value="/ocorrencia", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Ocorrencia ocorrencia) {
		
		serv.create(ocorrencia);
	}

	@RequestMapping(method=RequestMethod.GET, value="/ocorrencia/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Ocorrencia find(@PathVariable("id") Integer id) {
		return serv.find(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/ocorrencia", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Ocorrencia ocorrencia) {
		serv.create(ocorrencia);
	}
}
