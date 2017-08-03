package com.lv.cache;

import java.io.File;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.harry.dll.*;
import com.lv.fileSystem.ScanDirectory;
import com.lv.websocket.LvWebSocketServer;

import io.vertx.core.*;

//  extends AbstractVerticle
public class Cache implements ServletContextListener, HttpSessionListener {

	public Cache() {}
	
	private static Cache instance = null;
	private static String fileList;
	
	public static synchronized Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
		}
		return instance;
	};
	
	
	public void setFileList(String string) {
		fileList = string;
		System.out.println("cache mis à jour");
	}
	public String getFileList() {
		return fileList;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String fullName4 = "HNSHPilotApi";
		
		String fullName = "C:\\Users\\pljanczak\\workspace\\LibertyVersions\\dll\\hpapi.dll";
		String fullName2 = "C:/Users/pljanczak/workspace/LibertyVersions/dll/HNSHPilotApi.dll";
		String fullName3 = "C:/Program Files (x86)/COHERIS-LIBERTY/HNSHPilotApi";
		
		if (!jHPAPI.loaded) {			
			System.loadLibrary(fullName4);
			System.out.println("\n \n \n " + fullName4 +  " DLL LOADED \n \n \n" );
			
		ScanDirectory sd = ScanDirectory.getInstance();
		sd.start();
		LvWebSocketServer ws = new LvWebSocketServer();
		}
	}
}
