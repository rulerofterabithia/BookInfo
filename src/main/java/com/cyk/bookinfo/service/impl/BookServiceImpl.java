package com.cyk.bookinfo.service.impl;

import com.cyk.bookinfo.entity.Book;
import com.cyk.bookinfo.mapper.BookMapper;
import com.cyk.bookinfo.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfo<Book> findAllBooks(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> ls = bookMapper.findAll();
        PageInfo pageInfo = new PageInfo(ls);
        return pageInfo;
    }

    @Override
    public void delBookById(int id) {
        bookMapper.delBookById(id);
    }

    @Override
    public void saveBook(Book book) {
        bookMapper.save(book);
    }

    @Override
    public Book findBookById(int id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }
}
