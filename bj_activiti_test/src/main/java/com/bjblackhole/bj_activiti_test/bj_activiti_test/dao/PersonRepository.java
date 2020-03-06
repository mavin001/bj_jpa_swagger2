package com.bjblackhole.bj_activiti_test.bj_activiti_test.dao;

import com.bjblackhole.bj_activiti_test.bj_activiti_test.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:PersonRepository
 * Package:com.bjblackhole.bj_activiti_test.bj_activiti_test.dao
 * Description:
 *
 * @Date:2020/03/03 0003 16:42
 * @Author:mavin001@163.com
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByPersonName(String personName);
}
