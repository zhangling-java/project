package com.ccydsz.ysec.obd.repository;

import com.ccydsz.ysec.obd.model.db.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
    UserModel findByAccount(String account);
    UserModel findByPhoneNumber(String phoneNumber);
}
