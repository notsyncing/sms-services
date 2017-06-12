package io.github.notsyncing.smsservices.mengwang;

import io.github.notsyncing.smsservices.core.ConfigClass;
import io.github.notsyncing.smsservices.core.SmsCodeService;

import java.util.concurrent.CompletableFuture;

@ConfigClass(MengWangSmsCodeServiceConfig.class)
public class MengWangSmsCodeService implements SmsCodeService {
    private MengWangSmsCodeServiceConfig config;

    public MengWangSmsCodeService(MengWangSmsCodeServiceConfig config) {
        this.config = config;
    }

    @Override
    public CompletableFuture<Boolean> send(String mobile, String code) {
        return CompletableFuture.supplyAsync(() -> {
            MengWangSmsClient client = new MengWangSmsClient(config.getApiUrl(), config.getApiUsername(), config.getApiPassword());

            try {
                return client.sendSms(mobile, config.getTemplate().replace("${code}", code),
                        "*", "0");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}
