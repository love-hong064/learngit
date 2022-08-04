package com.ruoyi.project.majormanage.student.service;

import com.ruoyi.project.majormanage.student.domain.Student;
import com.ruoyi.project.majormanage.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询专业学生
     * @param majorId
     * @return
     */
    @Override
    public List<Student> selectStuByMajorId(Integer majorId) {
        return studentMapper.selectStuByMajorId(majorId);
    }

    /**
     * 查询学生列表
     * @param student
     * @return
     */
    @Override
    public List<Student> selectStudentList(Student student) {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 获取学号
     * @param s
     * @return
     */
    private String getstudentId(Student s) {

        String sno = "";

        //step 1  根据年份、专业 查询学号最大号的学生
        List<Student> list = studentMapper.selectstuByYearMajorId(s);
        //step 2 计算学号
        if (list.size() == 0) {//第一个学生
            //判断补0
            String m = (s.getMajorId() > 9) ? "0" + s.getMajorId() : "00"+ s.getMajorId();
            sno = s.getInYear() + m + "001";
        } else {
            //获取学号 + 1
            String maxStuId = list.get(0).getStuId();
            String Id = maxStuId.substring(7,maxStuId.length());
            int parseInt = Integer.parseInt(Id)+1;
            //拼接学号
            String m = (s.getMajorId() > 9) ? "0"+ s.getMajorId() : "00" + s.getMajorId();
            sno = s.getInYear() + m + (parseInt > 9 ? (parseInt > 99 ? parseInt : "0"+parseInt):"00"+parseInt);
        }
        return sno;
    }

    /**
     * 增加学生信息
     * @param student
     * @return
     */
    @Override
    public int insertStudent(Student student) {
        student.setStuId(getstudentId(student));
        int rows = studentMapper.insertStudent(student);
        return rows;
    }
}
