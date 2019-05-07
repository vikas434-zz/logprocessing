package com.halodoc.logprocessor.dao;

import com.halodoc.logprocessor.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
}
