package com.dabong.bootapi.login.service;

import com.dabong.bootapi.login.vo.UserVO;

public interface LoginService {

    public UserVO selectUser(UserVO vo) throws Exception;

}
