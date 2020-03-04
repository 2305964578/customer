package net.marssky.accountsvc.service;

import net.marssky.accountsvc.model.Staff;
import net.marssky.accountsvc.repo.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    StaffRepo staffRepo;

    public List<Staff> getStaffs(){
        return staffRepo.getStaffs();
    }
}
