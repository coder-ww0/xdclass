package com.wei.xd_class.config;

import com.wei.xd_class.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author www
 * @date 2022/6/26 22:08
 * @description: 拦截器配置
 *                  不用权限可以访问url /api/v1/pub
 *                  需要登录才可以访问url /api/v1/pri
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截和不拦截的内容的配置
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/api/v1/pri/*/*/**")
                .excludePathPatterns("/api/v1/pri/user/login", "/api/v1/pri/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
