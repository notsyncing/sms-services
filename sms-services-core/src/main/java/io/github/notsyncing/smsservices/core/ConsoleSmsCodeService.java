package io.github.notsyncing.smsservices.core;

import java.util.concurrent.CompletableFuture;

public class ConsoleSmsCodeService implements SmsCodeService
{
    @Override
    public CompletableFuture<Boolean> send(String mobile, String code)
    {
        System.out.println("SMS code " + code + " to mobile " + mobile);
        return CompletableFuture.completedFuture(true);
    }
}
