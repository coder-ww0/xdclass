package com.wei.xd_class.service.impl;

import com.wei.xd_class.model.entity.User;
import com.wei.xd_class.mapper.UserMapper;
import com.wei.xd_class.service.UserService;
import com.wei.xd_class.utils.CommonUtils;
import com.wei.xd_class.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author www
 * @date 2022/6/26 14:13
 * @description: TODO
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Map<String, String> userInfo) {

        User insertUser = parseToUser(userInfo);
        if (insertUser != null) {
            return userMapper.saveUser(insertUser);
        } else {
            return -1;
        }
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if (user == null) {
            return null;
        } else {
            String token = JWTUtils.generateJsonWenToken(user);
            return token;
        }
    }

    private User parseToUser(Map<String, String> userInfo) {
        User user = new User();
        if (userInfo.containsKey("name") && userInfo.containsKey("pwd") && userInfo.containsKey("phone")) {
            user.setName(userInfo.get("name"));
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg("![](https://images-1305224735.cos.ap-guangzhou.myqcloud.com/imooc-course/202201061958944.jfif)");
            // todo md5加密
            user.setPwd(CommonUtils.MD5(userInfo.get("pwd")));
            return user;
        }
        return null;
    }
}
