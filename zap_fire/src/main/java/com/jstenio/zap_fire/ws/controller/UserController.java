package com.jstenio.zap_fire.ws.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jstenio.zap_fire.ws.model.User;

@RestController
public class UserController {
		
	
	@RequestMapping(method=RequestMethod.GET, value="/usuarios", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listAll(){
		User u1 = new User("Teste0", "teste0@email.com","12345");
		User u2 = new User("Teste1", "teste1@email.com","1234");
		User u3 = new User("Teste2", "teste2@email.com","123456");
		User u4 = new User("Teste3", "teste3@email.com","4321");
		
		return new ResponseEntity<>(Arrays.asList(u1, u2, u3, u4), HttpStatus.OK);
		
	}
}
