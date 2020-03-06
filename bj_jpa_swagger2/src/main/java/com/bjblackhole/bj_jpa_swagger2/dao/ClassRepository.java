package com.bjblackhole.bj_jpa_swagger2.dao;

import com.bjblackhole.bj_jpa_swagger2.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * ClassName:ClassRepository
 * Package:com.bjblackhole.bj_jpa_swagger2.dao
 * Description:
 *
 * @Date:2020/03/04 0004 17:17
 * @Author:mavin001@163.com
 */
public interface ClassRepository extends BaseRepository<ClassEntity,Integer> {
    @Modifying
    @Query(value = "update ClassEntity set className = ?2 where classId = ?1")
    void updateClassNameByClassId(Integer classId, String className);
}
