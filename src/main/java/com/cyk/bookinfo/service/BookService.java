package com.cyk.bookinfo.service;

import com.cyk.bookinfo.entity.Book;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface BookService {
    @Transactional(readOnly = true)
    PageInfo<Book> findAllBooks(int pageNum, int pageSize);

    void delBookById(int id);

    void saveBook(Book book);

    @Transactional(readOnly = true)
    Book findBookById(int id);

    void updateBook(Book book);
}
