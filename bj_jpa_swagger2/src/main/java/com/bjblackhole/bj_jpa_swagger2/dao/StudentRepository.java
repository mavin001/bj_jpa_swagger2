package com.bjblackhole.bj_jpa_swagger2.dao;

import com.bjblackhole.bj_jpa_swagger2.entity.StudentEntity;
import com.bjblackhole.bj_jpa_swagger2.model.StudentAndClass;
import org.springframework.data.jpa.repository.Query;

/**
 * ClassName:StudentRepository
 * Package:com.bjblackhole.bj_jpa_swagger2.dao
 * Description:
 *
 * @Date:2020/03/04 0004 17:16
 * @Author:mavin001@163.com
 */
public interface StudentRepository extends BaseRepository<StudentEntity,Long> {

    StudentEntity findByStudentId(Long studentId);

    @Query(value = "select ")
    StudentAndClass selectStudentAndClass(Long studentId);
}