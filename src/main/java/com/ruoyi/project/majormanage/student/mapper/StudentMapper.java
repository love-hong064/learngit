package com.ruoyi.project.majormanage.student.mapper;

import com.ruoyi.project.majormanage.student.domain.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 按专业号查询学生
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
     * 按专业和年份查出最大学号的学生信息
     * @param student
     * @return
     */
    List<Student> selectstuByYearMajorId(Student student);
    /**
     * 增加学生
     * @param student
     * @return
     */
    int insertStudent(Student student);


}
