package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class MyBatisEmployee {

    private static final String conf = "mybatis.conf.xml";

    public static void main(String[] args) throws Exception {

        Reader reader = Resources.getResourceAsReader(conf);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(reader);

        SqlSession session = sessionFactory.openSession();

        long id = 1;

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.findById(id);

//        System.out.println(employee.getId() + " - " + employee.getName() +
//                " - " + employee.getSurname() + " - " + employee.getCreated().toString());

        Employee employee2;
        employee2 = mapper.findbyId2(id,"Pascal");

//        System.out.println(employee2.getId() + " - " + employee2.getName() +
//                " - " + employee2.getSurname() + " - " + employee2.getCreated().toString());

        List<Employee> list = mapper.findAll();

        for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            System.out.println(next.getId() + " - " + next.getName() +
                    " - " + next.getSurname() + " - " + next.getCreated().toString());
        }


    }

}
