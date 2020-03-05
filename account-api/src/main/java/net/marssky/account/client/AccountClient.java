package net.marssky.account.client;

import net.marssky.account.dto.CreateAccountRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface AccountClient {

    String createAccount(@RequestBody CreateAccountRequest createAccountRequest);
}
