package com.jstenio.zap_fire.ws.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ConnectionController {
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value="/connect")
	public void connect() {
		System.out.println("conectado com: "+request);
	}
	
}
