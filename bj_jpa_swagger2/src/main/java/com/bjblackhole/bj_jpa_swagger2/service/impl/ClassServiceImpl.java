package com.bjblackhole.bj_jpa_swagger2.service.impl;

import com.bjblackhole.bj_jpa_swagger2.dao.ClassRepository;
import com.bjblackhole.bj_jpa_swagger2.dao.StudentRepository;
import com.bjblackhole.bj_jpa_swagger2.entity.ClassEntity;
import com.bjblackhole.bj_jpa_swagger2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:ClassService
 * Package:com.bjblackhole.bj_jpa_swagger2.service
 * Description:
 *
 * @Date:2020/03/04 0004 17:08
 * @Author:mavin001@163.com
 */
@Transactional
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRepository classRepository;

    @Override
    public ClassEntity selectOneByClassId(Integer classId) {
        ClassEntity classEntity = null;
        classEntity = classRepository.findOne(classId);
        return classEntity;
    }

    @Override
    public Boolean add(ClassEntity classEntity) {
        //防止null
        if (classEntity == null)
            return false;
        //保存
        classEntity = classRepository.saveAndFlush(classEntity);
        return classEntity != null;
    }

    @Override
    public Boolean update(ClassEntity classEntity) {
        Boolean flag = false;
        Integer classId = classEntity.getClassId();
        if (classId != null){
            ClassEntity entity = selectOneByClassId(classId);
            entity.setClassName(classEntity.getClassName());
            ClassEntity flush = classRepository.saveAndFlush(entity);
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean updateClassNameByClassId(Integer classId, String className) {
        Boolean flag = false;
        if (classId != null && className != null && !"".equals(className)){
            classRepository.updateClassNameByClassId(classId,className);
            flag = true;
        }
        return flag;
    }
}
