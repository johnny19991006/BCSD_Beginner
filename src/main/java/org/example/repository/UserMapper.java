package org.example.repository;


import org.example.domain.Reply;
import org.example.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserById(Long UserId);
    void create(User user);
    void update(User user);
    void delete(Long UserId);
}
