package com.nee.demo.orm.mapper;

import com.nee.demo.orm.model.DemoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestModelMapper {
    //jdbcType=BIGINT VARCHAR

    @Select("select id,user_name userName,password,age, created_at createTime from test_model")
    public List<DemoModel> queryAll();

    @Select("select id,user_name userName,password,age, created_at createTime from test_model where user_name=#{userName} and password=#{password}")
    public DemoModel query(@Param("userName") String userName, @Param("password") String password);

    @Select("select id,user_name userName,password,age, created_at createTime  from test_model where user_name like CONCAT('%',#{userName},'%')")
    public List<DemoModel> queryByUserName(@Param("userName") String userName);
}
