package com.ruoyi.project.majormanage.major.service;

import com.ruoyi.project.majormanage.major.domain.Major;

import java.util.List;

/**
 * 专业业务层
 * @author xhy
 */
public interface IMajorService {
    /**
     * 分页查询专业列表
     * @param major
     * @return
     */
    List<Major> selectMajorList(Major major);

    /**
     * 检查专业名是否唯一
     * @param majorName
     * @return
     */
    String checkMajorNameUnique(String majorName);

    /**
     * 新增专业
     * @param major
     * @return
     */
    int insertMajor(Major major);
}
