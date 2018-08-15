package com.wedding.repository;

import com.wedding.entity.WedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName WedInfoRepository
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/2 16:28
 **/
public interface WedInfoRepository extends JpaRepository<WedInfo, Long> {

    WedInfo findByAppId(Long appId);
}
