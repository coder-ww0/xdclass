package com.wei.xd_class.service;

import com.wei.xd_class.domain.User;

import java.util.Map;

/**
 * @author www
 * @date 2022/6/26 14:12
 * @description: TODO
 */
public interface UserService {
    int saveUser(Map<String, String> userInfo);

    User findByPhone(String phone);
}
