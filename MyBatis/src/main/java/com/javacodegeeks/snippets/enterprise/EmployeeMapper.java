package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    @ResultMap("employeeResultMap")
    Employee findById(long id);

    @Select("SELECT * FROM employee WHERE id = #{hisId} and surname = #{nickName} ")
    @ResultMap("employeeResultMap")
    Employee findbyId2(@Param("hisId") long hisId,@Param("nickName") String nickName);

    @Select("SELECT * FROM employee")
    @ResultMap("employeeResultMap")
    List<Employee> findAll();


}