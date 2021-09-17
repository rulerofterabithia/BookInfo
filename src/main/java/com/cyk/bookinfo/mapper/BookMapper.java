package com.cyk.bookinfo.mapper;

import com.cyk.bookinfo.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Results({
            @Result(column = "tid", property = "type", one = @One(select = "com.cyk.bookinfo.mapper.TypeMapper.findById"))
    })
    @Select("select * from t_book")
    List<Book> findAll();

    @Delete("delete from t_book where id = #{id}")
    void delBookById(int id);

    @Insert("insert into t_book values(default,#{name},#{author},#{tid},#{price},#{descri},#{photo},#{pubDate})")
    void save(Book book);

    @Select("select * from t_book where id = #{id}")
    Book findBookById(int id);

    @Update("update t_book set name = #{name},author = #{author},tid = #{tid},price = #{price},descri = #{descri},photo = #{photo},pubDate = #{pubDate} where id = #{id}")
    void updateBook(Book book);
}
