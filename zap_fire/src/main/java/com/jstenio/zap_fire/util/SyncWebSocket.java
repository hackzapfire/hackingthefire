package com.jstenio.zap_fire.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jstenio.zap_fire.ws.model.Recurso;


@ServerEndpoint("/zap/{sala}")
public class SyncWebSocket {
	
	
	 public static Map<String, Session> connections = new HashMap<String, Session>();
	
	 @OnOpen
	 public void onOpen(Session session) {
		 session.setMaxIdleTimeout(2*60*60*1000);
		 String param = session.getPathParameters().get("sala");
		 System.out.println("antes" +param);
		 
		 Recurso recurso = null;
		 		 
		 if(!tem(param)) {
			 Recurso r = new Recurso();
			 r.setUserId(param);
			 insert(param, null, null);
		 }
		 
		 
		 if(param!=null) {
			 connections.put(param, session);
		 }
	
	 }
		   
	 
	 @OnClose
	 public void onClose(Session session) {
		 connections.remove(session.getId());
	 }
	 
	@OnMessage	  
	public void onMessage(String message, Session session) {
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(message);
			
			System.out.println("ok"+node);
			
			JsonNode n1 = node.get("latitude");
			JsonNode n2 = node.get("longitude");
			JsonNode n3 = node.get("idUser");
			
			up(n3.toString(),n2.toString(), n1.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized boolean tem(String param) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zap_fire","root", null);
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM recurso WHERE user_id=? group by id");
			ps.setString(1, param);
			ResultSet re = ps.executeQuery();
			int a = 0;
			while(re.next()) {
				a  = re.getInt(1);
			}
			re.close();
			ps.close();
			connection.close();
			return a>0;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert(String userId, String longitude, String latitude) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zap_fire","root", null);
			PreparedStatement ps = connection.prepareStatement("INSERT INTO recurso(user_id, longitude, latitude) VALUES (?, ?, ?)");
			ps.setObject(1, userId);
			ps.setObject(2, longitude);
			ps.setObject(3, latitude);
			ps.execute();
			ps.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void up(String userId, String longitude, String latitude) {
		String sql = "update recurso set latitude ="+latitude+", longitude = "+longitude+" where user_id = "+userId+"";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zap_fire","root", null);
			PreparedStatement ps = connection.prepareStatement(sql);
			/*ps.setObject(1, latitude);
			ps.setObject(2, longitude);
			ps.setObject(3, userId);*/
			ps.execute();
			ps.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
