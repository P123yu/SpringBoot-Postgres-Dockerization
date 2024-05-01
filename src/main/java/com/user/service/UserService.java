package com.user.service;

import com.user.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // insert
    UserModel insert(UserModel userModel);

    // getAll
    List<UserModel> getAll();

    // delete
    void deleteByRoll(Long roll);
}
