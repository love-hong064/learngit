package com.ruoyi.project.majormanage.major.mapper;

import com.ruoyi.project.majormanage.major.domain.Major;


import java.util.List;

public interface MajorMapper {
    /**
     * 查询专业列表
     * @param major
     * @return
     */
    List<Major> selectMajorList(Major major);

    /**
     * 检查专业名是否唯一
     * @param majorName
     * @return
     */
    int checkMajorNameUnique(String majorName);

    /**
     * 新增专业
     * @param major
     * @return
     */
    int insertMajor(Major major);
}
