package com.ruoyi.project.majormanage.major.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "x_college")
public class College {

    /* 学院ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /*学院名字*/
    @TableField(value = "name")
    private String name;

    /*创建时间*/
    @TableField(value = "create_time")
    private Date createTime;

    /*创建人*/
    @TableField(value = "create_by")
    private String createBy;

}
