package io.github.notsyncing.smsservices.alidayu;

import io.github.notsyncing.smsservices.core.ConfigKey;

public class AlidayuSmsCodeServiceConfig {
    @ConfigKey
    private String apiUrl = "https://eco.taobao.com/router/rest";

    @ConfigKey
    private String apiKey;

    @ConfigKey
    private String apiSecret;

    @ConfigKey
    private String smsType = "normal";

    @ConfigKey
    private String smsFreeSignName;

    @ConfigKey
    private String smsTemplateParams;

    @ConfigKey
    private String smsTemplateCode;

    public String getApiUrl()
    {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl)
    {
        this.apiUrl = apiUrl;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public String getApiSecret()
    {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret)
    {
        this.apiSecret = apiSecret;
    }

    public String getSmsType()
    {
        return smsType;
    }

    public void setSmsType(String smsType)
    {
        this.smsType = smsType;
    }

    public String getSmsFreeSignName()
    {
        return smsFreeSignName;
    }

    public void setSmsFreeSignName(String smsFreeSignName)
    {
        this.smsFreeSignName = smsFreeSignName;
    }

    public String getSmsTemplateParams()
    {
        return smsTemplateParams;
    }

    public String getSmsTemplateParams(String code)
    {
        return smsTemplateParams.replace("[code]", code);
    }

    public void setSmsTemplateParams(String smsTemplateParams)
    {
        this.smsTemplateParams = smsTemplateParams;
    }

    public String getSmsTemplateCode()
    {
        return smsTemplateCode;
    }

    public void setSmsTemplateCode(String smsTemplateCode)
    {
        this.smsTemplateCode = smsTemplateCode;
    }
}
