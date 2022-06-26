package com.wei.xd_class.service;

import com.wei.xd_class.model.entity.Video;
import com.wei.xd_class.model.entity.VideoBanner;

import java.util.List;

/**
 * @author www
 * @date 2022/6/25 14:14
 * @description: TODO
 */

public interface VideoService {
    /**
     * 展示所有视频
     * @return
     */
    List<Video> listVideo();

    /**
     * 展示轮播图
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 通过id查找视频详情
     * @param id
     * @return
     */
    Video findVideoDetailById(Integer id);
}
