package shiro;

import dao.UserMapper;
import model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthenticatingRealm {

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /**
         * 1.把AuthenticationToken的类型转换成UsernamePasswordToken
         */
        UsernamePasswordToken put= (UsernamePasswordToken)token;
        /**
         * 2.从put中获取床传递过来的用户名
         */
        String username= put.getUsername();
        /**
         * 3.通过username在数据库中去查询有没有对应的数据库信息
         */
        User loginUser = userMapper.getUsername(username);
        /**
         * 4.如果loginUser不存在，抛出异常
         */
        if(loginUser == null){
            throw  new UnknownAccountException("此用户不存在");
        }
        /**
         * 5.如果闩被禁用，跑出锁定用户异常
         */
          if(loginUser.getState()==0){
              throw  new  LockedAccountException("此用户被锁");
          }
        AuthenticationInfo info = new SimpleAuthenticationInfo(loginUser, loginUser.getPassword(), getName());
        return info;
    }
}
