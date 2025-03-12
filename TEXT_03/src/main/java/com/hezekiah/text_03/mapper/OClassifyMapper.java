package com.hezekiah.text_03.mapper;

import com.hezekiah.text_03.entity.domain.OClassify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OClassifyMapper {
    int deleteByPrimaryKey(Integer oclassifyId);

    int insert(OClassify record);

    int insertSelective(OClassify record);

    OClassify selectByPrimaryKey(Integer oclassifyId);

    int updateByPrimaryKeySelective(OClassify record);

    int updateByPrimaryKey(OClassify record);

    List<OClassify> selectAllClassify();

}