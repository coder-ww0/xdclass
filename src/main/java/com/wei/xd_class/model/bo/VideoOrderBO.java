package com.wei.xd_class.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author www
 * @date 2022/6/28 20:28
 * @description:
 */
public class VideoOrderBO {

    @JsonProperty("video_id")
    private Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
