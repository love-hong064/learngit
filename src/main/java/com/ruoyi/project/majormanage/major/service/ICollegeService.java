package com.ruoyi.project.majormanage.major.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.majormanage.major.domain.College;
import com.ruoyi.project.majormanage.major.domain.ReqCollegeListVO;

import java.util.List;

public interface ICollegeService extends IService<College> {
    /**
     * 根据条件查询学院信息
     * @param reqCollegeListVO
     * @return
     */
    List<College> list(ReqCollegeListVO reqCollegeListVO);
}
