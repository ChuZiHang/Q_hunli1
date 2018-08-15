package com.wedding.repository;

import com.wedding.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/1 15:28
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickName(String nickName);

    User findByNickNameAndAppId(String nickName, Long appId);

    User findByOpenIdAndAppId(String openId, Long appId);

    List<User> findByAppIdAndStar(Long appId, Integer star, Sort sort);
}
