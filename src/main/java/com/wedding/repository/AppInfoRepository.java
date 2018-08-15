package com.wedding.repository;

import com.wedding.entity.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName AppInfoRepository
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/2 10:26
 **/
public interface AppInfoRepository extends JpaRepository<AppInfo,Long> {
}
