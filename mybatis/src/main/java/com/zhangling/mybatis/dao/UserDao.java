package com.zhangling.mybatis.dao;

import com.zhangling.mybatis.model.db.UserDBModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserDBModel selectCityById(long id) {
        return this.sqlSession.selectOne("selectCityById", id);
    }
}
