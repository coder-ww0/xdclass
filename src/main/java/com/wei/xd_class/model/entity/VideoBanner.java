package com.wei.xd_class.model.entity;

import java.util.Date;

/**
 * @author www
 * @date 2022/6/25 12:06
 * @description: 视频轮播图
 */
public class VideoBanner {
    private Integer id;
    private String url;
    private Date createTime;
    private Integer weight;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", weight=" + weight +
                '}';
    }
}
