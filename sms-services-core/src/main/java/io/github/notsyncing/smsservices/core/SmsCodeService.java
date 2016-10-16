package io.github.notsyncing.smsservices.core;

import java.util.concurrent.CompletableFuture;

public interface SmsCodeService {
    CompletableFuture<Boolean> send(String mobile, String code);
}
