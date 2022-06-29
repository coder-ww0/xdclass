package com.wei.xd_class.mapper;

import com.wei.xd_class.model.entity.PlayRecord;
import org.springframework.stereotype.Repository;

/**
 * @author www
 * @date 2022/6/28 22:37
 * @description:
 */
@Repository
public interface PlayRecordMapper {
    int saveRecord(PlayRecord playRecord);
}
