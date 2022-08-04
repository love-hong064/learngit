package com.ruoyi.project.majormanage.major.service;

import com.ruoyi.common.constant.MajorConstants;
import com.ruoyi.project.majormanage.major.domain.Major;
import com.ruoyi.project.majormanage.major.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MajorServiceImpl implements IMajorService{
    @Autowired
    private MajorMapper majorMapper;

    /**
     * 查询专业列表
     * @param major
     * @return
     */
    @Override
    public List<Major> selectMajorList(Major major) {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 检查专业名是否唯一
     * @param majorName
     * @return
     */
    @Override
    public String checkMajorNameUnique(String majorName) {
        int count =majorMapper.checkMajorNameUnique(majorName);
        if(count > 0){
            return MajorConstants.MAJOR_NAME_NOT_UNIQUE;
        }
        return MajorConstants.MAJOR_NAME_UNIQUE;
    }

    @Override
    public int insertMajor(Major major) {
        major.setCreateTime(new Date());
        int rows = majorMapper.insertMajor(major);
        return rows;
    }
}
