package org.example.service;


import org.example.domain.User;
import org.example.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserInfo(long UserId) {
        return userMapper.getUserById(UserId);
    }

    public void createUser(User user) {
        userMapper.create(user);
    }
    public void updateUser(long UserId, User updateUser) {
        User userTest= userMapper.getUserById(UserId);

        if(userTest!=null){
            userTest.setUserPw(updateUser.getUserPw());
            userTest.setUserBirth(updateUser.getUserBirth());
            userTest.setUserEmail(updateUser.getUserEmail());
            userTest.setUserName(updateUser.getUserName());
            userTest.setUserSex(updateUser.getUserSex());
            userMapper.update(userTest);
        }else{
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }

    public void deleteUser(long UserId) {
        if(userMapper.getUserById(UserId)!=null){
            userMapper.delete(UserId);
        }else{
            throw new IllegalStateException("회원이 존재하지 않습니다");
        }
    }
}
