package com.ruoyi.project.majormanage.student.service;

import com.ruoyi.project.majormanage.student.domain.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 根据专业号查询学生
     * @param majorId
     * @return
     */
    List<Student> selectStuByMajorId(Integer majorId);

    /**
     * 查询学生列表
     * @param student
     * @return
     */
    List<Student> selectStudentList(Student student);
    /**
     * 增加学生
     * @param student
     * @return
     */
    int insertStudent(Student student);
}
