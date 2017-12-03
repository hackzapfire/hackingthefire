package com.jstenio.zap_fire.ws.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jstenio.zap_fire.util.SyncWebSocket;
import com.jstenio.zap_fire.ws.model.Checks;
import com.jstenio.zap_fire.ws.model.Recurso;
import com.jstenio.zap_fire.ws.repository.ChecksRepository;

@Service
public class ChecksService {
	
	
	@Autowired
	private ChecksRepository rep;
	
	public List<Checks> listAll(){
		return rep.findAll();
	}
	
	public Checks create(Checks checks) {
		Recurso r = checks.getRecurso();
		if(r!=null) {
			Session session = SyncWebSocket.connections.get(r.getUserId());
			System.out.println(r.getUserId()+"---");
			if(session!=null) {
				System.out.println("nao");
				ObjectMapper mapper = new ObjectMapper();
				String valor;
				try {
					valor = mapper.writeValueAsString(checks.getOcorrencia());
					session.getBasicRemote().sendText(valor);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		checks.setBegin(Calendar.getInstance());
		return rep.save(checks);
	}
	
	public Checks update(Checks checks) {
		return rep.save(checks);
	}
	
	public Checks find(Integer id) {
		return rep.findOne(id);
	}
 
}
