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

    public boolean updateUser(Long id , String name , String email , String phNo , String country) {

        UserEntity entity = new UserEntity();
        if (id != 0) {
            entity.setId(id);
            entity.setName(name);
            entity.setEmail(email);
            entity.setPhNo(phNo);
            entity.setCountry(country);
            repository.updateUserProfile(entity);
            return true;
        }
        return false;

    }


    public UserEntity getUserById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    public boolean deleteUserById(Long id) {
        boolean deleted =repository.deleteUserById(id);
        if (deleted){
            return true;
        }
        return false;
    }
}
