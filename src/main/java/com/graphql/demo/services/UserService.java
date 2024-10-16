package com.graphql.demo.services;

import com.graphql.demo.ExceptionHelper;
import com.graphql.demo.models.User;
import com.graphql.demo.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user){
        return this.userRepo.save(user);
    }

    public User getUser(Integer id) {
        Optional<User> optionalUser = this.userRepo.findById(id);
        return optionalUser.orElseThrow(ExceptionHelper::resourceNotFoundException);
    }

    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    public boolean deleteUser(Integer id) {
        User user = this.userRepo.findById(id).orElseThrow(ExceptionHelper::resourceNotFoundException);
        this.userRepo.delete(user);
        return true;
    }
}