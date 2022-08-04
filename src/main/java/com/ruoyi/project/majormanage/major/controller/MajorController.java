package com.ruoyi.project.majormanage.major.controller;

import com.ruoyi.common.constant.MajorConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.majormanage.major.domain.Major;
import com.ruoyi.project.majormanage.major.service.IMajorService;
import com.ruoyi.project.majormanage.student.domain.Student;
import com.ruoyi.project.majormanage.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专业信息
 * @author xhy
 */
@Controller
@RequestMapping("/majormanage/major")
public class MajorController extends BaseController {
    private String prefix = "majormanage/major";

    @Autowired
    private IMajorService majorService;

    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public String major(){
        return prefix + "/major";
    }
    /**
     * 分页查看专业信息
     * @param major
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Major major){
        startPage();
        List<Major> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 查看专业学生
     * @param majorId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{majorId}")
    public String detail(@PathVariable("majorId") Integer majorId, ModelMap mmap){
        mmap.put("majorId",majorId);
        return "majormanage/student/student";
    }
/**
 * 新增专业
 */
    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @Log(title = "专业管理",businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Major major){
        if(MajorConstants.MAJOR_NAME_NOT_UNIQUE.equals(majorService.checkMajorNameUnique(major.getMajorName()))){
            return error("新增专业'" + major.getMajorName() + "'失败，专业已存在！");
        }
        return toAjax(majorService.insertMajor(major));
    }

    @PostMapping("/checkMajorNameUnique")
    @ResponseBody
    public String checkMajorNameUnique(Major major){
        return majorService.checkMajorNameUnique(major.getMajorName());
    }


}
