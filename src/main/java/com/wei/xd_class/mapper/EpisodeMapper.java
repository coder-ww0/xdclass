package com.wei.xd_class.mapper;

import com.wei.xd_class.model.entity.Episode;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.nullness.qual.PolyRaw;
import org.springframework.stereotype.Repository;

/**
 * @author www
 * @date 2022/6/28 22:27
 * @description:
 */

@Repository
public interface EpisodeMapper {
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
