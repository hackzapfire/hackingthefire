package com.jstenio.zap_fire.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jstenio.zap_fire.ws.model.Recurso;
import com.jstenio.zap_fire.ws.repository.RecursoRepository;

@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepository rep;
	
	public List<Recurso> listAll(){
		return rep.findAll();
	}
	
	public Recurso create(Recurso recurso) {
		return rep.save(recurso);
	}
	
}
