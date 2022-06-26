package com.wei.xd_class.controller;

import com.wei.xd_class.model.entity.Video;
import com.wei.xd_class.model.entity.VideoBanner;
import com.wei.xd_class.service.VideoService;
import com.wei.xd_class.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author www
 * @date 2022/6/25 14:17
 * @description: TODO
 */

@RestController()
@Api(tags = "视频controller")
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    @ApiOperation("展示所有的视频列表信息")
    public JsonData listVideo() {
        List<Video> videoList = videoService.listVideo();
        int i = 1 / 0;
        return JsonData.buildSuccess(videoList);
    }

    @GetMapping("/list-banner")
    @ApiOperation("轮播图列表")
    public JsonData indexBanner() {
        List<VideoBanner> videoBannerList = videoService.listVideoBanner();
        return JsonData.buildSuccess(videoBannerList);
    }

    @GetMapping("/detail-video")
    @ApiOperation("查找视频详情通过Id")
    public JsonData findVideoDetailById(@RequestParam Integer id) {
        Video video = videoService.findVideoDetailById(id);
        return JsonData.buildSuccess(video);
    }
}
