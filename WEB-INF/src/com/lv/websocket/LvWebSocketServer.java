package com.lv.websocket;

import javax.servlet.http.HttpServlet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.lv.cache.Cache;


	@ServerEndpoint("/ws")
	public class LvWebSocketServer {

	    @OnOpen
	        public void open(Session session) {
	    	Cache c = Cache.getInstance();
	    	String msg = c.getFileList();
	    	
	    	session.getAsyncRemote().sendText(msg);
	    }

	    @OnClose
	        public void close(Session session) {
	    }

	    @OnError
	        public void onError(Throwable error) {
	    }

	    @OnMessage
	        public void handleMessage(String message, Session session) {
	    }
}
