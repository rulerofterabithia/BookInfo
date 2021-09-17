package com.cyk.bookinfo.mapper;

import com.cyk.bookinfo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into t_user values(default,#{name},#{pwd},#{birthday},#{age},#{photo})")
    void save(User user);

    @Select("select * from t_user where name=#{name} and pwd=#{pwd}")
    User findUserByNameAndPwd(User user);
}
