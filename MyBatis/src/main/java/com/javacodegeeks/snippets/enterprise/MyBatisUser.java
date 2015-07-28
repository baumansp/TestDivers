package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisUser {

    private static final String conf = "mybatis.conf.xml";

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader(conf);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(reader);

        SqlSession session = sessionFactory.openSession();

        long id = 1;

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findUserByID(id);
        System.out.println(user.getFirstName());
        System.out.println(user.getBlog().getPosts().size());




        //System.out.println(procContainer.getId());



    }

}
