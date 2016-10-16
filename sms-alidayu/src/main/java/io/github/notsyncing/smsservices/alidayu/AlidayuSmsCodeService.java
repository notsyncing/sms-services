package io.github.notsyncing.smsservices.alidayu;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import io.github.notsyncing.smsservices.core.ConfigClass;
import io.github.notsyncing.smsservices.core.SmsCodeService;

import java.util.concurrent.CompletableFuture;

@ConfigClass(AlidayuSmsCodeServiceConfig.class)
public class AlidayuSmsCodeService implements SmsCodeService {
    private AlidayuSmsCodeServiceConfig config;

    public AlidayuSmsCodeService(AlidayuSmsCodeServiceConfig config) {
        this.config = config;
    }

    @Override
    public CompletableFuture<Boolean> send(String mobile, String code) {
        return CompletableFuture.supplyAsync(() -> {
            TaobaoClient client = new DefaultTaobaoClient(config.getApiUrl(), config.getApiKey(), config.getApiSecret());

            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setSmsType(config.getSmsType());
            req.setSmsFreeSignName(config.getSmsFreeSignName());
            req.setSmsParamString(config.getSmsTemplateParams(code));
            req.setRecNum(mobile);
            req.setSmsTemplateCode(config.getSmsTemplateCode());

            AlibabaAliqinFcSmsNumSendResponse resp;

            try {
                resp = client.execute(req);
                return resp.isSuccess();
            } catch (ApiException e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}
