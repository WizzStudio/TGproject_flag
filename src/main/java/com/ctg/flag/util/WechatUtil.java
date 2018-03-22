package com.ctg.flag.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信工具类
 * 获得openid
 */
public class WechatUtil {
    private static final String APPID = "";
    private static final String SECRET = "";
    private static final String GRANT_CODE = "authorization_code";

    private static final String WECHAT_OPENID_URL = "https://api.weixin.qq.com/sns/jscode2session";
    private static final Map<String, String> REQUEST_PARAMS = new HashMap<String, String>();
    static {
        REQUEST_PARAMS.put("appid", APPID);
        REQUEST_PARAMS.put("SECRET", SECRET);
        REQUEST_PARAMS.put("GRANT_CODE", GRANT_CODE);
    }

    private static RestTemplate restTemplate = new RestTemplate();

    public static String getOpenId(String code) throws Exception {
        REQUEST_PARAMS.put("js_code", code);

        ResponseEntity<String> result = restTemplate.getForEntity(WECHAT_OPENID_URL, String.class, REQUEST_PARAMS);
        if (result.getStatusCodeValue() != 200) {
            throw new Exception("connect wechat failed");
        }

        WechatResponseBody responseBody = JsonUtil.json2Object(result.getBody(), WechatResponseBody.class);
        return responseBody.getOpenid();
    }
}

/**
 * 接受返回内容的内部类
 */
class WechatResponseBody {
    /**
     * succeed, info
     */
    private String openid;
    private String session_key;

    /**
     * failed, info
     */
    private String errcode;
    private String errmsg;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    String getOpenid() {
        return openid;
    }

    void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "WechatResponseBody{" +
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
