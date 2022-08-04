package com.ruoyi.project.majormanage.student.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.majormanage.major.domain.Major;
import com.ruoyi.project.majormanage.major.service.IMajorService;
import com.ruoyi.project.majormanage.student.domain.Student;
import com.ruoyi.project.majormanage.student.mapper.StudentMapper;
import com.ruoyi.project.majormanage.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生信息
 */
@Controller
@RequestMapping("/majormanage/student")
public class StudentController extends BaseController {
    private String prefix = "majormanage/student";

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IMajorService majorService;

    @GetMapping()
    public String student(){
        return prefix + "/student";
    }

    /**
     * 查看专业学生
     * @param majorId
     * @return
     */
    @PostMapping("/StudentList/{majorId}")
    @ResponseBody
    public TableDataInfo StudentList(@PathVariable("majorId") Integer majorId,Student student){
        student.setMajorId(majorId);
        startPage();
        List<Student> StuList = studentService.selectStudentList(student);
        return getDataTable(StuList);
    }

    /**
     * 增加专业学生
     * @param majorId
     * @param mmap
     * @return
     */
    @GetMapping("/add/{majorId}")
    public String add(@PathVariable("majorId") Integer majorId, ModelMap mmap){
        Major major = new Major();
       mmap.put("majorId",majorId);
       major.setMajorId(majorId);
       List<Major> majors = majorService.selectMajorList(major);
       mmap.put("majorName",majors.get(0).getMajorName());
       return prefix + "/add";
    }
    @Log(title = "专业管理",businessType = BusinessType.INSERT)
    @PostMapping("/add/{majorId}")
    @ResponseBody
    public AjaxResult addSave(@Validated Student student,@PathVariable("majorId") Integer majorId,ModelMap mmap){
        mmap.put("majorId",majorId);
        student.setMajorId(majorId);
        return toAjax(studentService.insertStudent(student));
    }

}
