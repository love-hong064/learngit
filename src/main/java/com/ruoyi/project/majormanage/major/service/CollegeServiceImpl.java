package com.ruoyi.project.majormanage.major.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.majormanage.major.domain.College;
import com.ruoyi.project.majormanage.major.domain.ReqCollegeListVO;
import com.ruoyi.project.majormanage.major.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xhy
 * @description: 学院管理接口实现
 * @date :2022年8月1日
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> list(ReqCollegeListVO reqCollegeListVO) {
        LambdaQueryWrapper<College> collegeLambdaQueryWrapper = new LambdaQueryWrapper<>();

        String name = reqCollegeListVO.getName();
        Date createTime = reqCollegeListVO.getCreateTime();

        collegeLambdaQueryWrapper.like(StringUtils.isNotBlank(name),College::getName,name);
        collegeLambdaQueryWrapper.like(createTime != null, College::getCreateTime,createTime);

        List<College> list = collegeMapper.selectList(collegeLambdaQueryWrapper);
        return list;
    }
}
