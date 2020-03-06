package com.bjblackhole.bj_activiti_test.bj_activiti_test.controller;

import com.bjblackhole.bj_activiti_test.bj_activiti_test.service.ActivitiService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:MyRestController
 * Package:com.bjblackhole.bj_activiti_test.bj_activiti_test.controller
 * Description:
 *
 * @Date:2020/03/03 0003 17:51
 * @Author:mavin001@163.com
 */
@RestController
public class MyRestController {
    @Autowired
    private ActivitiService activitiService;

    //完成任务
    @GetMapping(value = "/complete/{joinApproved}/{taskId}")
    public String complete(@PathVariable Boolean joinApproved,@PathVariable String taskId){
        activitiService.comleteTasks(joinApproved,taskId);
        return "ok";
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class TaskRepresentation{
        private String id;
        private String name;
    }

}
