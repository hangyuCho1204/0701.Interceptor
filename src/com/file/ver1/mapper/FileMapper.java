package com.file.ver1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.file.ver1.dto.User;


public interface FileMapper {
	/*@Insert("insert into fileboard(id, writer, title) values( #{id}, #{writer}, #{title})")
	@SelectKey(statement="select fileBoard_seq.nextval from dual", keyProperty="id", before=true, resultType=int.class)
	public int saveDomain(EntityFileBoard entityFileBoard);*/
	
	
	
	@Select("select * from usertable where id = #{id}")
	public User getLoginBean(String id);	
	
}
