package com.wedding.web;

import com.alibaba.fastjson.JSONObject;
import com.wedding.entity.AppInfo;
import com.wedding.entity.User;
import com.wedding.repository.AppInfoRepository;
import com.wedding.repository.UserRepository;
import com.wedding.util.HttpGetUtil;
import com.wedding.web.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/8/1 16:07
 **/
@RestController
@RequestMapping("/app")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppInfoRepository appInfoRepository;

    @PostMapping("/login")
    public @ResponseBody
    ResponseEntity<?> login(@RequestBody LoginVo loginVo) {

        LOGGER.info("=============================登录===============================");

        Map<String, Object> map = new HashMap<>(2);
        Long appInfoId = loginVo.getAppId();
        String code = loginVo.getCode();

        AppInfo appInfo = appInfoRepository.findById(appInfoId).get();

        Map<String, String> params = new HashMap(8);
        params.put("secret", appInfo.getSecret());
        params.put("appid", appInfo.getAppId());
        params.put("grant_type", "authorization_code");
        params.put("js_code", code);
        String result = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/sns/jscode2session", params);

        JSONObject json = JSONObject.parseObject(result);
        String openid = json.get("openid").toString();
        map.put("openId", openid);
        User user = userRepository.findByOpenIdAndAppId(openid, appInfoId);
        if (user == null) {
            User one = new User();
            one.setAppId(appInfoId);
            one.setAvatarUrl(loginVo.getAvatarUrl());
            one.setCreateDate(LocalDateTime.now());
            one.setGender(loginVo.getGender());
            one.setNickName(loginVo.getNickName());
            one.setOpenId(openid);
            one.setStar(1);
            user = userRepository.save(one);
        }
        map.put("user", user);
        return ResponseEntity.ok(map);
    }
}
