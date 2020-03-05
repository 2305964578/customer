package net.marssky.account.client;

import net.marssky.account.dto.CreateAccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@FeignClient(name = "account-service",path = "/v1/account",url = "http://localhost:9000/account-svc")
public interface AccountClient {
    @PostMapping(path = "/create")
    String createAccount(@RequestBody @Validated CreateAccountRequest createAccountRequest);
}
