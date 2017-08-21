package com.ula.grootforum.services;

import com.ula.grootforum.model.User;
import com.ula.grootforum.repositories.UserRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Urszula Kalinowska-Drozd on 07.08.17.
 */

@Service
public class UserService{

    @Resource
    private UserRepository userRepository;
    @Transactional
    public User findUserById(Long id){
        return userRepository.findOne(id);
    }
    @Transactional
    public User findUserByUserName(String name){
        return userRepository.findByUserName(name);
    }
    @Transactional
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    @Transactional
    public Long saveUserAndGetUserId(User user){
        userRepository.save(user);
        return user.getUserId();
    }
    @Transactional
    public void deleteUser(Long id){
        userRepository.delete(userRepository.findOne(id));
    }

}
