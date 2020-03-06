package com.bjblackhole.bj_jpa_swagger2.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * ClassName:StudentAndClass
 * Package:com.bjblackhole.bj_jpa_swagger2.model
 * Description:
 *
 * @Date:2020/03/05 0005 16:14
 * @Author:mavin001@163.com
 */
public class StudentAndClass implements Serializable {
    private static final long serialVersionUID = -6967260347671063370L;
    @ApiModelProperty(value="学生主键",dataType = "long")
    private Long studentId;
    @ApiModelProperty(value="学生姓名",dataType = "string")
    private String studentName;
    @ApiModelProperty(value="班级编号",dataType = "int")
    private Integer classId;
    @ApiModelProperty(value="班级名称",dataType = "string")
    private String className;

    public StudentAndClass() {
    }

    public StudentAndClass(Long studentId, String studentName, Integer classId, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.className = className;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId==null?0L:studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StudentAndClass{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
