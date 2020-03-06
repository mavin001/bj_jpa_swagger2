package com.bjblackhole.bj_jpa_swagger2.service.impl;

import com.bjblackhole.bj_jpa_swagger2.dao.ClassRepository;
import com.bjblackhole.bj_jpa_swagger2.dao.StudentRepository;
import com.bjblackhole.bj_jpa_swagger2.entity.StudentEntity;
import com.bjblackhole.bj_jpa_swagger2.model.StudentAndClass;
import com.bjblackhole.bj_jpa_swagger2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:StudentService
 * Package:com.bjblackhole.bj_jpa_swagger2.service
 * Description:
 *
 * @Date:2020/03/04 0004 17:08
 * @Author:mavin001@163.com
 */
@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRepository classRepository;

    @Override
    public StudentEntity selectOneByStudentId(Long studentId) {
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
        return studentEntity;
    }

    @Override
    public Boolean add(StudentEntity studentEntity) {
        StudentEntity save = studentRepository.save(studentEntity);
        return save != null;
    }

    @Override
    public Boolean deleteByStudentId(Long studentId) {
        studentRepository.delete(studentId);
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
        return studentEntity == null;
    }

    @Override
    public StudentAndClass selectClassNameByStudentId(Long studentId) {
        System.out.println(studentId + "-----------------service");
        StudentAndClass studentAndClass = null;
        if (studentId == null)
            return studentAndClass;
        studentAndClass = studentRepository.selectStudentAndClass(studentId);
        return studentAndClass;

//        if (studentId != null){
////            StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
//            if (studentEntity != null && studentEntity.getClassId() != null){
//                ClassEntity classEntity = classRepository.findOne(studentEntity.getClassId());
//                if (classEntity != null){
//                    studentAndClass.setStudentId(studentEntity.getStudentId());
//                    studentAndClass.setStudentName(studentEntity.getStudentName());
//                    studentAndClass.setClassId(classEntity.getClassId());
//                    studentAndClass.setClassName(classEntity.getClassName());
//                    System.out.println(studentAndClass);
//                }
//            }
//        }
    }
}
