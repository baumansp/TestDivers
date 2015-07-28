package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT "+
            "U.USER_ID, U.EMAIL_ID, U.PASSWORD, U.FIRST_NAME, U.LAST_NAME, " +
            "B.BLOG_ID, B.BLOG_NAME, B.CREATED_ON " +
            "FROM USER U LEFT OUTER JOIN BLOG B ON U.BLOG_ID=B.BLOG_ID " +
            "WHERE U.USER_ID = #{userId}")
    @ResultMap("UserResult")

    User findUserByID(long userId);


    @Select("SELECT " +
            "U.USER_ID, U.EMAIL_ID, U.PASSWORD, U.FIRST_NAME, U.LAST_NAME, " +
            "B.BLOG_ID, B.BLOG_NAME, B.CREATED_ON " +
            "FROM USER U LEFT OUTER JOIN BLOG B ON U.BLOG_ID=B.BLOG_ID")
    @ResultMap("UserResult")
    User getAllUsers();



}