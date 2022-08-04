package com.ruoyi.project.majormanage.student.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * 学生实体 x_student
 * @author xhy
 */
@Data
public class Student extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 学号 */
    @Excel(name = "学号")
    private String stuId;
    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;
    /** 专业ID */
    @Excel(name = "专业Id")
    private Integer majorId;
    /** 年龄 */
    @Excel(name = "年龄")
    private Integer stuAge;
    /** 性别 */
    @Excel(name = "性别")
    private String stuSex;
    /** 入学年份 */
    @Excel(name = "入学年份")
    private String inYear;
}
