package net.marssky.accountsvc.controller;

import net.marssky.accountsvc.dto.AccountDto;
import net.marssky.accountsvc.model.Staff;
import net.marssky.accountsvc.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    Log log= LogFactory.getLog(AccountController.class);
    @Autowired
    AccountService accountService;

    @RequestMapping("/create")
    public String CreateAccount(@RequestBody AccountDto accountDto){
        log.info("调用账户服务模块的createAccount方法来注册");
        log.debug(accountDto.getEmail());
        return "success";
    }

    @RequestMapping("/get_accounts")
    public List<Staff> getAccounts(){
        System.out.println("查询");
        List<Staff> list=this.accountService.getStaffs();
        System.out.println("数据一共有"+list.size());

        return list;
    }
}
