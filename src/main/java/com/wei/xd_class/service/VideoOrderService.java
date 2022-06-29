package com.wei.xd_class.service;

import com.wei.xd_class.model.entity.VideoOrder;

import java.util.List;

/**
 * @author www
 * @date 2022/6/28 20:37
 * @description:
 */
public interface VideoOrderService {
    /**
     * 保存视频订单
     * @param userId
     * @param videoId
     * @return
     */
    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(int userId);
}
