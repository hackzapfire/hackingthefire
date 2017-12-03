package com.jstenio.zap_fire.ws.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jstenio.zap_fire.util.SyncWebSocket;
import com.jstenio.zap_fire.ws.model.Ocorrencia;
import com.jstenio.zap_fire.ws.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository rep;
	
	public Ocorrencia create(Ocorrencia ocorrencia) {
		ObjectMapper mapper = new ObjectMapper();
		ocorrencia.setInicio(Calendar.getInstance());
		try {
			final String valor = mapper.writeValueAsString(ocorrencia);
			System.out.println("valor: "+valor);
			SyncWebSocket.connections.entrySet().parallelStream().forEach((entry)->{
				/*try {	
					entry.getValue().getBasicRemote().sendText(valor);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/	
			});
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rep.save(ocorrencia);
	}
	
	public List<Ocorrencia> listAll(){
		return rep.findAll();
	}
	
	public Ocorrencia find(Integer id) {
		return rep.findOne(id);
	}
	
}
