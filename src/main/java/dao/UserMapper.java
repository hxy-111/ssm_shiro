package dao;

import model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User getUsername(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}