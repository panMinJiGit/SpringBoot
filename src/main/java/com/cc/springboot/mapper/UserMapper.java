package com.cc.springboot.mapper;

import com.cc.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    
    List<UserEntity> selectAll();

}
