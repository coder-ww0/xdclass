package com.wei.xd_class.config;

/**
 * @author www
 * @date 2022/6/30 21:36
 * @description: 缓存key管理
 */


public class CacheKeyManager {

    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * 首页视频列表
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 视频详情缓存key, %s是视频id
     */
    public static final String VIDEO_DETAIL = "video:detail:%S";
}
