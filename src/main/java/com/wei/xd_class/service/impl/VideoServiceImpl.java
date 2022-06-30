package com.wei.xd_class.service.impl;

import com.wei.xd_class.config.CacheKeyManager;
import com.wei.xd_class.model.entity.Video;
import com.wei.xd_class.model.entity.VideoBanner;
import com.wei.xd_class.mapper.VideoMapper;
import com.wei.xd_class.service.VideoService;
import com.wei.xd_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author www
 * @date 2022/6/25 14:16
 * @description: TODO
 */

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;


    @Override
    public List<Video> listVideo() {
        try {
            Object cacheObject = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, () -> {
                List<Video> videoList = videoMapper.videoList();
                return videoList;
            });
            if (cacheObject instanceof List) {
                List<Video> videoList = (List<Video>) cacheObject;
                return videoList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        try {
            Object cacheObject = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> bannerList = videoMapper.videoBannerList();
                System.out.println("从数据库找轮播图列表");
                return bannerList;
            });
            if (cacheObject instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObject;
                System.out.println("从缓存中查找轮播图");
                return bannerList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video findVideoDetailById(Integer id) {
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, id);
        try {
            Object cacheObject = baseCache.getTenMinuteCache().get(videoCacheKey, () -> {
                Video video = videoMapper.findDetailById(id);
                return video;
            });
            if (cacheObject instanceof Video) {
                Video video = (Video) cacheObject;
                return video;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 也可返回降级的视频对象
        return null;
    }


}
