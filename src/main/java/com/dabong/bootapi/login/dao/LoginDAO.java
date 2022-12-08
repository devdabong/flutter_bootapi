package com.dabong.bootapi.login.dao;

import com.dabong.bootapi.login.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {

    public UserVO selectUser(UserVO vo) throws Exception;

}
