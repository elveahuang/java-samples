package cn.elvea.samples.spring.boot.data.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * UserMapper
 *
 * @author elvea
 */
@Mapper
public interface UserMapper {

    Date getCurDate();

}
