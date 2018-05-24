package com.zhangling.mybatis.mapper;

import com.zhangling.mybatis.model.db.UserDBModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERDBMODEL WHERE account = #{account}")
    UserDBModel findByAccount(@Param("account") String account);

    @Insert("INSERT INTO USERDBMODEL(account,password,salt,passwordEncryptedCount) VALUES(#{account}, #{password}, #{salt}, #{passwordEncryptedCount})")
    void save(UserDBModel userDBModel);
}
