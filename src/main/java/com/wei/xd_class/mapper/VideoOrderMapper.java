package com.wei.xd_class.mapper;

import com.wei.xd_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author www
 * @date 2022/6/28 20:48
 * @description:
 */

@Repository
public interface VideoOrderMapper {
    VideoOrder findByUserIdAndVideoIdState(@Param("userId") int userId, @Param("videoId") int videoId, @Param("state") int state);

    int saveOrder(VideoOrder videoOrder);

    /**
     * 通过用户id找到用户的所有下单信息
     * @param userId
     * @return List<VideoOrder> 所有的信息
     */
    List<VideoOrder> listOrderByUserId(@Param("userId") int userId);

}
