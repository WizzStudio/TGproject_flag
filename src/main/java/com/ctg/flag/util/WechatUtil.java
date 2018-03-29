package com.ctg.flag.util;

import com.ctg.flag.exception.NoAuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

/**
 * 微信工具类
 * 获得openid
 */
@Component
public class WechatUtil {
    @Value("${wx.url}")
    private String WECHAT_OPENID_URL;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 获取用户唯一openid
     * @param code  前台给的code
     * @return  openid
     * @throws Exception  请求失败
     */
    public String getOpenId(String code) throws Exception{
        String url = WECHAT_OPENID_URL + URLEncoder.encode(code, "UTF-8");
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        if (result.getStatusCodeValue() != 200) {
            throw new NoAuthenticationException("connect wechat failed");
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
