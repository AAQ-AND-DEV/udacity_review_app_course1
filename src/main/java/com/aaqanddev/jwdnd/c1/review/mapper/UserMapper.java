package com.aaqanddev.jwdnd.c1.review.mapper;

import com.aaqanddev.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<User> getAllUsers();

    @Select("SELECT * FROM USERS WHERE userid=#{id}")
    User getUserById(Integer id);

    @Select("SELECT * FROM USERS WHERE username=#{name}")
    User getUser(String name);

    @Insert("INSERT INTO USERS(username,salt,password,firstname,lastname) " +
            "VALUES(#{username},#{salt}, #{password}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insertUser(User user);

    @Delete("DELETE from USERS WHERE userid=#{id}")
    void deleteUser(int id);
}
