package org.example.service;


import org.example.domain.User;

public interface UserService {
    User getUserInfo(long UserId);

    void createUser(User user);
    void updateUser(long UserId,User user);
    void deleteUser(long UserId);
}
