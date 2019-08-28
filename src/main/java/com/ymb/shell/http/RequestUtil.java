package com.ymb.shell.http;



import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RequestUtil {

//    private static final String IP_SEP = ","; // 请求头里有多个 IP 地址时的分隔符
//
//
//    /**
//     * CMA配置
//     */
//    public static final String CMA_CONNECT_TIMEOUT = "cma.connect.timeout";
//    public static final String CMA_READ_TIMEOUT = "cma.read.timeout";
//    public static final String CMA_URL = "cma.url";
//
//    private static final String CMA_APP_ID = "cma.sign.appId";
//    private static final String CMA_AES_KEY = "cma.sign.aesKey";
//    private static final String CMA_HEADER_APP_ID = "AppID";
//    private static final String CMA_HEADER_SERIAL_NO = "Serial-No";
//    private static final String CMA_HEADER_TIMESTAMP = "Timestamp";
//    private static final String CMA_HEADER_SIGNATURE = "Signature";
//
//
//    }
//
//    public static long getCmaConnectTimeout() {
//        return Long.parseLong(EnvTools.getProperty(RequestUtil.CMA_CONNECT_TIMEOUT));
//    }
//
//    public static long getCmaReadTimeout() {
//        return Long.parseLong(EnvTools.getProperty(RequestUtil.CMA_READ_TIMEOUT));
//    }
//
//
//    public static String getRemoteAddress(HttpServletRequest request,
//                                          String xForwardedFor) {
//        String ip = request.getHeader(xForwardedFor);
//        if (StringUtils.isBlank(ip)) {
//            // 这里可以尝试多个请求头，根据反向代理服务器可能设置的，最好是准确确认的头
//            ip = request.getRemoteAddr();
//        } else {
//            if (ip.contains(IP_SEP)) {
//                String[] split = ip.split(IP_SEP);
//                ip = split[0]; // 真实 IP 是放在最前面的
//            }
//        }
//
//        return ip;
//    }
//
//
//
//    /**
//     * 业管系统请求头
//     *
//     * @return
//     */
//    public static Map<String, String> getCMAHeader() {
//        Map<String, String> headerMap = new HashMap<>();
//        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:SS").format(new Date());
//        String serialNo = getSerialNo();
//
//        headerMap.put(CMA_HEADER_APP_ID, EnvTools.getProperty(CMA_APP_ID));
//        headerMap.put(CMA_HEADER_SERIAL_NO, serialNo);
//        headerMap.put(CMA_HEADER_TIMESTAMP, timeStamp);
//        headerMap.put(CMA_HEADER_SIGNATURE, MD5Tools.encryptUpperCase(EnvTools.getProperty(CMA_APP_ID) + serialNo + timeStamp + EnvTools.getProperty(CMA_AES_KEY)));
//
//        return headerMap;
//    }



}
