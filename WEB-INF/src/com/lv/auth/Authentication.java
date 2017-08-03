package com.lv.auth;



public class Authentication {
	private static boolean loaded = false;
	
	private static native String HPAPI_getDecryptKey(String libertyKey, String macAdress);
	
	public static boolean isAuthenticated(String k, String adr) {
		boolean ret = false;
		adr = "782BCBA8E5B8";
		String fullName = "C:\\Users\\pljanczak\\workspace\\LibertyVersions\\dll\\hpapi.dll";
		String fullName2 = "C:/Users/pljanczak/workspace/LibertyVersions/dll/HNSHPilotApi.dll";
		String fullName3 = "C:/Program Files (x86)/COHERIS-LIBERTY/HNSHPilotApi.dll";
		if (!loaded) {			
			System.load(fullName3);
			loaded = true;
		}
		String key = HPAPI_getDecryptKey(k, adr);
		if (key != null) {
			ret = true;
		}
		return ret;
	}
}
