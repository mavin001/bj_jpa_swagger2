package com.bjblackhole.bj_activiti_test.bj_activiti_test.service;

import com.bjblackhole.bj_activiti_test.bj_activiti_test.dao.CompRepository;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.dao.PersonRepository;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.model.Comp;
import com.bjblackhole.bj_activiti_test.bj_activiti_test.model.Person;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:JoinService
 * Package:com.bjblackhole.bj_activiti_test.bj_activiti_test.service
 * Description:
 *
 * @Date:2020/03/03 0003 17:05
 * @Author:mavin001@163.com
 */
@Service
public class JoinService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CompRepository compRepository;

    //加入公司操作,可以DelegateExecution可以获取从流中的变量
    public void joinGroup(DelegateExecution execution){
        Boolean bool = (Boolean) execution.getVariable("joinApproved");
        if (bool){
            Long personId = (Long) execution.getVariable("personId");
            Long compId = (Long) execution.getVariable("compId");
            Comp comp = compRepository.findById(compId).get();
            Person person = personRepository.findById(personId).get();
            person.setComp(comp);
            personRepository.save(person);
            System.out.println("加入组织成功");
        } else
            System.out.println("加入组织失败");
    }

    //获取符合条件的审批人
    public List<String> findUsers(DelegateExecution execution){
        return Arrays.asList("abc","efg");
    }

}
