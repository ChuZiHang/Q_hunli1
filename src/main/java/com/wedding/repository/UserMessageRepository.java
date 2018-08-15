package com.wedding.repository;

import com.wedding.entity.UserMessage;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName UserMessageRepository
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/2 17:53
 **/
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    List<UserMessage> findByAppId(Long appId, Sort sort);
}
