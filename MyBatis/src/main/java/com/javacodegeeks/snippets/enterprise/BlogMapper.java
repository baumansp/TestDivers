package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BlogMapper {

    @Select("SELECT " +
            "b.blog_id, b.blog_name, b.created_on, " +
            "p.post_id as post_post_id, p.title as post_title, p.content as post_content, p.created_on as post_created_on " +
            "FROM blog b left outer join post p on b.blog_id=p.blog_id " +
            "WHERE b.BLOG_ID=#{blogId}")
    @ResultMap("BlogResult")

    Blog findBlogByID(long blogId);


    @Select("SELECT " +
            "b.blog_id, b.blog_name, b.created_on as blog_created_on, " +
            "p.post_id as post_post_id, p.title as post_title, p.content as post_content, p.created_on as post_created_on " +
            "FROM blog b left outer join post p on b.blog_id=p.blog_id")
    @ResultMap("BlogResult")
    Blog getAllBlogs();

    @Update("UPDATE blog SET blog_name=#{blogName} WHERE blog_id =#{blogId}")
    void updateBlog(Blog blog);





}