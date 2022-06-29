package com.wei.xd_class.controller;

import com.wei.xd_class.model.bo.LoginBO;
import com.wei.xd_class.model.entity.User;
import com.wei.xd_class.service.UserService;
import com.wei.xd_class.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/login")
    @ApiOperation("用户登录接口")
    public JsonData login(@RequestBody LoginBO loginBO) {
        String token = userService.findByPhoneAndPwd(loginBO.getPhone(), loginBO.getPwd());
        return token == null ? JsonData.buildError("账号或密码错误") : JsonData.buildSuccess(token);
    }

    @PostMapping("/test")
    @ApiOperation("用户测试接口")
    public JsonData test() {
        return JsonData.buildSuccess("测试方法成功");
    }

    @GetMapping("/findByToken")
    @ApiOperation("通过token查找用户信息")
    public JsonData findUserInfoByToken(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null) {
            return JsonData.buildError("查询失败");
        }
        User user = userService.finByUserId(userId);
        return JsonData.buildSuccess(user);
    }

}
