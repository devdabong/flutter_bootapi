package com.dabong.bootapi.login.controller;

import com.dabong.bootapi.login.service.LoginService;
import com.dabong.bootapi.login.vo.UserVO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//크롬 확장 프로그램 => Talend API Tester - Free Edition 으로 API 테스트 진행.
/**
 * Request 받고 JSON으로 Response 하는 API1
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String main() {
        log.info("main");
        return "index";
    }

    @GetMapping("/getData")
    public String getData(Model model) throws Exception {
        log.info("getData");
        UserVO vo = new UserVO();
        vo.setUserName("테스트");
        vo = loginService.selectUser(vo);
        model.addAttribute("user", vo);

        return "index";
    }

    @GetMapping("/sendData")
    public UserVO sendData() throws Exception {
        log.info("sendData");
        UserVO vo = new UserVO();
        vo.setUserName("테스트");
        UserVO user = loginService.selectUser(vo);

        return user;
    }

    @GetMapping("/sendData/{userName}")
    @ResponseBody
    public UserVO sendDataUserName(@PathVariable(value = "userName") String name) throws Exception {
        log.info("sendData");
        UserVO vo = new UserVO();
        vo.setUserName(name);
        UserVO user = loginService.selectUser(vo);

        return user;
    }

    @GetMapping("/sendData2")
    public UserVO sendData2(UserVO vo) throws Exception {
        log.info("sendData");
        log.info(vo.toString());
        UserVO user = loginService.selectUser(vo);

        return user;
    }

    @PostMapping("/sendData/post")
    public UserVO sendDataPost(UserVO vo) throws Exception {
        log.info("sendDataPost");
        UserVO user = loginService.selectUser(vo);

        return user;
    }
    @PostMapping("/sendData/post2")
    public UserVO sendDataPost2() throws Exception {
        log.info("sendDataPost2");
        UserVO vo = new UserVO();
        vo.setUserName("테스트");
        UserVO user = loginService.selectUser(vo);

        return user;
    }
}
