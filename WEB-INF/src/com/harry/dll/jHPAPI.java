package com.harry.dll;

public class jHPAPI {
	public static boolean loaded = false;
	
	private native String HPAPI_getDecryptKey(String libertyKey, String macAdress);
	
	private jHPAPI() {}
	private static jHPAPI instance = new jHPAPI();
	public static jHPAPI getInstance(){
		return instance;
	};
	
	public boolean isAuthenticated(String k, String adr) {
		boolean ret = false;
		return ret;
	}
	
	public String getDecryptKey(String libertyKey, String macAdress) throws Exception {
		return HPAPI_getDecryptKey(libertyKey, macAdress);
	}
}

