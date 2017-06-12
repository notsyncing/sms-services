package io.github.notsyncing.smsservices.mengwang;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class MengWangSmsClient {
    private String apiUrl;
    private String apiUserId;
    private String apiPassword;

    MengWangSmsClient(String apiUrl, String userId, String password) {
        this.apiUrl = apiUrl;
        this.apiUserId = userId;
        this.apiPassword = password;
    }

    public boolean sendSms(String mobile, String message, String subPort, String userMessageId) throws DocumentException, NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        String result = null;

        MessageParams p = new MessageParams();
        p.setUserId(apiUserId);
        p.setPassword(apiPassword);
        p.setPszMobis(mobile);
        p.setPszMsg(message);
        p.setiMobiCount("1");
        p.setPszSubPort(subPort);
        p.setMsgId(userMessageId);

        String Message = executePost(p, apiUrl + "/MongateSendSubmit");

        if (Message != null && !Message.isEmpty()) {
            Document doc = DocumentHelper.parseText(Message);
            Element el = doc.getRootElement();
            result = el.getText();
        }

        return (result != null) && (!result.isEmpty()) && (result.length() > 10);
    }

    private String executePost(MessageParams paramObj, String httpUrl) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Class<?> clazz = paramObj.getClass();
        List<BasicNameValuePair> params = new ArrayList<>();

        for (Field f : clazz.getDeclaredFields()) {
            String fieldName = f.getName();
            String fieldNameUpper = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
            String value;

            if (clazz.getMethod("get" + fieldNameUpper).invoke(paramObj) == null) {
                value = "";
            } else {
                value = clazz.getMethod("get" + fieldNameUpper).invoke(paramObj).toString();
            }

            if (value != null) {
                params.add(new BasicNameValuePair(fieldName, value));
            }
        }

        HttpPost post = new HttpPost(httpUrl);
        post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            HttpEntity entity = httpclient.execute(post).getEntity();

            if ((entity != null) && (entity.getContentLength() > 0)) {
                return EntityUtils.toString(entity);
            }
        }

        return null;
    }
}