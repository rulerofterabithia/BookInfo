package com.cyk.bookinfo.mapper;

import com.cyk.bookinfo.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Select("select * from t_type where id = #{id}")
    Type findById();

    @Select("select * from t_type")
    List<Type> findAll();
}
