package com.wei.xd_class.mapper;

import com.wei.xd_class.model.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author www
 * @date 2022/6/26 13:56
 * @description: TODO
 */

@Repository
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 通过手机号查找用户
     * @param phone
     * @return
     */
    User findByPhone(@Param("phone") String phone);

    /**
     * 登录
     * @param
     * @return
     */
    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 根据用户id查找用户信息
     * @param userId
     * @return
     */
    User findByUserId(@Param("userId") Integer userId);
}
