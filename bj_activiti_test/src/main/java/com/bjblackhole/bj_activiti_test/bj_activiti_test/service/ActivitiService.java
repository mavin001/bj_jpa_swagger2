package com.bjblackhole.bj_activiti_test.bj_activiti_test.service;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ActivitiService
 * Package:com.bjblackhole.bj_activiti_test.bj_activiti_test.service
 * Description:
 *
 * @Date:2020/03/03 0003 16:45
 * @Author:mavin001@163.com
 */
@Service
@Transactional
public class ActivitiService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    //开始流程,传传入申请者的id,及公司的id
    public void startProcess(Long personId,Long compId){
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("personId",personId);
        variables.put("compId",compId);
        runtimeService.startProcessInstanceByKey("joinProcess",variables);
    }

    //获得某个人的任务别表
    public List<Task> getTasks(String assignee){
        return taskService.createTaskQuery().taskCandidateUser(assignee).list();
    }

    //完成任务
    public void comleteTasks(Boolean joinApproved,String taskId){
        Map<String, Object> taskVariables = new HashMap<String,Object>();
        taskVariables.put("joinApproved", joinApproved);
        taskService.complete(taskId, taskVariables);
    }

}
