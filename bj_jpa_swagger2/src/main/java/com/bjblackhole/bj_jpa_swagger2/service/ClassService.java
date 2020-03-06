package com.bjblackhole.bj_jpa_swagger2.service;

import com.bjblackhole.bj_jpa_swagger2.entity.ClassEntity;

/**
 * ClassName:ClassService
 * Package:com.bjblackhole.bj_jpa_swagger2.service
 * Description:
 *
 * @Date:2020/03/04 0004 17:08
 * @Author:mavin001@163.com
 */
public interface ClassService {
    ClassEntity selectOneByClassId(Integer classId);

    Boolean add(ClassEntity classEntity);

    Boolean update(ClassEntity classEntity);

    Boolean updateClassNameByClassId(Integer classId, String className);

}
