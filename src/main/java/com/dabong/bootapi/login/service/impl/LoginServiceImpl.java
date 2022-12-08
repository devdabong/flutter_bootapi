package com.dabong.bootapi.login.service.impl;

import com.dabong.bootapi.login.dao.LoginDAO;
import com.dabong.bootapi.login.service.LoginService;
import com.dabong.bootapi.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public UserVO selectUser(UserVO vo) throws Exception {
        return loginDAO.selectUser(vo);
    }

    @Override
    public int selectUserCount(UserVO vo) throws Exception {
        return loginDAO.selectUserCount(vo);
    }

    @Override
    public int insertUser(UserVO vo) throws Exception {
        return loginDAO.insertUser(vo);
    }

}
