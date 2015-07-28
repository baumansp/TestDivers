package com.javacodegeeks.snippets.enterprise;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProcMapper {

    @Select("SELECT  c.id as ID, c.Nom as NOM, p.PROC_ID as PROC_ID, pc.CONTAINERID " +
            "FROM container c " +
            "LEFT OUTER JOIN proc_container pc on c.id = pc.CONTAINERID " +
            "LEFT OUTER JOIN proc p on p.PROC_ID = pc.PROCID;")
    @ResultMap("ListContainerResultMap")
    ContainerList findAll();

/*
    @Select("SELECT  c.id as ID, p.PROC_ID as PROC_ID " +
            "FROM container c, proc p, proc_container pc " +
            "WHERE c.id = pc.CONTAINER_ID " +
            "AND   p.PROC_ID = pc.PROC_ID")
    @ResultMap("ListContainerResultMap")
    ContainerList findAll();
*/



}