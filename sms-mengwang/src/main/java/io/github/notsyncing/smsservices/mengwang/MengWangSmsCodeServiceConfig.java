package io.github.notsyncing.smsservices.mengwang;

import io.github.notsyncing.smsservices.core.ConfigKey;

public class MengWangSmsCodeServiceConfig {
    @ConfigKey
    private String apiUrl = "http://$ip:$port/MWGate/wmgw.asmx";

    @ConfigKey
    private String apiUsername;

    @ConfigKey
    private String apiPassword;

    @ConfigKey
    private String template;

    public String getApiUrl()
    {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl)
    {
        this.apiUrl = apiUrl;
    }

    public String getApiUsername()
    {
        return apiUsername;
    }

    public void setApiUsername(String apiUsername)
    {
        this.apiUsername = apiUsername;
    }

    public String getApiPassword()
    {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword)
    {
        this.apiPassword = apiPassword;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
