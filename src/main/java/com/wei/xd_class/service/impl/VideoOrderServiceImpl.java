package com.wei.xd_class.service.impl;

import com.wei.xd_class.exception.XDException;
import com.wei.xd_class.mapper.EpisodeMapper;
import com.wei.xd_class.mapper.PlayRecordMapper;
import com.wei.xd_class.mapper.VideoMapper;
import com.wei.xd_class.mapper.VideoOrderMapper;
import com.wei.xd_class.model.entity.Episode;
import com.wei.xd_class.model.entity.PlayRecord;
import com.wei.xd_class.model.entity.Video;
import com.wei.xd_class.model.entity.VideoOrder;
import com.wei.xd_class.service.VideoOrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author www
 * @date 2022/6/28 20:38
 * @description:
 */

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(int userId, int videoId) {
        // 判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdState(userId, videoId, 1);
        if (videoOrder != null) {
            return 0;
        }
        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString().trim());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);

        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        // 生成播放记录
        if (rows == 1) {
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if (episode == null) {
                throw new XDException(-1, "请联系运营人员");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }
        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(int userId) {
        return videoOrderMapper.listOrderByUserId(userId);
    }
}
