package com.lv.fileSystem;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import com.lv.cache.Cache;
//import com.lv.utils.JSONObject;
import com.lv.utils.JSONObject;

public class ScanDirectory extends Thread {
	 private static String fullPath = null;
	 private static String root = "C:/Users/pljanczak/workspace/LibertyVersions/deploy";							// racine du workspace Eclipse
	 private static String target = "version1.txt";

	private static ScanDirectory instance = new ScanDirectory();
	private ScanDirectory() {}
	
	public static synchronized ScanDirectory getInstance() {
		return instance;
	}
	
	public String getFileList() {
			File file = new File(root);
			File[] files = file.listFiles();
			ArrayList<String> aFiles = new ArrayList<String>();
				
			String obj = "{}";
			try{
				JSONObject j = new JSONObject();		
				for (File f : files) {
					System.out.println("file name: " + f.getName());
					if (f.getName().endsWith(".zip")) {
						aFiles.add(f.getName());
					}
				}
				j.put( "versions",	aFiles);
				obj = j.toString();
			} catch(Exception e) {
			}
			return obj;
	}
	public String getFullPath() {
		File file = new File(root);
		scanDirectoryRec(file);
		return fullPath;
	}
	private void scanDirectoryRec(File dir) {
		//File file = new File(dir);
		File[] directories = dir.listFiles( 			 // FileFilter to match dir pattern
				new FileFilter() {
				    @Override
				    public boolean accept(File file) {
				        return file.isDirectory();
				    }
				});
		
		if (directories == null || directories.length == 0) return;
		System.out.println("dir size " + directories.length);
		for (File curDir : directories) {
			System.out.println("current path " + curDir);
			scanDirectoryRec(curDir);
			scanFiles(curDir);
		}
	}
	private void scanFiles(File dir) {
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) return;
		
		String current = null;
		for (File file : files) {
			current = file.getName();
			System.out.println("current file " + current);
			if (current.matches(target)) {
				//fullPath = file.getAbsolutePath();
				fullPath = file.getName();
			}
		}
	}
	public void run() {
		System.out.println("démarrage Thread");
		while (true) {
			Cache c = Cache.getInstance();
			//ScanDirectory sd = ScanDirectory.getInstance();
			c.setFileList(this.getFileList());
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
