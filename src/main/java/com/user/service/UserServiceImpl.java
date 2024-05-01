package com.user.service;

import com.user.model.UserModel;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel insert(UserModel userModel) {
        UserModel user=userRepository.save(userModel);
        return user;
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel>userAll=userRepository.findAll();
        return userAll;
    }

    @Override
    public void deleteByRoll(Long roll) {
        userRepository.deleteById(roll);
    }
}
