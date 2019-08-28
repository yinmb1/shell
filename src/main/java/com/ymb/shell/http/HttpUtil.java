package com.ymb.shell.http;

import lombok.ToString;
import lombok.experimental.Builder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.NotSupportedException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 使用OkHttp构建的Http工具类
 *
 * @author yinmb
 * @date 2019/08/28 16:45
 * @since
 */
@Slf4j
public class HttpUtil {

    /**
     * OkHttp客户端
     */
    public static final OkHttpClient client;

    /**
     * 协议
     */
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String PATCH = "PATCH";

    /**
     * 编码方式
     */
    private static final String UTF8 = "UTF-8";
    private static final String GBK = "GBK";

    /**
     * 媒体类型
     * 更多的可以参考 {@link javax.ws.rs.core.MediaType}
     */
    private static final String MEDIA_TYPE_JSON = "application/json";          // json
    private static final String MEDIA_TYPE_XML = javax.ws.rs.core.MediaType.TEXT_XML;          // xml
    private static final String MEDIA_TYPE_FILE = javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;  // 二进制文件
    private static final String MEDIA_TYPE_APPLICATION_FORM_URLENCODED = javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;    // 表单

    // 一些默认设置
    private static final String DEFAULT_CHARSET = UTF8;     // 默认utf8编码
    private static final String DEFAULT_METHOD = GET;       // 默认get方式
    private static final String DEFAULT_MEDIA_TYPE = MEDIA_TYPE_JSON;    // 默认json
    private static final boolean DEFAULT_LOG = true;

    private static final long DEFAULT_TIME_OUT_MILLSECONDS = 180000;

    // 静态块初始化
    static {
        client = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(20, 5, TimeUnit.MINUTES))
                .readTimeout(DEFAULT_TIME_OUT_MILLSECONDS, TimeUnit.MILLISECONDS)
                .connectTimeout(DEFAULT_TIME_OUT_MILLSECONDS, TimeUnit.MILLISECONDS)
                .build();
    }

    /**
     * GET请求
     *
     * @param url URL地址
     * @return
     */
    public static String get(String url, boolean... log) {
        return get(url, 0, 0, DEFAULT_CHARSET, log);
    }

    /**
     * GET请求
     *
     * @param url            URL地址
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @return
     */
    public static String get(String url, long connectTimeout, long readTimeout, boolean... log) {
        return get(url, connectTimeout, readTimeout, DEFAULT_CHARSET, log);
    }

    /**
     * GET请求
     *
     * @param url            URL地址
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @param charset        编码方式
     * @return
     */
    public static String get(String url, long connectTimeout, long readTimeout, String charset, boolean... log) {
        return get(url, null, connectTimeout, readTimeout, charset, log);
    }

    /**
     * 带查询参数的GET查询
     *
     * @param url            URL地址
     * @param queryMap       查询参数
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @return
     */
    public static String get(String url, Map<String, String> queryMap, long connectTimeout, long readTimeout, boolean... log) {
        return get(url, queryMap, connectTimeout, readTimeout, DEFAULT_CHARSET, log);
    }

    /**
     * 带查询参数的GET查询
     *
     * @param url            URL地址
     * @param queryMap       查询参数
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @param charset        编码方式
     * @return
     */
    public static String get(String url, Map<String, String> queryMap, long connectTimeout, long readTimeout
            , String charset, boolean... log) {
        return get(url, queryMap, null, connectTimeout, readTimeout, charset, log);
    }

    /**
     * 带查询参数的GET查询
     *
     * @param url            URL地址
     * @param queryMap       查询参数
     * @param headerMap      头部参数
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @param charset        编码方式
     * @return
     */
    public static String get(String url, Map<String, String> queryMap, Map<String, String> headerMap
            , long connectTimeout, long readTimeout, String charset, boolean... log) {
        boolean isNeedLog = DEFAULT_LOG;
        if (log != null && log.length > 0) {
            isNeedLog = log[0];
        }
        return execute(OkHttp.builder()
                .url(url)
                .method(GET)
                .queryMap(queryMap)
                .headerMap(headerMap)
                .responseCharset(charset)
                .connectTimeout(connectTimeout)
                .readTimeout(readTimeout)
                .requestLog(isNeedLog)
                .requestCharset(charset)
                .responseLog(isNeedLog)
                .responseCharset(charset)
                .build());
    }

    /**
     * POST 发送json
     *
     * @param url     URL地址
     * @param jsonStr json字符串
     * @return
     */
    public static String postJson(String url, String jsonStr, boolean... log) {
        return postJson(url, jsonStr, null, 0, 0, log);
    }

    /**
     * POST 发送json
     *
     * @param url            URL地址
     * @param jsonStr        json字符串
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @return
     */
    public static String postJson(String url, String jsonStr, long connectTimeout, long readTimeout, boolean... log) {
        return postJson(url, jsonStr, null, connectTimeout, readTimeout, log);
    }

    /**
     * POST 发送json
     *
     * @param url            URL地址
     * @param jsonStr        json字符串
     * @param headerMap      头部参数
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @return
     */
    public static String postJson(String url, String jsonStr, Map<String, String> headerMap, long connectTimeout, long readTimeout
            , boolean... log) {
        return post(url, headerMap, jsonStr, MEDIA_TYPE_JSON, connectTimeout, readTimeout, UTF8, log);
    }

    /**
     * POST 发送json
     *
     * @param url            URL地址
     * @param xmlStr         json字符串
     * @param headerMap      头部参数
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @return
     */
    public static String postXml(String url, String xmlStr, Map<String, String> headerMap, long connectTimeout, long readTimeout
            , boolean... log) {
        return post(url, headerMap, xmlStr, MEDIA_TYPE_XML, connectTimeout, readTimeout, UTF8, log);
    }

    /**
     * POST 发送json
     *
     * @param url     URL地址
     * @param formMap 表单map
     * @return
     */
    public static String postForm(String url, Map<String, String> formMap, boolean... log) {
        return postForm(url, formMap, 0, 0, log);
    }

    /**
     * POST 发送表单
     *
     * @param url            URL地址
     * @param formMap        表单map
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @return
     */
    public static String postForm(String url, Map<String, String> formMap, long connectTimeout, long readTimeout, boolean... log) {
        StringBuilder stringBuilder = new StringBuilder();
        if (MapUtils.isNotEmpty(formMap)) {
            Set<Map.Entry<String, String>> entrySet = formMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }
        String data = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
        return post(url, null, data, MEDIA_TYPE_APPLICATION_FORM_URLENCODED, connectTimeout, readTimeout, UTF8, log);
    }

    /**
     * POST 发送
     *
     * @param url            URL地址
     * @param headerMap      头部参数
     * @param data           post发送的数据
     * @param mediaType      媒体类型
     * @param connectTimeout 连接超时时间，单位为毫秒
     * @param readTimeout    读取超时时间，单位为毫秒
     * @param charset        编码方式
     * @return
     */
    private static String post(String url, Map<String, String> headerMap, String data, String mediaType
            , long connectTimeout, long readTimeout, String charset, boolean... log) {
        boolean isNeedLog = DEFAULT_LOG;
        if (log != null && log.length > 0) {
            isNeedLog = log[0];
        }
        return execute(OkHttp.builder()
                .url(url)
                .method(POST)
                .headerMap(headerMap)
                .data(data)
                .mediaType(mediaType)
                .connectTimeout(connectTimeout)
                .readTimeout(readTimeout)
                .requestLog(isNeedLog)
                .requestCharset(charset)
                .responseLog(isNeedLog)
                .responseCharset(charset)
                .build());
    }

    /**
     * 通用执行方法
     *
     * @param okHttp
     * @return
     */
    private static String execute(OkHttp okHttp) {
        String tag = defaultTag();
        String uuid = UUID.randomUUID().toString();

        // 设置一些默认值
        if (StringUtils.isBlank(okHttp.requestCharset)) {
            okHttp.requestCharset = DEFAULT_CHARSET;
        }
        if (StringUtils.isBlank(okHttp.responseCharset)) {
            okHttp.responseCharset = DEFAULT_CHARSET;
        }
        if (StringUtils.isBlank(okHttp.method)) {
            okHttp.method = DEFAULT_METHOD;
        }
        if (StringUtils.isBlank(okHttp.mediaType)) {
            okHttp.mediaType = DEFAULT_MEDIA_TYPE;
        }


        //记录请求日志
        if (okHttp.requestLog) {
            log.info(String.format("Got request [%s] [%s] okHttp-> %s", uuid, tag, subStrResult(uuid, tag, okHttp.toString())));
        }

        String url = okHttp.url;

        // 构建builder
        Request.Builder builder = new Request.Builder();

        // 构建参数
        if (MapUtils.isNotEmpty(okHttp.queryMap)) {
            StringBuilder stringBuilder = new StringBuilder();
            Set<Map.Entry<String, String>> entrySet = okHttp.queryMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
            String queryParams = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
            url = String.format("%s%s%s", url, url.contains("?") ? "&" : "?", queryParams);
        }

        // 构建url
        builder.url(url);

        // 添加header
        if (MapUtils.isNotEmpty(okHttp.headerMap)) {
            okHttp.headerMap.forEach(builder::addHeader);
        }

        String method = okHttp.method.toUpperCase();
        String mediaType = String.format("%s;charset=%s", okHttp.mediaType, okHttp.requestCharset);

        if (StringUtils.equals(method, GET)) {
            // 调用get协议
            builder.get();
        } else if (ArrayUtils.contains(new String[]{POST, PUT, DELETE, PATCH}, method)) {
            // 其余协议
            RequestBody requestBody = RequestBody.create(MediaType.parse(mediaType), okHttp.data);
            builder.method(method, requestBody);
        } else {
            // 未知协议
            throw new NotSupportedException(String.format("http [%s] [%s]  method:%s not support!", uuid, tag, method));
        }

        // 拷贝一份客户端实例
        OkHttpClient okHttpClient = client;

        // 个性化设置超时时间
        if (okHttp.connectTimeout > 0 || okHttp.readTimeout > 0) {
            OkHttpClient.Builder okHttpClientBuilder = okHttpClient.newBuilder();
            if (okHttp.connectTimeout > 0) {
                okHttpClientBuilder = okHttpClientBuilder.connectTimeout(okHttp.connectTimeout, TimeUnit.MILLISECONDS);
            }
            if (okHttp.readTimeout > 0) {
                okHttpClientBuilder = okHttpClientBuilder.readTimeout(okHttp.readTimeout, TimeUnit.MILLISECONDS);
            }

            okHttpClient = okHttpClientBuilder.build();
        }

        // 执行调用
        String result = "";
        try {
            // 使用拷贝实例进行调用
            Response response = okHttpClient.newCall(builder.build()).execute();
            byte[] bytes = response.body().bytes();
            result = new String(bytes, okHttp.responseCharset);
            if (okHttp.responseLog) {//记录返回日志
                log.info(String.format("Got response [%s][%s] okHttp -> %s", uuid, tag, subStrResult(uuid, tag, result)));
            }
        } catch (Exception e) {
            log.error(String.format("Got error [%s][%s] okHttp -> %s", uuid, tag, subStrResult(uuid, tag, okHttp.toString())), e);
        }

        return result;
    }

    private static String defaultTag() {
        String tag = null;
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTrace : stackTraces) {
            if (!"com.yylending.fatp.lm.common.util.http.HttpWithLogUtil".equals(stackTrace.getClassName())
                    &&
                    !"com.yylending.fatp.lm.common.util.http.HttpUtil".equals(stackTrace.getClassName())
                    &&
                    !"java.lang.Thread".equals(stackTrace.getClassName())) {
                tag = stackTrace.getClassName() + "." + stackTrace.getMethodName();
                break;
            }
        }
        return tag;
    }

    private static String subStrResult(String uuid, String tag, String result) {
        int maxLogStringLength = 2000;
        if (result != null && result.length() > maxLogStringLength) {
            /*result = result.substring(0, maxLogStringLength);*/
            log.warn(String.format("Got [%s] [%s] okHttp warnMaxLogStringLength -> %s", uuid, tag, result));
        }
        return result;
    }

    @Builder
    @ToString(exclude = {"requestCharset", "responseCharset", "requestLog", "responseLog"})
    static class OkHttp {

        /**
         * 请求url
         */
        private String url;

        /**
         * 请求方法
         */
        private String method = DEFAULT_METHOD;

        /**
         * 请求数据
         */
        private String data;

        /**
         * 媒体类型
         */
        private String mediaType = DEFAULT_MEDIA_TYPE;

        /**
         * 请求参数
         */
        private Map<String, String> queryMap;

        /**
         * 头信息
         */
        private Map<String, String> headerMap;

        /**
         * 读取超时时间，单位毫秒
         */
        private long readTimeout;

        /**
         * 连接超时时间，单位毫秒
         */
        private long connectTimeout;

        /**
         * 请求编码
         */
        private String requestCharset;

        /**
         * 请求日志
         */
        private boolean requestLog;

        /**
         * 响应编码
         */
        private String responseCharset;

        /**
         * 响应日志
         */
        private boolean responseLog;

    }
}
