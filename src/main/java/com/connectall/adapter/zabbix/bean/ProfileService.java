package com.connectall.adapter.zabbix.bean;

import java.io.IOException;

public class ProfileService {
	
	public final String TEST_VAR = "1";
	
	public static void main(String[] aa) throws IOException {
		String cmd = new String("cmd.exe /K \"c:\\util\\rmanDB.bat "
		+aa[0]+
		"&&c:\\utl\\cleanup.bat\"");

		Runtime.getRuntime().exec(cmd);
	}

}
