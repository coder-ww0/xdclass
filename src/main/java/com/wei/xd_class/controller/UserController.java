package com.wei.xd_class.controller;

import com.wei.xd_class.service.UserService;
import com.wei.xd_class.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author www
 * @date 2022/6/26 13:46
 * @description: TODO
 */

@RestController
@RequestMapping("/api/v1/pri/user")
@Api(tags = "用户相关controller")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("用户注册相关")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int result = userService.saveUser(userInfo);
        if (result == 1) {
            return JsonData.buildSuccess("用户注册成功");
        }
        return JsonData.buildError("用户注册失败");
    }
}
