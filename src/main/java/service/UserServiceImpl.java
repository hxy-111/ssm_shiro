package service;

import dao.UserMapper;
import model.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUsername(String username) {
        User u = userMapper.getUsername(username);
        return userMapper.getUsername(username);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;

    }

    @Override
    public int insert(User user) {
        String pswd=   user.getPassword();
        ByteSource pswd1 = ByteSource.Util.bytes(pswd);
        Object pswd2 = new SimpleHash("MD5", pswd1, null, 1024);
        user.setPassword(pswd2.toString());
        return userMapper.insert(user);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

}
