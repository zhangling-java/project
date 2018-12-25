package com.zhangling.mybatis.mapper;

import com.zhangling.mybatis.model.db.UserDBModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*对于简单语句来说，注解使代码显得更加简洁，然而 Java 注解对于稍微复杂的语句就会力不从心并且会显得更加混乱。因此，如果你需要做很复杂的事情，那么最好使用 XML 来映射语句。*/
@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERDBMODEL WHERE account = #{account}")
    UserDBModel findByAccount(@Param("account") String account);

    @Insert("INSERT INTO USERDBMODEL(account,password,salt,passwordEncryptedCount) VALUES(#{account}, #{password}, #{salt}, #{passwordEncryptedCount})")
    void save(UserDBModel userDBModel);
}
