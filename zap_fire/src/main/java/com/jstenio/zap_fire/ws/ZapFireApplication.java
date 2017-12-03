package com.jstenio.zap_fire.ws;

import javax.websocket.DeploymentException;

import org.glassfish.tyrus.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jstenio.zap_fire.util.SyncWebSocket;
import com.jstenio.zap_fire.ws.repository.RecursoRepository;

@SpringBootApplication
public class ZapFireApplication implements CommandLineRunner{
	
	@Autowired
	private RecursoRepository rep;
	
	public static void main(String[] args) throws DeploymentException {
		SpringApplication.run(ZapFireApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Server server = new Server("localhost", 2325, "/", SyncWebSocket.class);
		
		try {
			server.start();
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
