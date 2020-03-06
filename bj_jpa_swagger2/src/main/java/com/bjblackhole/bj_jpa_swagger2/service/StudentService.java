package com.bjblackhole.bj_jpa_swagger2.service;

import com.bjblackhole.bj_jpa_swagger2.entity.StudentEntity;
import com.bjblackhole.bj_jpa_swagger2.model.StudentAndClass;

/**
 * ClassName:StudentService
 * Package:com.bjblackhole.bj_jpa_swagger2.service
 * Description:
 *
 * @Date:2020/03/04 0004 17:08
 * @Author:mavin001@163.com
 */
public interface StudentService {

    StudentEntity selectOneByStudentId(Long studentId);

    Boolean add(StudentEntity studentEntity);

    Boolean deleteByStudentId(Long studentId);

    StudentAndClass selectClassNameByStudentId(Long studentId);
}
