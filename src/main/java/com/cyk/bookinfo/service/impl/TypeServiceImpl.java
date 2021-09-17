package com.cyk.bookinfo.service.impl;

import com.cyk.bookinfo.entity.Type;
import com.cyk.bookinfo.mapper.TypeMapper;
import com.cyk.bookinfo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }
}
