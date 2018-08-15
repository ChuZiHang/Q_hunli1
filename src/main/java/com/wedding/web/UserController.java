package com.wedding.web;

import com.wedding.entity.User;
import com.wedding.entity.UserMessage;
import com.wedding.entity.WedInfo;
import com.wedding.repository.UserMessageRepository;
import com.wedding.repository.UserRepository;
import com.wedding.repository.WedInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/1 15:30
 **/
@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WedInfoRepository wedInfoRepository;

    @Autowired
    private UserMessageRepository userMessageRepository;

    @GetMapping("/user")
    public String get() {
        return "hello word";
    }

    @GetMapping("/wedInfo")
    public @ResponseBody
    ResponseEntity<?> getWedInfo(@RequestParam Long appId) {
        WedInfo wedInfo = wedInfoRepository.findByAppId(appId);
        return ResponseEntity.ok(wedInfo);
    }

    @GetMapping("/user/star")
    public @ResponseBody
    ResponseEntity<?> getStar(@RequestParam Long appId) {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<User> list = userRepository.findByAppIdAndStar(appId, 2, sort);

        return ResponseEntity.ok(list);
    }

    @PostMapping("/user/star")
    public @ResponseBody
    ResponseEntity<?> update(@RequestBody User user) {
        User one = userRepository.findByOpenIdAndAppId(user.getOpenId(), user.getAppId());
        if (one.getStar() == 2) {
            throw new RuntimeException("已经赞过啦~~");
        }
        one.setStar(2);
        userRepository.save(one);
        return ResponseEntity.ok(one);
    }

    @GetMapping("/userMessage")
    public @ResponseBody
    ResponseEntity<?> getMsg(@RequestParam Long appId) {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<UserMessage> list = userMessageRepository.findByAppId(appId, sort);

        return ResponseEntity.ok(list);
    }

    @PostMapping("/userMessage")
    public @ResponseBody
    ResponseEntity<?> createMsg(@RequestBody UserMessage userMessage) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);

        userMessage.setCreateDate(localTime);
        userMessageRepository.save(userMessage);

        return ResponseEntity.ok(userMessage);
    }
}
