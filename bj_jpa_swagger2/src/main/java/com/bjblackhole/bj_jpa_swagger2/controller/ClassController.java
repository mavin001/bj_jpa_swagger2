package com.bjblackhole.bj_jpa_swagger2.controller;

import com.bjblackhole.bj_jpa_swagger2.entity.ClassEntity;
import com.bjblackhole.bj_jpa_swagger2.model.ResultMap;
import com.bjblackhole.bj_jpa_swagger2.service.ClassService;
import com.bjblackhole.bj_jpa_swagger2.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ClassController
 * Package:com.bjblackhole.bj_jpa_swagger2.controller
 * Description:
 *
 * @Date:2020/03/04 0004 17:06
 * @Author:mavin001@163.com
 */
@Api(value = "class-controller", description = "班级管理")
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @ApiOperation(value = "添加班级信息", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求已成功！（是否查询出数据还需自行判断）"),
            @ApiResponse(code = 500, message = "服务内部出错"),
            @ApiResponse(code = 404, message = "访问路径出错")
    })
    @PostMapping("/add")
    public ResultMap add(@RequestBody ClassEntity classEntity) {
        ResultMap resultMap = ResultMap.error();
        try {
            //根据班级编号查询班级是否存在
            ClassEntity entity = classService.selectOneByClassId(classEntity.getClassId());
            //存在
            if (entity != null){
                return resultMap;
            } else {
                //不存在
                Boolean flag = classService.add(classEntity);
                if (flag) {
                    resultMap = ResultMap.success();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @ApiOperation(value = "根据班级主键id修改班级名称", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "classId", value = "班级主键id"),
            @ApiImplicitParam(paramType = "query", name = "className", value = "班级名称")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求已成功！（是否查询出数据还需自行判断）"),
            @ApiResponse(code = 500, message = "服务内部出错"),
            @ApiResponse(code = 404, message = "访问路径出错")
    })
    @PostMapping("/update")
    public ResultMap update(@RequestParam(value = "classId") Integer classId, @RequestParam(value = "className") String className) {
        ResultMap resultMap = ResultMap.error();
        try {
            Boolean flag = classService.updateClassNameByClassId(classId, className);
            if (flag) {
                resultMap = ResultMap.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
