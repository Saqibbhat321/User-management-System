package com.saqib.user_management_system.repository;

import com.saqib.user_management_system.entity.RegisterEntity;
import com.saqib.user_management_system.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    void save(RegisterEntity registerEntity);
    RegisterEntity getEntityByEmail(String email);
    List<UserEntity> getAllUsers();

    boolean saveUser(UserEntity user);
}
