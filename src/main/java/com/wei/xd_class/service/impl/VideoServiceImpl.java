package com.wei.xd_class.service.impl;

import com.wei.xd_class.model.entity.Video;
import com.wei.xd_class.model.entity.VideoBanner;
import com.wei.xd_class.mapper.VideoMapper;
import com.wei.xd_class.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author www
 * @date 2022/6/25 14:16
 * @description: TODO
 */

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public List<Video> listVideo() {
        return videoMapper.videoList();
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        return videoMapper.videoBannerList();
    }

    @Override
    public Video findVideoDetailById(Integer id) {
        return videoMapper.findDetailById(id);
    }


}
