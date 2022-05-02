package com.management.managment_purchase_order.service;

import com.management.managment_purchase_order.entity.User;
import com.management.managment_purchase_order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> get(){
        return userRepository.findAll();
    }
}
