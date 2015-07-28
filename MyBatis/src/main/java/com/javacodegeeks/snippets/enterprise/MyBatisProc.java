package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class MyBatisProc {

    private static final String conf = "mybatis.conf.xml";

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader(conf);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(reader);

        SqlSession session = sessionFactory.openSession();

        long id = 1;

        ProcMapper mapper = session.getMapper(ProcMapper.class);
        ContainerList procContainer = mapper.findAll();

        System.out.println("fin");

        //System.out.println(procContainer.getId());



    }

}
