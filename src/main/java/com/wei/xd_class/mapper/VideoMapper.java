package com.wei.xd_class.mapper;

import com.wei.xd_class.model.entity.Video;
import com.wei.xd_class.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author www
 * @date 2022/6/25 14:10
 * @description: TODO
 */
@Repository
public interface VideoMapper {
    /**
     * 展示所有的video列表
     * @return
     */
    List<Video> videoList();

    List<VideoBanner> videoBannerList();

    Video findDetailById(@PathParam("id") Integer id);

    Video findById(@Param("videoId") int videoId);
}
