package com.sunshine.shine.dao;

import com.sunshine.shine.dao.model.User;

public interface UserMapper {
    User selectOneUser(Integer id);
}
