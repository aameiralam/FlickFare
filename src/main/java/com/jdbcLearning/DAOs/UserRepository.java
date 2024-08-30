package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.User;

import java.util.List;

public interface UserRepository {
    
    public int insertUser(User user);
    
    public List<User> getAllUser();
    
    public int updateUser(User updatedUser);
    
    public int deleteUser(User deletedUser);
    
    
}
