package com.saqib.user_management_system.service;

import com.saqib.user_management_system.dto.RegisterDto;
import com.saqib.user_management_system.dto.UserDto;
import com.saqib.user_management_system.entity.RegisterEntity;
import com.saqib.user_management_system.entity.UserEntity;
import com.saqib.user_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public RegisterEntity checkLogin(String email, String password) {

        RegisterEntity user = repository.getEntityByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    //REGISTERING EMAIL
    public boolean validate(RegisterDto dto) {
        RegisterEntity entity = new RegisterEntity();
        boolean valid = false;
        if (dto != null) {
            entity.setEmail(dto.getEmail());
            entity.setPassword(dto.getPassword());
            repository.save(entity);
            valid = true;
        }
        return valid;
    }

    //GET ALL USERS
    public List<UserEntity> getAllUsers() {
        return repository.getAllUsers();
    }

    // ADD NEW USERS
    @Transactional
    public boolean addUser(UserDto dto) {

        UserEntity entity = new UserEntity();
        boolean valid = false;
        if (dto != null) {
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setCountry(dto.getCountry());
            entity.setPhNo(dto.getPhNo());
            repository.saveUser(entity);
            valid = true;
        }
        return valid;
    }


    @Transactional
    public boolean deleteUserById(Long id) {
        boolean deleted = repository.deleteUserById(id);
        if (deleted) {
            return true;
        }
        return false;
    }

    @Transactional
    public void updateUser(UserEntity user) {
        UserEntity existingUser = repository.getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhNo(user.getPhNo());
            existingUser.setCountry(user.getCountry());
            repository.updateUser(existingUser);
        }
    }

    public UserEntity getUserById(Long id) {
        return repository.findById(id);
    }
}
