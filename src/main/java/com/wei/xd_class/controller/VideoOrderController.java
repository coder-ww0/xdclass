package com.wei.xd_class.controller;

import com.wei.xd_class.model.bo.VideoOrderBO;
import com.wei.xd_class.model.entity.VideoOrder;
import com.wei.xd_class.service.VideoOrderService;
import com.wei.xd_class.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author www
 * @date 2022/6/28 20:26
 * @description:
 */

@RestController
@RequestMapping("/api/v1/pri/order")
@Api(tags = "视频订单controller")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 下单接口
     * @return JsonData
     */
    @PostMapping("/save")
    @ApiOperation("视频下单")
    public JsonData saveOrder(@RequestBody VideoOrderBO videoOrderBO, HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");

        int rows = videoOrderService.save(userId, videoOrderBO.getVideoId());
        if (rows == 0) {
            return JsonData.buildError("视频订单下单失败");
        }
        return JsonData.buildSuccess("视频订单下单成功");
    }


    @GetMapping("/list")
    @ApiOperation("用户所有的视频下单信息")
    public JsonData listOrder(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);

        return JsonData.buildSuccess(videoOrderList);
    }

}
