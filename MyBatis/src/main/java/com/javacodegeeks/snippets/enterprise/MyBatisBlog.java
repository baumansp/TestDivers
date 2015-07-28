package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class MyBatisBlog {

    private static final String conf = "mybatis.conf.xml";

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader(conf);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(reader);

        SqlSession session = sessionFactory.openSession();

        long id = 1;

        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.findBlogByID(id);
        System.out.println(blog.getBlogName());
        System.out.println(blog.getPosts().size());

        //List<Blog> lblog = (List<Blog>) mapper.getAllBlogs();
        //System.out.println("combien de blog :" + lblog.size());
        blog.setBlogName("pascal was here2");


        session.update("updateBlog", blog);


        //System.out.println(procContainer.getId());

        session.close();

    }

}
