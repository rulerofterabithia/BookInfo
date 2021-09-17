package com.cyk.bookinfo.service;

import com.cyk.bookinfo.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    void saveUser(User user);

    @Transactional(readOnly = true)
    User findUserByNameAndPwd(User user);
}
