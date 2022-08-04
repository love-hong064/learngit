package com.ruoyi.project.majormanage.major.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * 专业对象 x_major
 *
 * @author xhy
 */
@Data
public class Major extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 专业ID */
    @Excel(name = "专业Id")
    private Integer majorId;
    /** 专业名 */
    @Excel(name = "专业名")
    private String majorName;
    /** 描述 */
    @Excel(name = "描述")
    private String deScp;
    /** 备注 */
    @Excel(name = "备注")
    private String remark;

}
