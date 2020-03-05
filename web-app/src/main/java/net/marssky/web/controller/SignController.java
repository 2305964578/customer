package net.marssky.web.controller;

import net.marssky.account.client.AccountClient;
import net.marssky.account.dto.CreateAccountRequest;
import net.marssky.web.dto.Account;
import net.marssky.web.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SignController {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RequestMapping("/signup")
    @ResponseBody
    public String signUp(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "password") String password) {
        System.out.println("注册");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:9000/account-svc/v1/account/create";
        Map<String,String> map=new HashMap<>();
        map.put("email",email);
        map.put("password",password);
//        String result = restTemplate.getForObject(url, String.class,map);
        String result = restTemplate.postForObject(url,map,String.class);
        System.out.println("1111111111");
        if ("success".equalsIgnoreCase(result)) {
            return "ok";
        }

        return "err";
    }

    @RequestMapping("/signup2")
    @ResponseBody
    public String signUp2(Account account) {
        System.out.println("注册");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:9000/account-svc/v1/account/create";
        HttpEntity<Account> body=new HttpEntity<>(account);
        String result = restTemplate.postForObject(url,body,String.class);
        System.out.println(account.getEmail());


        if ("success".equalsIgnoreCase(result)) {
            return "ok";
        }

        return "err";
    }

    @RequestMapping("/get_accounts")
    @ResponseBody
    public List<Staff> getStaffs(Account account) {

        HttpEntity<Account> body=new HttpEntity<>(account);
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:9000/account-svc/v1/account/get_accounts";

        ParameterizedTypeReference<List<Staff>> typeReference=new ParameterizedTypeReference<List<Staff>>() {};
        ResponseEntity<List<Staff>> re=restTemplate.exchange(url, HttpMethod.GET,body,typeReference);
        List<Staff> list=re.getBody();
        return list;

    }

    @Autowired
    AccountClient accountClient;

    @RequestMapping("/signup4")
    @ResponseBody
    public String signUp4(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "password") String password) {
        System.out.println("有一个acount-api接口的注册注册");
        CreateAccountRequest createAccountRequest=new CreateAccountRequest();
        createAccountRequest.setEmail(email);
        createAccountRequest.setPassword(password);
        String result=this.accountClient.createAccount(createAccountRequest);

        if ("success".equalsIgnoreCase(result)) {
            return "ok";
        }

        return "err";
    }
}
