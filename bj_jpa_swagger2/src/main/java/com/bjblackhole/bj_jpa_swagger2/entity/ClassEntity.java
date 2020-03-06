package com.bjblackhole.bj_jpa_swagger2.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "class",indexes = {})
@Entity
public class ClassEntity implements Serializable {
    private static final long serialVersionUID = 9149261403861253059L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="班级编号",dataType = "int")
    @Column(name = "class_id",columnDefinition = "int comment '班级主键id'")
    private Integer classId;

    @ApiModelProperty(value="班级名称",dataType = "string")
    @Column(name = "class_name",columnDefinition = "varchar(255) comment '班级名称'")
    private String className;




}
