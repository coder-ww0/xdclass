package com.wei.xd_class.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wei.xd_class.utils.JWTUtils;
import com.wei.xd_class.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author www
 * @date 2022/6/26 21:42
 * @description:
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到方法之前方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }
            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JWTUtils.checkJWT(accessToken);
                if (claims == null) {
                    // 告诉登录过期，重新登录
                    sendJsonMessage(response, JsonData.buildError("登录失败,请重新登录"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;
            }
        } catch (Exception e) {
            sendJsonMessage(response, JsonData.buildError("登录失败,请重新登录"));
        }
        sendJsonMessage(response, JsonData.buildError("登录失败,请重新登录"));
        return false;
    }

    private void sendJsonMessage(HttpServletResponse response, Object msg) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(msg));
            writer.close();
            response.flushBuffer();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
