package com.hezekiah.text_03.service;

import com.hezekiah.text_03.entity.domain.OClassify;
import com.hezekiah.text_03.mapper.OClassifyMapper;
import com.hezekiah.text_03.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OClassifyService {
    //注⼊
    @Autowired
    private OClassifyMapper oClassifyMapper;

    public Map<String, Object> getAllClassify() {
        List<OClassify> oclassifyListify = oClassifyMapper.selectAllClassify();
        return HttpResult.success("查询成功", oclassifyListify);
    }

    public Map<String, Object> getByPrimaryKey(Integer oclassifyId) {
        OClassify oclassify = oClassifyMapper.selectByPrimaryKey(oclassifyId);
        return HttpResult.success("查询成功", oclassify);
    }

}

