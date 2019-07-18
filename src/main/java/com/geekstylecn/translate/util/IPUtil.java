package com.geekstylecn.translate.util;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {

	public static long ipToLong(String ipAddress) {
		long result = 0;
		String[] atoms = ipAddress.split("\\.");
		for (int i = 3; i >= 0; i--) {
			result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
		}
		return result & 0xFFFFFFFF;
	}

	public static String longToIp(long ip) {
		StringBuilder sb = new StringBuilder(15);
		for (int i = 0; i < 4; i++) {
			sb.insert(0, Long.toString(ip & 0xff));
			if (i < 3) {
				sb.insert(0, '.');
			}
			ip >>= 8;
		}
		return sb.toString();
	}
	
	public static String getClientIP(HttpServletRequest request) {
		//log
		System.out.println("X-FORWARDED-FOR: " + request.getHeader("X-FORWARDED-FOR"));
		System.out.println("X-Real-IP: " + request.getHeader("X-Real-IP"));
		System.out.println("remoteAddr(): " + request.getRemoteAddr());
		
        String remoteAddr = request.getHeader("X-Real-IP");
        if (remoteAddr == null || remoteAddr.equals("")) {
            remoteAddr = request.getRemoteAddr();
        }
        return remoteAddr;
	}

}
