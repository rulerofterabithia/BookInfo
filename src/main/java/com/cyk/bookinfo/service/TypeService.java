package com.cyk.bookinfo.service;

import com.cyk.bookinfo.entity.Type;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TypeService {
    @Transactional(readOnly = true)
    List<Type> findAll();
}
