package com.wei.xd_class.model.entity;

import java.util.Date;

/**
 * @author www
 * @date 2022/6/25 12:15
 * @description: TODO
 */
public class Episode {
    private Integer id;
    private String title;
    private Integer num;
    private Integer ordered;
    private String playUrl;
    private Integer chapterId;
    private Integer free;
    private Integer videoId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", ordered=" + ordered +
                ", playUrl='" + playUrl + '\'' +
                ", chapterId=" + chapterId +
                ", free=" + free +
                ", videoId=" + videoId +
                ", createTime=" + createTime +
                '}';
    }
}