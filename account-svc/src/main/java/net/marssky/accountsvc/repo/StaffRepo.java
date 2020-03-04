package net.marssky.accountsvc.repo;

import net.marssky.accountsvc.model.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StaffRepo {
    public List<Staff> getStaffs();
}
