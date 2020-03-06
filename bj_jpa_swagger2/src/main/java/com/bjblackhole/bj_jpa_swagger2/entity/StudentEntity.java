package com.bjblackhole.bj_jpa_swagger2.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Table(name = "student",indexes = {},uniqueConstraints = {})
@Entity
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 9149261403861253059L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="学生主键",dataType = "long")
    @Column(name = "student_id",columnDefinition = "bigint comment '学生主键id'")
    private Long studentId;

    @ApiModelProperty(value="学生姓名",dataType = "string")
    @Column(name = "student_name",columnDefinition = "varchar(255) comment '学生姓名'")
    private String studentName;

    @ApiModelProperty(value="班级编号",dataType = "int")
    @Column(name = "class_id",columnDefinition = "int comment '班级编号'")
    private Integer classId;


}
