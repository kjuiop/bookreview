//package com.bookreview.core.util;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class CommonUtils {
//    public static String getClientIp(HttpServletRequest request) {
//        String ip = request.getHeader("X-Forwarded-For");
//        final String unknown = "unknown";
//
//        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
//            ip = request.getHeader("Proxy-Client-Ip");
//        }
//        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//
//        return ip;
//    }
//}
